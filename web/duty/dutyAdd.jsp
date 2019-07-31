
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <base href="<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/"/>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">
        function sigIn () {
            $.ajax({
                type:"POST",
                url:"servlet/DutyServlet",
                data:"method=sigin",
                dataType:"text",
                success:function (result) {
                    if (result==1){
                        $("#sigin").html("签到成功");
                    }else if(result==2){
                        $("#sigin").html("已经签到，每天签到一次");
                    }else{
                        $("#sigin").html("签到失败");
                    }
                },
                error:function (xhr) {
                    alert(xhr.status+" "+xhr.statusText);
                }
            });
        }

        $(function () {
            $("#sigout").click(function () {
                $.ajax({
                    type:"POST",
                    url:"servlet/DutyServlet",
                    data:"method=sigout",
                    dataType:"text",
                    success:function (result) {
                        $("#sout").html(result);
                    },
                    error:function (xhr) {
                        alert(xhr.status+" "+xhr.statusText);
                    }
                });
            });
        });
    </script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">考勤管理</a></li>
        <li><a href="#">签到签退</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>

    <ul class="forminfo">
        <li><label>&nbsp;</label><input name="" type="button" class="btn" value="签到" onclick="sigIn()"/> 每天签到一次，不可重复签到</li>
        <li><label id="sigin">&nbsp;</label></li>
        <li><label>&nbsp;</label></li>
        <li><label>&nbsp;</label><input name="" type="button" class="btn" value="签退" id="sigout"/>可重复签退，以最后一次签退为准</li>
        <li id="sout"></li>
    </ul>


</div>


</body>

</html>
