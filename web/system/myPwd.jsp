<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/1 0001
  Time: 下午 17:17
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
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link href="css/select.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="js/select-ui.min.js"></script>
    <script type="text/javascript" src="editor/kindeditor.js"></script>
    <script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript">
        var flag;
        function checkOldPwd() {
            $.post("${pageContext.request.contextPath}/checkOldPwd.do",{"empid":"${param.empid}","password":$("#oldPwd").val()},function (result) {
                if (result>0){
                    $("#pwdInfo").html("旧密码正确");
                    flag=1;
                }else {
                    $("#pwdInfo").html("旧密码错误");
                    flag=0;
                }
            })
        }

        function updatePwd() {
            if (flag==0){
                alert("请输入正确旧密码");
            }else {
                if($("#newPwd").val()==$("#rePwd").val()){
                    $.post("${pageContext.request.contextPath}/updatePwd.do",{"empid":"${param.empid}","password":$("#newPwd").val()},function (result) {
                        if(result>0){
                            alert("修改密码成功");
                        }else {
                            alert("修改密码失败");
                        }
                    })
                }else {
                    $("#repwdInfo").html("两次密码不一致");
                }
            }
        }
    </script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">个人信息</a></li>
        <li><a href="#">修改密码</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>修改密码</span></div>
        <ul class="forminfo">
            <li><label>旧密码</label><input name="" id="oldPwd" type="password" class="dfinput" onblur="checkOldPwd()" /><i id="pwdInfo" style="color: red"></i></li>
            <li><label>新密码</label><input name="" id="newPwd" type="password" class="dfinput" /><i></i></li>
            <li><label>新确认密码</label><input name="" id="rePwd" type="password" class="dfinput" /><i id="repwdInfo" style="color: red" ></i></li>
            <li><label>&nbsp;</label><input name="" type="button" class="btn" value="确认修改" onclick="updatePwd()"/></li>
        </ul>



</div>


</body>

</html>

