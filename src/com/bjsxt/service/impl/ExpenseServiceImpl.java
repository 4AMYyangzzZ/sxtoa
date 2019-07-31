package com.bjsxt.service.impl;

import com.bjsxt.dao.AuditingDao;
import com.bjsxt.dao.ExpenseDao;
import com.bjsxt.dao.ExpenseItemDao;
import com.bjsxt.dao.PaymentDao;
import com.bjsxt.dao.impl.AuditingDaoImpl;
import com.bjsxt.dao.impl.ExpenseDaoImpl;
import com.bjsxt.dao.impl.ExpenseItemDaoImpl;
import com.bjsxt.dao.impl.PaymentDaoImpl;
import com.bjsxt.entity.Auditing;
import com.bjsxt.entity.Expense;
import com.bjsxt.entity.ExpenseItem;
import com.bjsxt.entity.Payment;
import com.bjsxt.service.ExpenseService;
import com.bjsxt.util.DBUtil2;
import com.bjsxt.util.MyException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ExpenseServiceImpl implements ExpenseService {
    private ExpenseDao expenseDao=new ExpenseDaoImpl();
    private ExpenseItemDao expenseItemDao=new ExpenseItemDaoImpl();
    private AuditingDao auditingDao=new AuditingDaoImpl();
    private PaymentDao paymentDao=new PaymentDaoImpl();
    //0 尚未审核 1 审核中 2审核成功 3审核拒绝 4审核打回 5财务打款
    @Override
    public void audit(Auditing auditing) {
        Connection conn=DBUtil2.getConnection();
        try {
            conn.setAutoCommit(false);
            String result=auditing.getResult();
            Expense expense=expenseDao.find(auditing.getExpId());
            if (result.equals("通过")){
                if (auditing.getEmpId().equals("mifeng")){
                    //添加支出记录
                    Payment payment=new Payment();
                    payment.setExpId(auditing.getExpId());
                    payment.setPayEmpId(auditing.getEmpId());
                    payment.setAmount(expense.getTotalAmount());
                    payment.setDate(auditing.getTime());
                    payment.setEmpId(expense.getEmpId());
                    paymentDao.save(payment);
                   // auditingDao.addAudit(auditing);
                    //修改报销单状态
                    Expense expense1=new Expense();
                    expense1.setExpId(expense.getExpId());
                    expense1.setNextAuditor(null);
                    expense1.setLastResult(auditing.getResult());
                    expense1.setStatus("5");
                    expenseDao.updateExp(expense1);
                }else{//不是财务
                    //获得该审核的总钱数

                    if(expense.getTotalAmount()>5000){
                        if (auditing.getEmpId().equals("godV")){
                            //添加审核记录
                            auditingDao.addAudit(auditing);
                            //修改报销单状态
                            Expense expense1=new Expense();
                            expense1.setExpId(expense.getExpId());
                            expense1.setNextAuditor("mifeng");
                            expense1.setLastResult(auditing.getResult());
                            expense1.setStatus("1");
                            expenseDao.updateExp(expense1);
                        }else {//不是总裁
                            //添加审核记录
                            auditingDao.addAudit(auditing);
                            //修改报销单状态
                            Expense expense1=new Expense();
                            expense1.setExpId(expense.getExpId());
                            expense1.setNextAuditor("godV");
                            expense1.setLastResult(auditing.getResult());
                            expense1.setStatus("1");
                            expenseDao.updateExp(expense1);
                        }
                    }else {//不超过5000
                         //添加审核记录
                        auditingDao.addAudit(auditing);
                        //修改报销单状态
                        Expense expense1=new Expense();
                        expense1.setExpId(expense.getExpId());
                        expense1.setNextAuditor("mifeng");
                        expense1.setLastResult(auditing.getResult());
                        expense1.setStatus("1");
                        expenseDao.updateExp(expense1);
                    }
                }

            }else {//审核拒绝或者打回
                //添加审核记录
                auditingDao.addAudit(auditing);
                //修改报销单状态
                Expense expense1=new Expense();
                expense1.setExpId(expense.getExpId());
                expense1.setNextAuditor(null);
                expense1.setLastResult(auditing.getResult());
                if ("打回".equals(result)){
                    expense1.setStatus("4");
                }else {
                    expense1.setStatus("3");
                }
                expenseDao.updateExp(expense1);
            }
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw new MyException(e.getMessage());
        }finally {
            DBUtil2.closeAll(null,null,conn);
        }
    }

    @Override
    public List<Expense> toAudit(String empId) {
        return expenseDao.findExpById(empId);
    }

    @Override
    public void addExpense(Expense expense) {
        Connection conn= DBUtil2.getConnection();
        try {
            conn.setAutoCommit(false);
            //添加数据进入expense表并返回expId
            int expId=expenseDao.addExpense(expense);
            //添加数据进入expenseItem中
            List<ExpenseItem> list = expense.getList();
            for (int i = 0; i <list.size() ; i++) {
                ExpenseItem item=new ExpenseItem(expId,list.get(i).getType(),list.get(i).getAmount(),list.get(i).getItemDesc());
                expenseItemDao.addExpenseItem(item);
            }
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
                throw new MyException(e.getMessage());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            DBUtil2.closeAll(null,null,conn);
        }
    }
}
