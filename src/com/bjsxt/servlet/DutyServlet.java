package com.bjsxt.servlet;

import com.bjsxt.entity.CombineDeptAndEmpAndPos;
import com.bjsxt.entity.CombineEmpAndDutyAndDept;
import com.bjsxt.entity.Employee;
import com.bjsxt.service.DutyService;
import com.bjsxt.service.impl.DutyServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DutyServlet extends BaseServlet {
    public void sigin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CombineDeptAndEmpAndPos emp=(CombineDeptAndEmpAndPos) request.getSession().getAttribute("emp");
        DutyService dutyService=new DutyServiceImpl();
        int n=dutyService.sigin(emp.getEmpId());
        response.getWriter().println(n);
    }

    public void sigout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CombineDeptAndEmpAndPos emp=(CombineDeptAndEmpAndPos) request.getSession().getAttribute("emp");
        DutyService dutyService=new DutyServiceImpl();
        int n=dutyService.sigout(emp.getEmpId());
        String msg="尚未签到，请先签到";
        if(n==1){
            msg="签退成功";
        }else if(n==0){
            msg="签退失败";
        }
        response.setCharacterEncoding("utf-8");
        response.getWriter().println(msg);
    }

    public void findDuty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empId=request.getParameter("empId");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        int deptNo=0;
        try {
            deptNo=Integer.parseInt(request.getParameter("deptNo"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        Date dtDate=null;
        try {
            if (request.getParameter("dtDate")!=""){
                dtDate= sdf.parse(request.getParameter("dtDate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DutyService dutyService=new DutyServiceImpl();
        List<CombineEmpAndDutyAndDept> ceddList=dutyService.findDuty(empId,deptNo,dtDate);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String s = gson.toJson(ceddList);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(s);

    }

    public void export(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empId=request.getParameter("empId");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        int deptNo=0;
        try {
            deptNo=Integer.parseInt(request.getParameter("deptNo"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        Date dtDate=null;
        try {
            if (request.getParameter("dtDate")!=""){
                dtDate= sdf.parse(request.getParameter("dtDate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DutyService dutyService=new DutyServiceImpl();
        List<CombineEmpAndDutyAndDept> ceddList=dutyService.findDuty(empId,deptNo,dtDate);
        createExcel(ceddList,response);

    }
    private static void createExcel(List<CombineEmpAndDutyAndDept> list,HttpServletResponse response) {
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

        // 添加数据内容
        for (int i = 0; i < list.size(); i++) {
            hssfRow = sheet.createRow((int) i + 2);
            CombineEmpAndDutyAndDept student = list.get(i);

            // 创建单元格，并设置值
            HSSFCell cell = hssfRow.createCell(0);
            cell.setCellValue(student.getEmpId());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(1);
            cell.setCellValue(student.getRealName());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(2);
            cell.setCellValue(student.getDeptName());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(3);
            cell.setCellValue(student.getDtDate());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(4);
            cell.setCellValue(student.getSigninTime());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(5);
            cell.setCellValue(student.getSignoutTime());
            cell.setCellStyle(cellStyle);
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
    private static List<CombineEmpAndDutyAndDept> readExcel() {
        List<CombineEmpAndDutyAndDept> list = new ArrayList<CombineEmpAndDutyAndDept>();
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
                CombineEmpAndDutyAndDept student = new CombineEmpAndDutyAndDept();

                HSSFCell cell = hssfRow.getCell(0);
                if (cell == null) {
                    continue;
                }
                student.setEmpId(cell.getStringCellValue());

                cell = hssfRow.getCell(1);
                if (cell == null) {
                    continue;
                }
                student.setRealName( cell.getStringCellValue());

                cell = hssfRow.getCell(2);
                if (cell == null) {
                    continue;
                }
                student.setDtDate(cell.getDateCellValue());

                 cell = hssfRow.getCell(3);
                if (cell == null) {
                    continue;
                }
                student.setSigninTime(cell.getStringCellValue());

                cell = hssfRow.getCell(4);
                if (cell == null) {
                    continue;
                }
                student.setSignoutTime(cell.getStringCellValue());
                list.add(student);
            }
        }
        return list;
    }
}

