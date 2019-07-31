package com.bjsxt.servlet;

import com.bjsxt.entity.Department;
import com.bjsxt.service.DepartmentService;
import com.bjsxt.service.impl.DepartmentServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DepartmentServlet extends BaseServlet {


    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int deptNo=Integer.parseInt(request.getParameter("deptNo"));
        String deptName=request.getParameter("deptName");
        String location=request.getParameter("location");

        Department dept=new Department(deptNo,deptName,location);
        DepartmentService departmentService=new DepartmentServiceImpl();
        boolean flag=departmentService.update(dept);

        if (flag){
            response.sendRedirect(request.getContextPath()+"/servlet/DepartmentServlet?method=findAll");
        }else {
            request.setAttribute("error","部门修改失败");
            request.getRequestDispatcher("/servlet/DepartmentServlet?method=findById&deptNo="+deptNo).forward(request,response);
        }
    }
    public void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int deptNo=Integer.parseInt(request.getParameter("deptNo"));
        DepartmentService departmentService=new DepartmentServiceImpl();
        Department dept=departmentService.findById(deptNo);
        request.setAttribute("dept",dept);
        request.getRequestDispatcher("/system/deptUpdate.jsp").forward(request,response);
    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int deptNo=Integer.parseInt(request.getParameter("deptNo"));
        String deptName=request.getParameter("deptName");
        String location=request.getParameter("location");

        Department dept=new Department(deptNo,deptName,location);
        DepartmentService departmentService=new DepartmentServiceImpl();
        boolean flag=departmentService.add(dept);

        if (flag){
            response.sendRedirect(request.getContextPath()+"/servlet/DepartmentServlet?method=findAll");
        }else {
            request.setAttribute("error","部门添加失败");
            request.getRequestDispatcher("/system/deptAdd.jsp").forward(request,response);
        }
    }

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentService departmentService=new DepartmentServiceImpl();
        List<Department> deptList=departmentService.findAll();
        request.setAttribute("deptList",deptList);
        request.getRequestDispatcher("/system/deptList.jsp").forward(request,response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int deptNo=Integer.parseInt(request.getParameter("deptNo"));

        DepartmentService departmentService=new DepartmentServiceImpl();
        boolean flag=departmentService.delete(deptNo);

        if (flag){
            response.sendRedirect(request.getContextPath()+"/servlet/DepartmentServlet?method=findAll");
        }
    }

    public void findAllAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentService departmentService=new DepartmentServiceImpl();
        List<Department> deptList=departmentService.findAll();
        Gson gson=new Gson();
        String s = gson.toJson(deptList);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(s);
    }

}
