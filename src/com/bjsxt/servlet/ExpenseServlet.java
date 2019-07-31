package com.bjsxt.servlet;

import com.bjsxt.entity.*;
import com.bjsxt.service.ExpenseService;
import com.bjsxt.service.impl.ExpenseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpenseServlet extends BaseServlet {
    public void addExpense(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CombineDeptAndEmpAndPos emp=(CombineDeptAndEmpAndPos)request.getSession().getAttribute("emp");
        String empId=emp.getEmpId();
        double totalAmount=0;
        Date expTime=new Date();
        String[] types = request.getParameterValues("type");
        String[] amounts = request.getParameterValues("amount");
        String[] itemDescs = request.getParameterValues("itemDesc");
        List<ExpenseItem> list =new ArrayList<>();
        for (int i = 0; i <types.length ; i++) {
            ExpenseItem item=new ExpenseItem(types[i],Double.parseDouble(amounts[i]),itemDescs[i]);
            list.add(item);
            totalAmount+=Double.parseDouble(amounts[i]);
        }
        String nextAuditor=request.getParameter("nextAuditor") ;
        String expDesc=request.getParameter("expDesc");
        Expense expense=new Expense( empId, totalAmount,  expTime, expDesc, nextAuditor, "尚未审核", "0",  list);
        ExpenseService expenseService=new ExpenseServiceImpl();
        try {
            expenseService.addExpense(expense);
            request.getRequestDispatcher("/expense/expenseList.jsp").forward(request,response);
        }catch (Exception e){
            request.setAttribute("error",e.getMessage());
            request.getRequestDispatcher("/expense/expenseAdd.jsp").forward(request,response);
        }

    }
    public void toAudit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        CombineDeptAndEmpAndPos emp = (CombineDeptAndEmpAndPos) request.getSession().getAttribute("emp");
        ExpenseService expenseService=new ExpenseServiceImpl();
        List<Expense>expList=expenseService.toAudit(emp.getEmpId());
        request.setAttribute("expList",expList);
        request.getRequestDispatcher("/expense/toAudit.jsp").forward(request,response);
    }

    public void audit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        int expId=Integer.parseInt(request.getParameter("expId"));
        String result=request.getParameter("result");
        String auditDesc=request.getParameter("auditDesc");
        ExpenseService expenseService=new ExpenseServiceImpl();
        CombineDeptAndEmpAndPos emp=(CombineDeptAndEmpAndPos)request.getSession().getAttribute("emp");
        String empId=emp.getEmpId();
        Date time=new Date();
        //Date time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new Date().toString());
        Auditing auditing=new Auditing(expId, empId, result, auditDesc, time);
        response.setContentType("text/html;charset=utf-8");
        try {
            expenseService.audit(auditing);
            response.getWriter().println("审核成功");
        }catch (Exception e){
            e.printStackTrace();
            response.getWriter().println("审核失败");
        }
    }
}
