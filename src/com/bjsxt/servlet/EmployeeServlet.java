package com.bjsxt.servlet;

import com.bjsxt.entity.*;
import com.bjsxt.service.EmployeeService;
import com.bjsxt.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialStruct;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EmployeeServlet extends BaseServlet {
    public void empAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empId=request.getParameter("empId");
        String mgr=request.getParameter("mgr");
        int posId=Integer.parseInt(request.getParameter("pos"));
        int deptNo=Integer.parseInt(request.getParameter("dept"));
        //String password=request.getParameter("password");
        String password="root";
        String realName=request.getParameter("realName");
        String sex=request.getParameter("sex");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate=null;
        try {
            birthDate=sdf.parse(request.getParameter("birthDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date hireDate=null;
        try {
            hireDate=sdf.parse(request.getParameter("hireDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date leaveDate=null;
        try {
            leaveDate=sdf.parse(request.getParameter("leaveDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int onDuty=Integer.parseInt(request.getParameter("onDuty"));
        int empType=Integer.parseInt(request.getParameter("empType"));
        String phone=request.getParameter("phone");
        String qq=request.getParameter("qq");
        String emerContactPerson=request.getParameter("emerContactPerson");
        String idCard=request.getParameter("idCard");

        Employee emp=new Employee(empId, mgr,  posId,  deptNo, password,realName,  sex,  birthDate,hireDate,  leaveDate,  onDuty,  empType, phone, qq, emerContactPerson,  idCard);
        EmployeeService employeeService=new EmployeeServiceImpl();
        boolean flag=employeeService.empAdd(emp);
        if (flag){
            response.sendRedirect(request.getContextPath()+"/servlet/EmployeeServlet?method=empFindAll");
        }else {
            request.setAttribute("error","员工添加失败");
            request.getRequestDispatcher("/system/empAdd.jsp").forward(request,response);
        }
    }

    public void posAndDeptAndMgrFindAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flag=request.getParameter("flag");
        String empId=request.getParameter("empId");
        EmployeeService employeeService=new EmployeeServiceImpl();
        //由于部门列表信息多次用到，故将它写入application中
        List<Department> deptList = employeeService.deptFindAll();
        HttpSession application = request.getSession();
        //request.setAttribute("deptList",deptList);
        application.setAttribute("deptList",deptList);
        List<Position> posList = employeeService.posFindAll();
        request.setAttribute("posList",posList);
        List<CombineMgr>mgrList=employeeService.mgrFindAll();
        request.setAttribute("mgrList",mgrList);
        if (flag.equals("add")){
            request.getRequestDispatcher("/system/empAdd.jsp").forward(request,response);
        }else if(flag.equals("update")){
            mgrList=employeeService.mgrFindAllExcludeSelef(empId);
            request.setAttribute("mgrList",mgrList);
            request.getRequestDispatcher("/servlet/EmployeeServlet?method=empInfoById&flag=update&empId="+empId).forward(request,response);
        }else if(flag.equals("select")){
            request.getRequestDispatcher("/servlet/EmployeeServlet?method=empFindAll").forward(request,response);
        }
    }

    public void empFindAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeService employeeService=new EmployeeServiceImpl();
        List<CombineDeptAndEmpAndPos>empList=employeeService.empFindAll();
        request.setAttribute("empList",empList);
        request.getRequestDispatcher("/system/empList.jsp").forward(request,response);
    }

    public void empInfoById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flag=request.getParameter("flag");
        String empId=request.getParameter("empId");
        EmployeeService employeeService=new EmployeeServiceImpl();
       CombineDeptAndEmpAndPos emp=employeeService.empInfoById(empId);
        request.setAttribute("emp",emp);
        if (flag.equals("check")){
            request.getRequestDispatcher("/system/empInfo.jsp").forward(request,response);
        }else if (flag.equals("update")){
            request.getRequestDispatcher("/system/empUpdate.jsp").forward(request,response);
        }
    }

    public void empUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empId=request.getParameter("empId");
        String mgr=request.getParameter("mgr");
        int deptNo=Integer.parseInt(request.getParameter("dept"));

        //String password=request.getParameter("password");
        String password="root";
        String realName=request.getParameter("realName");
        String sex=request.getParameter("sex");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate=null;
        try {
            birthDate=sdf.parse(request.getParameter("birthDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date hireDate=null;
        try {
            hireDate=sdf.parse(request.getParameter("hireDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date leaveDate=null;
        try {
            leaveDate=sdf.parse(request.getParameter("leaveDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int onDuty=Integer.parseInt(request.getParameter("onDuty"));
        String phone=request.getParameter("phone");
        String qq=request.getParameter("qq");
        String emerContactPerson=request.getParameter("emerContactPerson");
        String idCard=request.getParameter("idCard");
        EmployeeService employeeService=new EmployeeServiceImpl();
        Employee emp=new Employee(empId, mgr,  0,  deptNo, password,realName,  sex,  birthDate,hireDate,  leaveDate,  onDuty,  0, phone, qq, emerContactPerson,  idCard);
        boolean flag=employeeService.empUpdate(emp);
        if (flag){
            response.sendRedirect(request.getContextPath()+"/servlet/EmployeeServlet?method=empFindAll");
        }else {
            request.setAttribute("error","员工添加失败");
            request.getRequestDispatcher("/servlet/EmployeeServlet?method=empInfoById&empId=${emp.empId}&flag=update").forward(request,response);
        }
    }

    public void empDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empId=request.getParameter("empId");
        EmployeeService employeeService=new EmployeeServiceImpl();
        boolean flag=employeeService.empDelete(empId);
        if (flag){
            request.getRequestDispatcher("/servlet/EmployeeServlet?method=empFindAll").forward(request,response);
        }else{
            request.setAttribute("error","员工删除失败");
            request.getRequestDispatcher("/system/empList.jsp").forward(request,response);
        }
    }

    public void empQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empId=request.getParameter("empId");
        int deptNo=Integer.parseInt(request.getParameter("dept"));
        int onDuty;

            if (request.getParameter("onDuty")==null){
                onDuty=-1;
            }else {
                onDuty=Integer.parseInt(request.getParameter("onDuty"));
            }


        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date hireDate=null;
        String date=request.getParameter("hireDate");
        try {
            if (!"".equals(date) && date!=null){
                hireDate=java.sql.Date.valueOf(date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        EmployeeService employeeService=new EmployeeServiceImpl();
        List<CombineDeptAndEmpAndPos>empList=employeeService.empQuery(empId,deptNo,onDuty,hireDate);
        request.setAttribute("empList",empList);
        request.setAttribute("empId",empId);
        request.setAttribute("deptNo",deptNo);
        request.setAttribute("onDuty",onDuty);
        request.setAttribute("hireDate",hireDate);
        request.getRequestDispatcher("/system/empList.jsp").forward(request,response);
    }
    public void modifyPwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empId=request.getParameter("empId");
        EmployeeService employeeService=new EmployeeServiceImpl();
       boolean flag=employeeService.modifyPwd(empId);
        if (flag){
            request.setAttribute("pwdInfo","重置密码成功");
            request.getRequestDispatcher("/servlet/EmployeeServlet?method=posAndDeptAndMgrFindAll&flag=select").forward(request,response);
        }else {
            request.setAttribute("pwdInfo","重置密码失败");
            request.getRequestDispatcher("/servlet/EmployeeServlet?method=posAndDeptAndMgrFindAll&flag=select").forward(request,response);
        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empId=request.getParameter("empId");
        String password=request.getParameter("password");
        String verify=(String) request.getSession().getAttribute("randStr");
        if (!verify.equals(request.getParameter("verify"))){
            request.setAttribute("error","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        EmployeeService employeeService=new EmployeeServiceImpl();
        CombineDeptAndEmpAndPos emp=employeeService.empInfoById(empId,password);
        if (emp!=null){
            request.getSession().setAttribute("emp",emp);
            request.getRequestDispatcher("/main.jsp").forward(request,response);
        }else {
            request.setAttribute("error","用户名或者密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }

}
