package com.bjsxt.servlet;

import com.bjsxt.dao.impl.IncomeDaoImpl;
import com.bjsxt.entity.CombineDeptAndEmpAndPos;
import com.bjsxt.entity.Department;
import com.bjsxt.entity.Employee;
import com.bjsxt.entity.Income;
import com.bjsxt.service.DepartmentService;
import com.bjsxt.service.InoutService;
import com.bjsxt.service.impl.DepartmentServiceImpl;
import com.bjsxt.service.impl.InoutServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class InoutServlet extends BaseServlet {
    public void getIncomeData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InoutService inoutService=new InoutServiceImpl();
        String str=inoutService.getIncomeData();
        //String str="[[\"衬衫\",\"羊毛衫\",\"雪纺衫\",\"裤子\",\"高跟鞋\",\"袜子\"],[5, 20, 36, 10, 10, 20]]";
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(str);
    }

    public void getPaymentData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InoutService inoutService=new InoutServiceImpl();
        String str=inoutService.getPaymentData();
//        String str="[['直接访问','邮件营销','联盟广告','视频广告','搜索引擎'],[\n" +
//                "                                   {value:335, name:'直接访问'},\n" +
//                "                                   {value:310, name:'邮件营销'},\n" +
//                "                                   {value:234, name:'联盟广告'},\n" +
//                "                                   {value:135, name:'视频广告'},\n" +
//                "                                   {value:1548, name:'搜索引擎'}\n" +
//                "                               ]]";
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(str);
    }

    public void getDeptAndIncomeType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentService departmentService=new DepartmentServiceImpl();
        CombineDeptAndEmpAndPos emp=(CombineDeptAndEmpAndPos)request.getSession().getAttribute("emp");
        Department dept=departmentService.findDeptByEmpId(emp.getEmpId());
        InoutService inoutService=new InoutServiceImpl();
        List<Income> incomeList=inoutService.getAllIncome();
        System.out.println(incomeList.size());
        request.setAttribute("dept",dept);
        request.setAttribute("incomeList",incomeList);
        request.getRequestDispatcher("/inout/incomeAdd.jsp").forward(request,response);
    }

    public void incomeAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int amount=0;
        if (request.getParameter("amount")!=null){
            amount=Integer.parseInt(request.getParameter("amount"));
        }
        String incomeType=request.getParameter("incomeType");

        Date incomeDate=null;
        try {
             incomeDate=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("incomeDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String incomeDesc=request.getParameter("incomeDesc");
        CombineDeptAndEmpAndPos emp=(CombineDeptAndEmpAndPos)request.getSession().getAttribute("emp");
        Income income=new Income(emp.getEmpId(),amount,incomeDate,incomeType,incomeDesc);
        InoutService inoutService=new InoutServiceImpl();
        boolean flag=inoutService.incomeAdd(income);
        if (flag){
            request.getRequestDispatcher("/inout/incomeList.jsp").forward(request,response);
        }else {
            request.setAttribute("error","添加收入失败");
            request.getRequestDispatcher("/inout/incomeAdd.jsp").forward(request,response);
        }
    }

}
