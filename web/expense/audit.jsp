<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/4 0004
  Time: 下午 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <base href="<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>审核报销单</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">
        function submitForm(){
            window.close();

        }

    </script>
    <script type="text/javascript">
        $(function () {
            var expId=${param.expId};
            $("#expId").val(expId);
        });
        function audit() {
            var expId=$("#expId").val();
            var resultArr=$("input[name=result]");
            var result;
            for(var i=0;i<resultArr.length;i++){
                if (resultArr[i].checked==true){
                    result=resultArr[i].value;
                    alert(result);
                    break;
                }
            }
           var auditDesc=$("#auditDesc").val();

            $.ajax({
                type:"POST",
                url:"${pageContext.request.contextPath}/audit.do",
                data:{"expId":expId,"result":result,"auditDesc":auditDesc},
                dataType:"text",
                success:function (result) {
                    if (result.indexOf("审核成功")==0){
                        alert(result);
                        window.close();
                        window.opener.location.reload();
                    }else {
                        alert(result);
                    }
                },
                error:function (xhr) {
                    alert(xhr.status+" "+xhr.statusText);
                }
            });
        }
    </script>
</head>

<body>

<div class="formtitle"><span>审核报销单</span></div>
<form action="#" onsubmit="return submitForm()">
    <ul class="forminfo">
        <li>
            <label >报销编号</label>
            <input name="expId" id="expId" type="text" class="dfinput" />
        </li>
        <li>
            <label>审核结果</label>
            <input name="result" type="radio" value="通过"/>通过
            <input name="result" type="radio" value="拒绝"/>拒绝
            <input name="result" type="radio" value="打回"/>打回
        </li>
        <li>
            <label>审核意见</label>
            <input name="auditDesc" id="auditDesc" type="text" class="dfinput" />
        </li>
        <li>
            <label>&nbsp;</label>
            <input name="" type="button" class="btn" value="确认保存" onclick="audit()" />
        </li>
    </ul>
</form>
</body>

</html>
