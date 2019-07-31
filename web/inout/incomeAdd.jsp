<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/7 0007
  Time: 下午 14:25
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
    <script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
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
        <li><a href="#">收支管理</a></li>
        <li><a href="#">添加收入</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>

    <form action="servlet/InoutServlet?method=incomeAdd" method="post">
        <ul class="forminfo">
            <li>
                <label>所属部门<b>*</b></label>
                <div class="vocation">
                    <select class="select1" name="dept">
                        <option value="${dept.deptNo}">${dept.deptName}</option>
                    </select>
                </div>
            </li>
            <li>
                <label>收入金额</label>
                <input name="amount" type="text" class="dfinput" /><i></i></li>
            <li>
                <label>收入类型</label>
                <cite>
                    <c:forEach items="${incomeList}" var="income">
                        <input name="incomeType" type="radio" value="${income.incomeType}" />${income.incomeType}&nbsp;&nbsp;&nbsp;&nbsp;
                    </c:forEach>
                </cite>
            </li>
            <li>
                <label>收入日期</label>
                <input name="incomeDate" type="text" onfocus="WdatePicker()" class="dfinput" />
            </li>
            <li>
                <label>备注</label>
                <textarea name="incomeDesc" cols="" rows="" class="textinput"></textarea>
            </li>
            <li>
                <label>&nbsp;</label>
                <input name="" type="submit" class="btn" value="确认保存" />
            </li>
        </ul>

    </form>
    ${error}
</div>

</body>

</html>
