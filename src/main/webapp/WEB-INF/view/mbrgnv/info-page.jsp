<%--
  Created by IntelliJ IDEA.
  User: 张镇涛
  E-mail: zhangzhentao1995@163.com
  Date: 2017/8/5
  Time: 23:23 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>最美瑞姑娘</title>
</head>
<link type="text/css" rel="stylesheet" href="/lib/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="/lib/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    var pageIndex = "info";
</script>
<body style="text-align: center;">
<%
    String openId = (String) request.getAttribute("openId");
    out.print("<script>var openId='" + openId + "';</script>");
%>
<img onclick="showPicture('${competitor.pictureUrl}')" style="width: 480px;height: 480px;margin: 100px auto;" src="${competitor.pictureUrl}">
<p style="font-size: 47px;color: #f72f3f;">${competitor.name}</p>
<div style="width: 380px;height: 50px;margin: 0 auto ;">
    <span style="float: left;font-size: 47px;color: #f72f3f;">${competitor.number}号</span>
    <span style="float: right;font-size: 47px;color: #f72f3f;">${competitor.pollCount}票</span>
</div>
<button onclick="poll(${competitor.competitorId})" style="font-size: 49px;width: 450px;height: 120px;background-color: #f72f3f;color: #ffffff;margin-top: 50px;" class="btn btn-default">投TA一票</button>
<p style="margin-top:40px;font-size: 49px;color: #000000;font-weight: bold;">宣言</p>
<p style="margin:40px;font-size: 35px;color: #000000;">${competitor.declaration}</p>
<img style="width: 380px;height: 380px;margin-bottom: 150px;" src="/resources/mbrgnv/img/qrcode_rgn.jpg">
<%@include file="footer.html" %>
<script type="text/javascript">
    function showPicture(url){
        window.location.href = "/mbrgnv/picture?pictureUrl="+url;
    }
</script>
</body>
</html>
