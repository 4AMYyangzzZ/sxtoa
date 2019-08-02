package com.bjsxt.controller;

import com.bjsxt.pojo.Department;
import com.bjsxt.pojo.Employee;
import com.bjsxt.pojo.Position;
import com.bjsxt.service.DepartmentService;
import com.bjsxt.service.EmployeeService;
import com.bjsxt.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private PositionService positionService;


    public PositionService getPositionService() {
        return positionService;
    }

    public void setPositionService(PositionService positionService) {
        this.positionService = positionService;
    }

    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/login.do")
    public String login(Employee employee, Model model, HttpSession session){
        if (employeeService.login(employee)==null){
            model.addAttribute("error", "用户名或者密码错误");
            return "login.jsp";
        }else {
            session.setAttribute("user",employee );
            return "main.jsp";
        }
    }

    @RequestMapping("/selectRequiredInfo.do")
    public String selectRequiredInfo(Model model){
        //查询所有的部门
        List<Department> departmentList = departmentService.selectAllDept();
        //查询所有的岗位
        List<Position> positionList = positionService.selectAllPos();
        //查询所有的上级领导
        List<Employee>employeeList=employeeService.selectAllLeader();
        model.addAttribute("deptList",departmentList );
        model.addAttribute("posList", positionList);
        model.addAttribute("mgrList", employeeList);
        return "/system/empAdd.jsp";
    }

    @RequestMapping("/selectAllEmp.do")
    public String selectAllEmp(Model model){
        List<Employee> employeeList=employeeService.selectAllEmp();
        List<Department> departmentList = departmentService.selectAllDept();
        model.addAttribute("deptList",departmentList );
        model.addAttribute("empList", employeeList);
        return "/system/empList.jsp";
    }
    @RequestMapping("/addEmployee.do")
    public void addEmployee(Employee employee, Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int i=employeeService.addEmployee(employee);
        if(i>0){
           response.sendRedirect("/selectAllEmp.do");
        }else {
            model.addAttribute("error","添加用户失败" );
            request.getRequestDispatcher("/system/empAdd.jsp").forward(request,response );
        }
    }

    @RequestMapping("/selectEmpById.do")
    public ModelAndView selectEmpById(String empid){
        ModelAndView modelAndView = new ModelAndView();
        Employee employee = employeeService.selectEmpById(empid);
        modelAndView.addObject("emp",employee );
        modelAndView.setViewName("/system/empInfo.jsp");
        return modelAndView;
    }

    @RequestMapping("/selectUpdateInfo.do")
    public ModelAndView selectUpdateInfo(String empid){
        List<Department> departmentList = departmentService.selectAllDept();
        List<Employee> employeeList=employeeService.selectAllLeaderExcludeSelf(empid);
        Employee employee = employeeService.selectEmpById(empid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("emp", employee);
        modelAndView.addObject("deptList", departmentList);
        modelAndView.addObject("mgrList", employeeList);
        modelAndView.setViewName("/system/empUpdate.jsp");
        return modelAndView;
    }
    @RequestMapping("/updateEmpById.do")
    public void updateEmpById(Employee employee,HttpServletRequest request,HttpServletResponse response,Model model) throws IOException, ServletException {
        int i=employeeService.updateEmpById(employee);
        if (i>0){
            response.sendRedirect("/selectAllEmp.do");
        }else {
            model.addAttribute("error","修改用户失败" );
            request.getRequestDispatcher("/system/empUpdate.jsp").forward(request,response );
        }
    }

    @RequestMapping("/deleteEmpById.do")
    public void deleteEmpById(String empid,HttpServletRequest request,HttpServletResponse response,Model model) throws IOException, ServletException {
        int i=employeeService.deleteEmpById(empid);
        if (i>0){
            response.sendRedirect("/selectAllEmp.do");
        }else {
            model.addAttribute("error","删除用户失败" );
            request.getRequestDispatcher("/system/empList.jsp").forward(request,response );
        }
    }

    @RequestMapping("/checkOldPwd.do")
    @ResponseBody
    public int checkOldPwd(String empid,String password){
        Employee employee=employeeService.checkOldPwd(empid,password);
        if (employee!=null){
            return 1;
        }else {
            return 0;
        }
    }

    @RequestMapping("/updatePwd.do")
    @ResponseBody
    public int updatePwd(String empid,String password){
        int i=employeeService.updatePwd(empid,password);
        if (i>0){
            return 1;
        }else {
            return 0;
        }
    }

    @RequestMapping("/selectEmpByCondition.do")
    public ModelAndView selectEmpByCondition(Employee employee){
        List<Employee> employeeList=employeeService.selectEmpByCondition(employee);
        List<Department> departmentList = departmentService.selectAllDept();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("empList",employeeList );
        modelAndView.addObject("deptList", departmentList);
        modelAndView.setViewName("/system/empList.jsp");
        return modelAndView;
    }
}
