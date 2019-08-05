package com.bjsxt.service.impl;

import com.bjsxt.exception.MyException;
import com.bjsxt.mapper.AuditMapper;
import com.bjsxt.mapper.ExpenseItemMapper;
import com.bjsxt.mapper.ExpenseMapper;
import com.bjsxt.mapper.PaymentMapper;
import com.bjsxt.pojo.*;
import com.bjsxt.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    private ExpenseMapper expenseMapper;
    @Autowired
    private ExpenseItemMapper expenseItemMapper;
    @Autowired
    private AuditMapper auditMapper;
    @Autowired
    private PaymentMapper paymentMapper;

    public PaymentMapper getPaymentMapper() {
        return paymentMapper;
    }

    public void setPaymentMapper(PaymentMapper paymentMapper) {
        this.paymentMapper = paymentMapper;
    }

    public AuditMapper getAuditMapper() {
        return auditMapper;
    }

    public void setAuditMapper(AuditMapper auditMapper) {
        this.auditMapper = auditMapper;
    }

    public ExpenseItemMapper getExpenseItemMapper() {
        return expenseItemMapper;
    }

    public void setExpenseItemMapper(ExpenseItemMapper expenseItemMapper) {
        this.expenseItemMapper = expenseItemMapper;
    }

    public ExpenseMapper getExpenseMapper() {
        return expenseMapper;
    }

    public void setExpenseMapper(ExpenseMapper expenseMapper) {
        this.expenseMapper = expenseMapper;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,rollbackFor = MyException.class)
    public void addExpense(Expense expense, String[] type, double[] amount, String[] itemDesc) {
        double totalAmount=0;
        List<ExpenseItem> list=new ArrayList<>();
        for (int i = 0; i <type.length ; i++) {
            ExpenseItem expenseItem=new ExpenseItem();
            expenseItem.setAmount(amount[i]);
            expenseItem.setType(type[i]);
            expenseItem.setItemDesc(itemDesc[i]);
            list.add(expenseItem);
            totalAmount+=amount[i];
        }
        try {
            expense.setTotalAmount(totalAmount);
            expense.setExpTime(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
            expense.setList(list);
            expense.setLastResult("尚未审核");
            expense.setStatus("0");
            expenseMapper.addExpense(expense);
            for (int i = 0; i <list.size() ; i++) {
               list.get(i).setExpId(expense.getExpId());
                expenseItemMapper.addExpenseItem(list.get(i));
            }
        } catch (ParseException e) {
            e.printStackTrace();
            throw new MyException("不好了，出异常了");
        }

    }

    @Override
    public List<Expense> myExpense(String empid) {
        return expenseMapper.myExpense(empid);
    }

    @Override
    public List<Expense> toAudit(String empid) {
        return expenseMapper.toAudit(empid);
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,rollbackFor = MyException.class)
    public void audit(Auditing auditing, Employee user) {
        //为auditing对象赋值
        auditing.setEmpId(user.getEmpid());
        auditing.setTime(new Date());

        //获得审核的结果
        String result = auditing.getResult();
        //得到该报销单的信息,便于修改报销单信息
        Expense expense=expenseMapper.findExpenseById(auditing.getExpId());
        if ("通过".equals(result)){
            if (auditing.getEmpId().equals("mifeng")){//如果是财务
                //添加支出记录
                Payment payment=new Payment();
                payment.setPayEmpId(auditing.getEmpId());
                payment.setAmount(expense.getTotalAmount());
                payment.setDate(auditing.getTime());
                payment.setExpId(auditing.getExpId());
                payment.setEmpId(expense.getEmpId());
                paymentMapper.addPayment(payment);
                //修改报销单状态
                Expense expense1=new Expense();
                expense1.setExpId(expense.getExpId());
                expense1.setLastResult(auditing.getResult());
                expense1.setNextAuditor(null);
                expense1.setStatus("5");
                expenseMapper.updateExpense(expense1);
            }else {//不是财务
                //获得该审核的总钱数
                if (expense.getTotalAmount()>5000){
                    //如果是总裁
                    if(auditing.getEmpId().equals("godV")){

                        //添加审核记录
                        auditMapper.addAudit(auditing);
                        //修改报销单状态
                        Expense expense1=new Expense();
                        expense1.setExpId(expense.getExpId());
                        expense1.setLastResult(auditing.getResult());
                        expense1.setNextAuditor("mifeng");
                        expense1.setStatus("1");
                        expenseMapper.updateExpense(expense1);
                    }else {
                        //不是总裁
                        //添加审核记录
                        auditMapper.addAudit(auditing);
                        //修改报销单状态
                        Expense expense1=new Expense();
                        expense1.setExpId(expense.getExpId());
                        expense1.setLastResult(auditing.getResult());
                        expense1.setNextAuditor("godV");
                        expense1.setStatus("1");
                        expenseMapper.updateExpense(expense1);
                    }
                }else {
                    //不超过5000
                    //添加审核记录
                    auditMapper.addAudit(auditing);
                    //修改报销单状态
                    Expense expense1=new Expense();
                    expense1.setExpId(expense.getExpId());
                    expense1.setLastResult(auditing.getResult());
                    expense1.setNextAuditor("mifeng");
                    expense1.setStatus("1");
                    expenseMapper.updateExpense(expense1);
                }
            }
        }else {//拒绝或者打回
            //添加审核记录
            auditMapper.addAudit(auditing);
            //修改报销单状态
            Expense expense1=new Expense();
            expense1.setExpId(expense.getExpId());
            expense1.setLastResult(auditing.getResult());
            expense1.setNextAuditor(null);
            if ("拒绝".equals(result)){
                expense1.setStatus("3");
            }else {//打回
                expense1.setStatus("4");
            }
            expenseMapper.updateExpense(expense1);
        }
    }
}
