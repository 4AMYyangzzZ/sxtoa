
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>欢迎登录后台管理系统</title>
    <base href="<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/"/>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="js/jquery.js"></script>
    <script src="js/cloud.js" type="text/javascript"></script>

    <script language="javascript">
        $(function(){
            $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            $(window).resize(function(){
                $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            })
        });

        function modifyImg() {
            var ran=document.getElementById("ran");
            ran.src="ran.jpg?date="+new Date().getTime();
        }
    </script>

</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
    <span>欢迎访问尚学堂OA系统</span>
    <ul>
        <li><a href="#">回首页</a></li>
        <li><a href="#">帮助</a></li>
        <li><a href="#">关于</a></li>
    </ul>
</div>

<div class="loginbody">

    <span class="systemlogo"></span>

    <div class="loginbox loginbox2">
    <form action="servlet/EmployeeServlet?method=login" method="post">
        <ul>
            <li><input name="empId" type="text" class="loginuser" value="admin" onclick="JavaScript:this.value=''"/></li>
            <li><input name="password" type="password" class="loginpwd" value="密码" onclick="JavaScript:this.value=''"/></li>
            <li class="yzm">
                <span><input name="verify" type="text" value="验证码" onclick="JavaScript:this.value=''"/></span><cite><img src="ran.jpg" alt="" id="ran" onclick="modifyImg()"/></cite>
            </li>
            <li><input name="" type="submit" class="loginbtn" value="登录"  onclick="javascript:window.location='main.html'"  /><label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label></li>
        </ul>
    </form>
        ${error}
    </div>

</div>





</body>

</html>
