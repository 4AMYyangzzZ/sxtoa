<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/3 0003
  Time: 下午 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <base href="<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link href="css/select.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript" src="js/jquery.js"></script>

    <script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="js/select-ui.min.js"></script>
    <script type="text/javascript" src="editor/kindeditor.js"></script>
    <script type="text/javascript">
        $(document).ready(function(e) {
            $(".select1").uedSelect({
                width : 150
            });

        });
    </script>
    <script type="text/javascript">
        $(document).ready(function(){
            $(".click").click(function(){
                $(".tip").fadeIn(200);
            });

            $(".tiptop a").click(function(){
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function(){
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function(){
                $(".tip").fadeOut(100);
            });

        });
    </script>


</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">收支管理</a></li>
        <li><a href="#">查看支出</a></li>
    </ul>
</div>

<div class="rightinfo">

    <ul class="prosearch">
        <li>
            <label>查询：</label>
            <i>起始登记时间</i>
            <a>
                <input name="" type="text" class="scinput" />
            </a>
            <i>结束登记时间</i>
            <a>
                <input name="" type="text" class="scinput" />
            </a>
            <i>支出人</i>
            <a>
                <input name="" type="text" class="scinput" />
            </a>

        </li>
    </ul>
    <ul class="prosearch">
        <li>

            <i>收入类型</i>
            <a>
                <select class="select1">
                    <option>人员外包</option>
                    <option>项目开发</option>
                    <option>报名费</option>
                    <option>学费</option>
                </select>
            </a>
            <a>
                <input name="" type="button" class="sure" value="查询" />
            </a>
        </li>
    </ul>
    <div class="formtitle1"><span>支出列表</span></div>

    <table class="tablelist">
        <thead>
        <tr>
            <th>
                <input name="" type="checkbox" value="" checked="checked" />
            </th>
            <th>类型<i class="sort"><img src="images/px.gif" /></i></th>
            <th>金额</th>
            <th>备注</th>
            <th>支出人</th>
            <th>支出时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <input name="" type="checkbox" value="" />
            </td>
            <td>人员外包</td>
            <td>3000</td>
            <td>中国建设银行</td>
            <td>施金玲</td>
            <td>2008-12-23</td>
            <td><a href="#" class="tablelink">查看</a> </td>
        </tr>

        <tr>
            <td>
                <input name="" type="checkbox" value="" />
            </td>
            <td>项目开发</td>
            <td>30000</td>
            <td>财务管理系统</td>
            <td>成林</td>
            <td>2013-09-08</td>
            <td><a href="#" class="tablelink">查看</a></td>
        </tr>

        <tr>
            <td>
                <input name="" type="checkbox" value="" />
            </td>
            <td>报名费</td>
            <td>200</td>
            <td>王忠新</td>
            <td>陈瑞</td>
            <td>2013-08-27</td>
            <td><a href="#" class="tablelink">查看</a> </td>
        </tr>

        <tr>
            <td>
                <input name="" type="checkbox" value="" />
            </td>
            <td>学费</td>
            <td>20000</td>
            <td>王忠新</td>
            <td>陈瑞</td>
            <td>2013-09-06</td>
            <td><a href="#" class="tablelink">查看</a> </td>
        </tr>


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
