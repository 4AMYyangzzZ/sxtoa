<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/30 0030
  Time: 下午 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <base href="<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/"/>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link href="css/select.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="js/select-ui.min.js"></script>
    <script type="text/javascript" src="editor/kindeditor.js"></script>
    <script type="text/javascript">
        $(document).ready(function(e) {
            $(".select1").uedSelect({
                width : 345
            });

        });
    </script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">人事管理</a></li>
        <li><a href="#">修改员工信息</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>
    <form action="servlet/EmployeeServlet?method=empUpdate" method="post">
        <ul class="forminfo">
            <li>
                <label>用户名</label>
                <input name="empId" type="text" class="dfinput" value="${emp.empId}" /><i>必须唯一，也可以根据真实姓名自动生成</i></li>
            <li>
            <li>
                <label>真实姓名</label>
                <input name="realName" type="text" class="dfinput" value="${emp.realName}"/><i></i></li>
            <li>
                <label>性别</label><cite>
                <input name="sex" type="radio" value="男" <c:if test='${emp.sex=="男"}'>checked="checked"</c:if> />男&nbsp;&nbsp;&nbsp;&nbsp;
                <input name="sex" type="radio" value="女" <c:if test='${emp.sex=="女"}'>checked="checked"</c:if>  />女<i>也可以根据身份证号自动获取</i></cite>

            </li>
            <li>
                <label>出生日期</label>
                <input name="birthDate" type="text" class="dfinput" value="${emp.birthDate}"/><i>也可以根据身份证号自动获取</i></li>
            <li>
            <li>
                <label>入职时间</label>
                <input name="hireDate" type="text" class="dfinput" value="${emp.hireDate}"/><i></i></li>

            <li>
                <label>离职时间</label>
                <input name="leaveDate" type="text" class="dfinput" value="${emp.leaveDate}"/><i></i></li>
            <li>
                <label>是否在职</label><cite>
                <input name="onDuty" type="radio" value="1" <c:if test='${emp.onDuty==1}'>checked="checked" </c:if> />是&nbsp;&nbsp;&nbsp;&nbsp;
                <input name="onDuty" type="radio" value="0" <c:if test='${emp.onDuty==0}'>checked="checked" </c:if> />否</cite>
            </li>
            <li>
                <label>所属部门<b>*</b></label>
                <div class="vocation">
                    <select class="select1" name="dept">
                        <c:forEach items="${deptList}" var="dept">
                            <option value="${dept.deptNo}" <c:if test='${emp.deptNo==dept.deptNo}'>selected="selected"</c:if>>${dept.deptName}</option>
                        </c:forEach>
                    </select>
                </div>

            </li>
            <li>
                <label>直接上级<b>*</b></label>
                <div class="vocation">
                    <select class="select1" name="mgr">
                        <c:forEach items="${mgrList}" var="mgr">
                            <option value="${mgr.empId}" <c:if test='${emp.emp_empId==mgr.empId}'>selected="selected" </c:if>>${mgr.realName}</option>
                        </c:forEach>
                    </select>
                </div>
                &nbsp;&nbsp;<input name="" type="text" class="dfinput"  placeholder="也可以在此输入首字母帮助显示"/></li>
            </li>
            <li>
                <label>联系方式</label>
                <input name="phone" type="text" class="dfinput" value="${emp.phone}"/>
            </li>
            <li>
                <label>QQ号</label>
                <input name="qq" type="text" class="dfinput" value="${emp.qq}" />
            </li>
            <li>
                <label>紧急联系人信息</label>
                <textarea name="emerContactPerson" cols="" rows="" class="textinput">${emp.emerContactPerson}</textarea>
            </li>
            <li>
                <label>身份证号</label>
                <input name="idCard" type="text" class="dfinput" value="${emp.idCard}"/>
            </li>
            <li>
                <label>&nbsp;</label>
                <input name="" type="submit" class="btn" value="确认保存" />
            </li>
        </ul>

    </form>

</div>
${emp.sex}
</body>

</html>