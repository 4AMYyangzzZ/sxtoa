package com.bjsxt.controller;

import com.bjsxt.pojo.Department;
import com.bjsxt.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping("/addDepartment.do")
    public void addDepartment(Department department, Model model, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
       int i= departmentService.addDepartment(department);
       if (i>0){
               response.sendRedirect("/selectAllDept.do");
       }else {
           model.addAttribute("error","添加部门失败" );
           request.getRequestDispatcher("/system/deptAdd.jsp").forward(request,response );
       }
    }

    @RequestMapping("/selectAllDept.do")
    public String selectAllDept( Model model){
        List<Department> departmentList=departmentService.selectAllDept();
        model.addAttribute("deptList", departmentList);
        return "/system/deptList.jsp";
    }

    @RequestMapping("/selectDeptById.do")
    public String selectDeptById(String deptNo,Model model){
        Department department=departmentService.selectDeptById(deptNo);
        model.addAttribute("dept", department);
        return "/system/deptUpdate.jsp";
    }

   @RequestMapping("/updateDeptById.do")
    public void updateDeptById(Department department,Model model, HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
        int i=departmentService.updateDeptById(department);
        if (i>0){
            response.sendRedirect("/selectAllDept.do");
        }else {
            model.addAttribute("error","修改部门失败" );
            request.getRequestDispatcher("/system/deptUpdate.jsp").forward(request,response );
        }
   }

   @RequestMapping("/deleteDeptById.do")
    public void deleteDeptById(String deptNo,Model model,HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        int i=departmentService.deleteDeptById(deptNo);
        if (i>0){
            response.sendRedirect("/selectAllDept.do");
        }else {
            model.addAttribute("error","删除部门失败" );
            request.getRequestDispatcher("/system/deptList.jsp").forward(request,response );
        }
   }
}
