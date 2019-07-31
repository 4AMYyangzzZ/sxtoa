<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/30 0030
  Time: 上午 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <base href="<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/"/>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">人事管理</a></li>
        <li><a href="#">添加岗位</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>
    <form action="servlet/PositionServlet?method=posAdd" method="post">
        <ul class="forminfo">
            <li><label>岗位编号</label><input name="posId" type="text" class="dfinput" /></li>
            <li><label>岗位名称</label><input name="pName" type="text" class="dfinput" /></li>
            <li><label>岗位描述</label><input name="pDesc" type="text" class="dfinput" /></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
        </ul>
    </form>
</div>
${error}

</body>

</html>

