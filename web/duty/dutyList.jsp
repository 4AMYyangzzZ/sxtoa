<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/2 0002
  Time: 下午 15:52
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
    <link href="css/select.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript" src="js/jquery.js"></script>

    <script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="js/select-ui.min.js"></script>
    <script type="text/javascript" src="editor/kindeditor.js"></script>
    <script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript">
        $(document).ready(function(e) {
            $(".select1").uedSelect({
                width : 200
            });

        });
    </script>
    <script type="text/javascript">
       $(function () {
           $.ajax({
               type:"POST",
               url:"servlet/DepartmentServlet",
               data:"method=findAllAjax",
               dataType:"text",
               success:function (result) {
                   eval("var deptArr="+result);
                   $("#deptList").empty();
                   $("#deptList").append('<option value="0" selected="selected">--不限--</option>');
                   for(var i=0;i<deptArr.length;i++){
                       $("#deptList").append("<option value="+deptArr[i].deptNo+">"+deptArr[i].deptName+"</option>")
                   }

               },
               error:function (xhr) {
                   alert(xhr.status+" "+xhr.statusText);
               }
           });
       });

       function sel() {
            var empId=$("#empId").val();
            var deptNo=$("#deptList").val();
            var dtDate=$("#dtDate").val();

            $.ajax({
                type:"POST",
                url:"servlet/DutyServlet",
                data:{"method":"findDuty","empId":empId,"deptNo":deptNo,"dtDate":dtDate},
                dataType:"text",
                success:function (result) {
                   // alert(result);
                    eval("var dutyList="+result);
                    $("#tb").empty();
                    for (var i=0;i<dutyList.length;i++){
                        $("#tb").append('<tr>' +
                            '<td>' +
                            '<input name="" type="checkbox" value="" />' +
                            '</td>' +
                            '<td>'+dutyList[i].empId+'</td>' +
                            '<td>'+dutyList[i].realName+'</td>' +
                            '<td>'+dutyList[i].deptName+'</td>' +
                            '<td>'+dutyList[i].dtDate+'</td>' +
                            '<td>'+dutyList[i].signinTime+'</td>' +
                            '<td>'+dutyList[i].signoutTime+'</td>' +
                            '</tr>');
                    }
                },
                error:function (xhr) {
                    alert(xhr.status+" "+xhr.statusText);
                }
            });
       }

       function setNull() {
           window.location.reload();
         // alert("ok");
           $("#empId").val("");
          //$("#deptList").options[0].selected=true;
          // // document.getElementById("deptList").options[0].selected=true;
            $("#deptList").val('<option value="0" selected="selected">--不限--</option>');
          //  $("#dtDate").val("");
       }

       function exp() {

           var empId=$("#empId").val();
           var deptNo=$("#deptList").val();
           var dtDate=$("#dtDate").val();

           location.href="servlet/DutyServlet?method=export&empId="+empId+"&deptNo="+deptNo+"&dtDate="+dtDate;
       }


       window.onload=sel;
    </script>

</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">考勤管理</a></li>
        <li><a href="#">考勤管理</a></li>
    </ul>
</div>

<div class="rightinfo">

    <ul class="prosearch">
        <li>
            <label>查询：</label><i>用户名</i>
            <a>
                <input name="" type="text" class="scinput" id="empId"/>
            </a><i>所属部门</i>
            <a>
                <select class="select1" name="deptList" id="deptList">

                </select>
            </a>
            <i>考勤时间</i>
            <a>
                <input name="" type="text" class="scinput" onfocus="WdatePicker()" id="dtDate"/>
            </a>
            <a>
                <input name="" type="button" class="sure" value="查询" onclick="sel()"/>

            </a>
            <a>
                <input name="" type="button" class="sure" value="清空" onclick="setNull()"/>

            </a>
            <a>
                <input name="" type="button" class="scbtn2" value="导出" onclick="exp()"/>

            </a>

        </li>


    </ul>

    <div class="formtitle1"><span>考勤管理</span></div>

    <table class="tablelist">
        <thead>
        <tr>
            <th>
                <input name="" type="checkbox" value="" checked="checked" />
            </th>
            <th>用户名<i class="sort"><img src="images/px.gif" /></i></th>
            <th>真实姓名</th>
            <th>所属部门</th>
            <th>出勤日期</th>
            <th>签到时间</th>
            <th>签退时间</th>
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

    <div class="tip">
        <div class="tiptop"><span>提示信息</span>
            <a></a>
        </div>

        <div class="tipinfo">
            <span><img src="images/ticon.png" /></span>
            <div class="tipright">
                <p>是否确认对信息的修改 ？</p>
                <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
            </div>
        </div>

        <div class="tipbtn">
            <input name="" type="button" class="sure" value="确定" />&nbsp;
            <input name="" type="button" class="cancel" value="取消" />
        </div>

    </div>

</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>

</body>

</html>
