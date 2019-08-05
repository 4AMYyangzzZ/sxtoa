package com.bjsxt.controller;

import com.bjsxt.pojo.Department;
import com.bjsxt.pojo.Duty;
import com.bjsxt.pojo.Employee;
import com.bjsxt.service.DepartmentService;
import com.bjsxt.service.DutyService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DutyController {
    @Autowired
    private DutyService dutyService;
    @Autowired
    private DepartmentService departmentService;

    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public DutyService getDutyService() {
        return dutyService;
    }

    public void setDutyService(DutyService dutyService) {
        this.dutyService = dutyService;
    }

    @RequestMapping("/sigin.do")
    @ResponseBody
    public int sigin(HttpSession session){
        Employee user = (Employee) session.getAttribute("user");
        return dutyService.sigin(user.getEmpid());
    }

    @RequestMapping(value = "/sigout.do",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String sigout(HttpSession session){
        Employee user = (Employee) session.getAttribute("user");
        return dutyService.sigout(user.getEmpid());
    }

    @RequestMapping("/selectRequiredMessage.do")
    @ResponseBody
    public List<Department> selectRequiredInfo(){
        return departmentService.selectAllDept();
    }

    @RequestMapping("/selectDutyByCondition.do")
    @ResponseBody
    public List<Employee> selectDutyByCondition(String empId, @RequestParam(defaultValue = "0") Integer deptNo, String dtDate){
        List<Employee> employeeList = dutyService.selectDutyByCondition(empId, deptNo, dtDate);
        return employeeList;
    }

    @RequestMapping("/export.do")
    public void export(String empId, @RequestParam(defaultValue = "0") Integer deptNo, String dtDate,HttpServletResponse response){
        List<Employee> ceddList = dutyService.selectDutyByCondition(empId,deptNo ,dtDate );
        createExcel(ceddList, response);
    }

    @RequestMapping("/selectDutyByMyself.do")
    @ResponseBody
    public List<Duty> selectDutyByMyself(HttpSession session){
        Employee user = (Employee) session.getAttribute("user");
        return dutyService.selectDutyByMyself(user.getEmpid());
    }

    private static void createExcel(List<Employee> list,HttpServletResponse response) {
        // 创建一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建一个工作表
        HSSFSheet sheet = workbook.createSheet("考勤信息表");

        CellRangeAddress region = new CellRangeAddress(0, // first row
                0, // last row
                0, // first column
                2 // last column
        );
        sheet.addMergedRegion(region);

        HSSFRow hssfRow = sheet.createRow(0);
        HSSFCell headCell = hssfRow.createCell(0);
        headCell.setCellValue("考勤信息列表");

        // 设置单元格格式居中
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        /*

        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
       // cellStyle.setFillBackgroundColor(HSSFColor.GREEN.index);
        cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);

        HSSFFont font = workbook.createFont();
        font.setFontName("楷体"); //字体
        font.setFontHeightInPoints((short)30); //字体大小
        font.setColor(HSSFColor.RED.index);//颜色
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗
        font.setItalic(true); //倾斜
        cellStyle.setFont(font);
        */
        headCell.setCellStyle(cellStyle);


        // 添加表头行
        hssfRow = sheet.createRow(1);
        // 添加表头内容
        headCell = hssfRow.createCell(0);
        headCell.setCellValue("用户名");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(1);
        headCell.setCellValue("真实姓名");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(2);
        headCell.setCellValue("所属部门");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(3);
        headCell.setCellValue("出勤日期");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(4);
        headCell.setCellValue("签到时间");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(5);
        headCell.setCellValue("签退时间");
        headCell.setCellStyle(cellStyle);
        int k=0;
        // 添加数据内容
        for (int i = 0; i < list.size(); i++) {

            Employee student = list.get(i);

            for (int j = 0; j <student.getDutyList().size() ; j++) {
                hssfRow = sheet.createRow((int) (k++) + 2);
                // 创建单元格，并设置值
                HSSFCell cell = hssfRow.createCell(0);
                cell.setCellValue(student.getEmpid());
                cell.setCellStyle(cellStyle);

                cell = hssfRow.createCell(1);
                cell.setCellValue(student.getRealname());
                cell.setCellStyle(cellStyle);

                cell = hssfRow.createCell(2);
                cell.setCellValue(student.getDepartment().getDeptName());
                cell.setCellStyle(cellStyle);

                cell = hssfRow.createCell(3);
                cell.setCellValue(student.getDutyList().get(j).getDtDate());
                cell.setCellStyle(cellStyle);

                cell = hssfRow.createCell(4);
                cell.setCellValue(student.getDutyList().get(j).getSigninTime());
                cell.setCellStyle(cellStyle);

                cell = hssfRow.createCell(5);
                cell.setCellValue(student.getDutyList().get(j).getSignoutTime());
                cell.setCellStyle(cellStyle);
            }

        }

        // 保存Excel文件
        try {
            // OutputStream outputStream = new FileOutputStream("D:/students.xls");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment; fileName=" + new String(("duty.xls").getBytes(), "iso8859-1"));
            OutputStream outputStream=response.getOutputStream();
            workbook.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取Excel
     *
     * @return 数据集合
     */
    private static List<Employee> readExcel() {
        List<Employee> list = new ArrayList<Employee>();
        HSSFWorkbook workbook = null;

        try {
            // 读取Excel文件
            InputStream inputStream = new FileInputStream("D:/students.xls");
            workbook = new HSSFWorkbook(inputStream);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 循环工作表
        for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = workbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 循环行
            for (int rowNum = 2; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow == null) {
                    continue;
                }

                // 将单元格中的内容存入集合
                Employee student = new Employee();
                for (int j = 0; j <student.getDutyList().size() ; j++){
                    HSSFCell cell = hssfRow.getCell(0);
                    if (cell == null) {
                        continue;
                    }
                    student.setEmpid(cell.getStringCellValue());

                    cell = hssfRow.getCell(1);
                    if (cell == null) {
                        continue;
                    }
                    student.setRealname( cell.getStringCellValue());

                    cell = hssfRow.getCell(2);
                    if (cell == null) {
                        continue;
                    }
                    student.getDutyList().get(j).setDtDate(cell.getDateCellValue());

                    cell = hssfRow.getCell(3);
                    if (cell == null) {
                        continue;
                    }
                    student.getDutyList().get(j).setSigninTime(cell.getStringCellValue());

                    cell = hssfRow.getCell(4);
                    if (cell == null) {
                        continue;
                    }
                    student.getDutyList().get(j).setSignoutTime(cell.getStringCellValue());
                    list.add(student);
                }

            }
        }
        return list;
    }
}
