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
<style type="text/css">
    .pointer:hover {
        cursor: pointer;
    }
</style>
<body>
<span class="label label-info pull-left" style="margin: 10px;display: block;">筛选：</span>
<span class="pull-left" style="margin-top: 10px;">编号：</span><input id="number" class="form-control pull-left"
                                                                   style="margin-top:10px;width: 50px;height: 30px;"
                                                                   type="text">
<span class="pull-left" style="margin-top: 10px;">姓名：</span><input id="name" class="form-control pull-left"
                                                                   style="margin-top:10px;width: 100px;height: 30px;"
                                                                   type="text">
<span class="pull-left" style="margin-top: 10px;">联系方式：</span><input id="phone" class="form-control pull-left"
                                                                     style="margin-top:10px;width: 100px;height: 30px;"
                                                                     type="text">
<span class="pull-left" style="margin-top: 10px;">宣言：</span><input id="declaration" class="form-control pull-left"
                                                                   style="margin-top:10px;width: 100px;height: 30px;"
                                                                   type="text">
<span class="pull-left" style="margin-top: 10px;">是否审核：</span>
<select id="check" class="pull-left form-control" style="margin-top:10px;width: 80px;height: 35px;">
    <option value="all">全部</option>
    <option value="true">是</option>
    <option value="false">否</option>
</select>
<button onclick="queryData()" class="btn btn-default pull-left" style="margin: 10px;">查询</button>
<button onclick="logout()" class="btn btn-default pull-right">退出登录</button>
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
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel"></h4>
            </div>
            <div class="modal-body">
                <img style="width: 100%;" id="picture">
            </div>
        </div>
    </div>
</div>
<SCRIPT src="/lib/jquery/jquery-3.2.1.min.js" type="text/javascript"></SCRIPT>
<script type="text/javascript" src="/lib/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
    var number = "";
    var name = "";
    var phone = "";
    var declaration = "";
    var check = "all";
    queryData();
    function queryData() {
        number = $("#number").val();
        name = $("#name").val();
        phone = $("#phone").val();
        declaration = $("#declaration").val();
        check = $("#check").val();
        $("#tBody").html("");
        $.ajax({
            url: '/mbrgnvcheck/query',
            type: 'post',
            data: {number: number, name: name, phone: phone, declaration: declaration, check: check, pageSize: 100000},
            success: function (data) {
                var rows = data.rows;
                if (rows != undefined && rows != null) {
                    $.each(rows, function (name, value) {
                        $("#tBody").append("<tr><td>" + value.number + "</td>" +
                            "<td>" + value.name + "</td>" +
                            "<td><img class='pointer' onclick='showPicture(\"" + value.pictureUrl + "\")' style='width: 60px;' src='" + value.pictureUrl + "'></td>" +
                            "<td>" + value.phone + "</td>" +
                            "<td>" + value.declaration + "</td>" +
                            "<td id='isPass-" + value.competitorId + "'>" + (value.isPass ? "是" : "否") + "</td><td><button onclick='changeState(" + value.competitorId + "," + value.isPass + ")' style='font-size:13px;'>审核/取消审核</button></td></tr>");
                    });
                }
            }
        });
    }
    function changeState(id, isPass) {
        if (confirm("修改审核状态：未审核则通过审核，已审核则取消审核")) {
            if (isPass) isPass = false;
            else isPass = true;
            $.ajax({
                url: '/mbrgnvcheck/changeState',
                data: {competitorId: id, isPass: isPass},
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
    function logout() {
        window.location.href = "/mbrgnvcheck/logout";
    }
    function showPicture(picUrl) {
        if (picUrl == "null") {
            $("#myModalLabel").html("未上传图片");
        } else {
            $("#myModalLabel").html("已上传图片");
        }
        $("#picture").attr("src", picUrl);
        $("#myModal").modal();
    }
</script>
</body>
</html>
