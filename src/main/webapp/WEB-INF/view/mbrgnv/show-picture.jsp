<%--
  Created by IntelliJ IDEA.
  User: 张镇涛
  E-mail: zhangzhentao1995@163.com
  Date: 2017/8/10
  Time: 0:48 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>最美瑞姑娘</title>
</head>
<body style="text-align: center;">
<%
    String openId = (String) request.getAttribute("openId");
    out.print("<script>var openId='" + openId + "';</script>");
%>
<img style="margin: 0 auto;width: 100%;" src="${pictureUrl}">
</body>
</html>
