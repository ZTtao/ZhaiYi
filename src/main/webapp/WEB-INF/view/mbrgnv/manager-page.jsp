<%--
  Created by IntelliJ IDEA.
  User: 张镇涛
  E-mail: zhangzhentao1995@163.com
  Date: 2017/8/6
  Time: 11:00 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link type="text/css" rel="stylesheet" href="/lib/bootstrap/css/bootstrap.min.css">
<body>
<table class="table table-hover">
    <thead>
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>图片</td>
        <td>联系方式</td>
        <td>宣言</td>
        <td>是否审核</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody id="tBody">

    </tbody>
</table>
<SCRIPT src="/lib/jquery/jquery-3.2.1.min.js" type="text/javascript"></SCRIPT>
<script type="text/javascript">
    $.ajax({
        url: '/mbrgnvcheck/query',
        type: 'post',
        data: {pageSize: 100000},
        success: function (data) {
            var rows = data.rows;
            if (rows != undefined && rows != null) {
                $.each(rows, function (name, value) {
                    $("#tBody").append("<tr><td>" + value.number + "</td>" +
                        "<td>" + value.name + "</td><td>picture</td><td>" + value.phone + "</td>" +
                        "<td>" + value.declaration + "</td>" +
                        "<td id='isPass-" + value.competitorId + "'>" + (value.isPass? "是" : "否") + "</td><td><button onclick='changeState(" + value.competitorId + ")' style='font-size:13px;'>审核/取消审核</button></td></tr>");
                });
            }
        }
    });
    function changeState(id) {
        if (confirm("修改审核状态：未审核则通过审核，已审核则取消审核")) {
            $.ajax({
                url: '/mbrgnvcheck/changeState',
                data: {competitorId: id},
                type: 'post',
                success: function (data) {
                    if (data.success == "true") {
                        alert("操作成功");
                        if ($("#isPass-" + id).text() == "是") $("#isPass-" + id).text("否");
                        else $("#isPass-" + id).text("是");
                    }
                }
            })
        }
    }
</script>
</body>
</html>
