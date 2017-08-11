<%@ page import="pers.zhentao.zhaiyi.MostBeautifulRuiGuNiangVote.dto.SNSUserInfo" %><%--
  Created by IntelliJ IDEA.
  User: 张镇涛
  E-mail: zhangzhentao1995@163.com
  Date: 2017/8/5
  Time: 21:37 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>最美瑞姑娘</title>
    <meta name="viewport" content="width=device-width,user-scalable=0">
</head>
<body>
<%
    String openId = (String)request.getAttribute("openId");
    if(null != openId){
%>
<p><%=openId %></p>
<%
    }else {
        out.print("null");
    }
%>
</body>
</html>
