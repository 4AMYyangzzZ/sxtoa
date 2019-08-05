package com.bjsxt.controller;

import com.bjsxt.pojo.Auditing;
import com.bjsxt.pojo.Employee;
import com.bjsxt.pojo.Expense;
import com.bjsxt.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    public ExpenseService getExpenseService() {
        return expenseService;
    }

    public void setExpenseService(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
    @RequestMapping("/addExpense.do")
    public String addExpense(Expense expense, String []type, double[]amount, String []itemDesc, HttpServletRequest request) throws ServletException, IOException {
        try {
            expenseService.addExpense(expense,type,amount,itemDesc);
            return "/expense/myExpense.jsp";
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("error","添加报销失败" );
           return "/expense/expenseAdd.jsp";
        }
    }

    @RequestMapping("/myExpense.do")
    @ResponseBody
    public List<Expense> myExpense(HttpSession session){
        Employee user = (Employee) session.getAttribute("user");
        return expenseService.myExpense(user.getEmpid());
    }

    @RequestMapping("/toAudit.do")
    public String toAudit(HttpSession session,HttpServletRequest request){
        Employee user = (Employee) session.getAttribute("user");
        request.setAttribute("expList", expenseService.toAudit(user.getEmpid()));
        return "/expense/toAudit.jsp";
    }

    @RequestMapping(value = "/audit.do",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String audit(Auditing auditing,HttpSession session){
        try {
            Employee user = (Employee) session.getAttribute("user");
            expenseService.audit(auditing,user);
            return "审核成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "审核失败";
        }
    }
}
