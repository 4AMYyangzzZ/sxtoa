<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/6 0006
  Time: 上午 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"  style="height: 100%">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <base href="<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/"/>
    <script type="text/javascript" src="js/echarts.min.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">
        $(function () {
           $.ajax({
               type:"POST",
               url:"servlet/InoutServlet?method=getIncomeData",
               dataType:"text",
               success:function (result) {
                   eval("var arr="+result);
                   // 基于准备好的dom，初始化echarts实例
                   var myChart = echarts.init(document.getElementById('container'));

                   // 指定图表的配置项和数据
                   var option = {
                       title: {
                           text: 'ECharts 入门示例'
                       },
                       tooltip: {},
                       legend: {
                           data:['费用']
                       },
                       xAxis: {
                           data: arr[0]
                       },
                       yAxis: {},
                       series: [{
                           name: '费用',
                           type: 'bar',
                           data: arr[1]
                       }]
                   };

                   // 使用刚指定的配置项和数据显示图表。
                   myChart.setOption(option);
               }
           });
        });
    </script>
</head>

<body style="height: 100%; margin: 0">
<div >
    <h1 align="center">公司收入统计柱状图</h1>
</div>
<div id="container" style="height: 90%"></div>

</body>
</html>

