<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/4 0004
  Time: 下午 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <base href="<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>

    <script type="text/javascript">
        $(document).ready(function() {
            $(".click").click(function() {
                $(".tip").fadeIn(200);
            });
            $(".tiptop a").click(function() {
                $(".tip").fadeOut(200);
            });
            $(".sure").click(function() {
                $(".tip").fadeOut(100);
            });
            $(".cancel").click(function() {
                $(".tip").fadeOut(100);
            });
        });
    </script>

    <script type="text/javascript">
        $.ajax({
            url:"${pageContext.request.contextPath}/myExpense.do",
            success:function (result) {
               console.log(result);
                $("#tb").empty();
                for (var i=0;i<result.length;i++){
                    $("#tb").append("<tr>\n" +
                        "            <td>\n" +
                        "                <input name=\"\" type=\"checkbox\" value=\"\" />\n" +
                        "            </td>\n" +
                        "            <td>"+result[i].expId+"</td>\n" +
                        "            <td>"+result[i].totalAmount+"</td>\n" +
                        "            <td>"+result[i].expTime+"</td>\n" +
                        "            <td>"+result[i].expDesc+"</td>\n" +
                        "            <td><a href=\"expenseDetail.html\" class=\"tablelink\"> 查看具体报销项</a></td>\n" +
                        "            <td> <a href=\"expenseImg.html\" class=\"tablelink\">查看所附图片</a></td>\n" +
                        "            <td>"+result[i].lastResult+"</td>\n" +
                        "            <td><a href=\"#\" class=\"tablelink\">查看审核记录</a> </td>\n" +
                        "        </tr>")
                }
            }
        })
    </script>

</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">报销管理</a></li>
        <li><a href="#">我的报销</a></li>
    </ul>
</div>

<div class="rightinfo">

    <div class="formtitle1"><span>我的报销</span></div>

    <table class="tablelist">
        <thead>
        <tr>
            <th>
                <input name="" type="checkbox" value="" checked="checked" />
            </th>
            <th>编号</th>
            <th>报销总额</th>
            <th>报销时间</th>
            <th>总备注信息</th>
            <th>查看具体报销项</th>
            <th>查看所附图片</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="tb">

        </tbody>
    </table>
    <div class="pagin">
        <div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
            <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
            <li class="paginItem"><a href="javascript:;">1</a></li>
            <li class="paginItem current"><a href="javascript:;">2</a></li>
            <li class="paginItem"><a href="javascript:;">3</a></li>
            <li class="paginItem"><a href="javascript:;">4</a></li>
            <li class="paginItem"><a href="javascript:;">5</a></li>
            <li class="paginItem more"><a href="javascript:;">...</a></li>
            <li class="paginItem"><a href="javascript:;">10</a></li>
            <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>

</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>

</body>

</html>
