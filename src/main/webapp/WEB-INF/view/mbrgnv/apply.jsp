<%--
  Created by IntelliJ IDEA.
  User: 张镇涛
  E-mail: zhangzhentao1995@163.com
  Date: 2017/8/5
  Time: 18:32 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link type="text/css" rel="stylesheet" href="/lib/bootstrap/css/bootstrap.min.css">
<script type="text/javascript">
    var pageIndex = "apply";
</script>
<script type="text/javascript" src="/lib/jquery/jquery-3.2.1.min.js"></script>
<body style="text-align: center;">
<img style="width: 100%;" src="/resources/mbrgnv/img/homepage_top.png">
<form id="form" action="/mbrgnv/submit" method="post" enctype="multipart/form-data">
<div style="width: 70%;height: 50px;font-size: 45px;margin: 100px auto 0px;" class="input-group input-group-lg">
    <span style="font-size: 45px;height: 80px;" class="input-group-addon">姓名</span>
    <input name="name" style="font-size: 45px;height: 80px;" type="text" class="form-control" placeholder="请输入姓名">
</div>
<div style="width: 70%;height: 50px;font-size: 45px;margin: 100px auto 0px;" class="input-group input-group-lg">
    <span style="font-size: 45px;height: 80px;" class="input-group-addon">联系方式</span>
    <input name="phone" style="font-size: 45px;height: 80px;" type="text" class="form-control" placeholder="请输入联系方式">
</div>
<div style="width: 70%;height: 50px;font-size: 45px;margin: 100px auto 0px;" class="input-group input-group-lg">
    <span style="font-size: 45px;height: 80px;" class="input-group-addon">参赛宣言</span>
    <input name="declaration" style="font-size: 45px;height: 80px;" type="text" class="form-control" placeholder="请输入参赛宣言">
</div>
<div style="width: 70%;height: 50px;font-size: 45px;margin: 100px auto 0px;" class="input-group input-group-lg">
    <span style="font-size: 45px;height: 80px;" class="input-group-addon">参赛图片</span>
    <input name="file" style="font-size: 45px;height: 80px;" type="file" class="form-control">
</div>
<button onclick="submitData()" type="button" style="font-size: 45px;width: 80%;height: 100px;margin: 100px auto 200px;" class="btn btn-primary">报名参赛</button>
</form>
<%
    String apply = (String)request.getAttribute("apply");
    if(apply!=null) {
        if (apply.equals("success")) {
            out.print("<script>alert('报名成功');</script>");
        }else{
            out.print("<script>alert('报名失败');</script>");
        }
        request.removeAttribute("apply");
        out.print("<script>window.location.href='/mbrgnv/apply'</script>");
    }

%>
<%@include file="footer.html" %>
<script type="text/javascript">
    function submitData() {
        $("#form").submit();
    }
</script>
</body>
</html>
