<%--
  Created by IntelliJ IDEA.
  User: 张镇涛
  E-mail: zhangzhentao1995@163.com
  Date: 2017/8/5
  Time: 17:33
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link type="text/css" rel="stylesheet" href="/lib/bootstrap/css/bootstrap.min.css">
<style type="text/css">
    .rank-item-out {
        width: 100%;
        border-bottom: 1px solid #848484;
        height: 150px;
        margin: 0 auto;
    }

    .rank-item-number {
        float: left;
        width: 84px;
        height: 150px;
        display: block;
        font-size: 40px;
        padding-top: 40px;
    }

    .top-three-icon {
        float: left;
        width: 84px;
        height: 150px;
        display: block;
        background-size: 1895px 130px;
    }

    .first-icon {
        background-image: url('/resources/mbrgnv/img/icon.png');
        background-position: -1544px 19px;
    }

    .second-icon {
        background-image: url('/resources/mbrgnv/img/icon.png');
        background-position: -1624px 19px;
    }

    .third-icon {
        background-image: url('/resources/mbrgnv/img/icon.png');
        background-position: -1704px 19px;
    }

    .avatar {
        float: left;
        margin: 25px;
        width: 100px;
        height: 100px;
    }

    .info-div {
        float: left;
        margin-top: 23px;
    }

    .info-div-name {
        display: block;
        font-size: 40px;
    }

    .info-div-number {
        display: block;
        font-size: 40px;
    }

    .poll-label {
        font-size: 45px;
        float: right;
        margin: 25px;
    }

    .poll-number {
        color: #f72f3f;
        font-weight: bold;
    }
</style>
<script type="text/javascript">
    var pageIndex = "rank";
</script>
<script type="text/javascript" src="/lib/jquery/jquery-3.2.1.min.js"></script>
<body style="background-color: #f7397c;text-align: center;">
<div class="panel panel-default"
     style="margin:200px auto;width: 90%;background: #ffffff;position: relative;">
    <i style="position: absolute;top: -100px;left: 50%;margin-left: -350px;width:700px;height:155px;display: block;background-image: url('/resources/mbrgnv/img/icon.png');background-position: -265px -5px;background-size: 2050px 155px;"></i>
    <div id="rank-list-div" style="width: 90%;margin: 100px auto 0px;">
        <!-- test data start-->
        <div onclick='showInfo()' class="rank-item-out">
            <span>
                <i class="top-three-icon first-icon"></i>
            </span>
            <img class="avatar" src="/resources/mbrgnv/img/avatar.png">
            <div class="info-div">
                <span class="info-div-name">名字A</span>
                <span class="info-div-number">99号</span>
            </div>
            <p class="poll-label"><span class="poll-number">12345</span>票</p>
        </div>
        <div onclick='showInfo()' class="rank-item-out">
            <span>
                <i class="top-three-icon second-icon"></i>
            </span>
            <img class="avatar" src="/resources/mbrgnv/img/avatar.png">
            <div class="info-div">
                <span class="info-div-name">名字A</span>
                <span class="info-div-number">99号</span>
            </div>
            <p class="poll-label"><span class="poll-number">12345</span>票</p>
        </div>
        <div onclick='showInfo()' class="rank-item-out">
            <span>
                <i class="top-three-icon third-icon"></i>
            </span>
            <img class="avatar" src="/resources/mbrgnv/img/avatar.png">
            <div class="info-div">
                <span class="info-div-name">名字A</span>
                <span class="info-div-number">99号</span>
            </div>
            <p class="poll-label"><span class="poll-number">12345</span>票</p>
        </div>
        <div onclick='showInfo()' class="rank-item-out">
            <span class="rank-item-number">
                4
            </span>
            <img class="avatar" src="/resources/mbrgnv/img/avatar.png">
            <div class="info-div">
                <span class="info-div-name">名字A</span>
                <span class="info-div-number">99号</span>
            </div>
            <p class="poll-label"><span class="poll-number">12345</span>票</p>
        </div>
        <!-- test data end-->
    </div>
    <a id="load-more-btn" style="font-size: 45px;width: 90%;height: 100px;border: 0px;" class="btn btn-default">
        加载更多
    </a>
</div>
<%@include file="footer.html" %>
</body>
<script type="text/javascript">
    $("#load-more-btn").on("click", function () {
        for (var i = 0; i < 10; i++) {
            var rank = 4;
            var avatar = "/resources/mbrgnv/img/avatar.png";
            var name = "名字";
            var number = "99号";
            var poll = "123456";
            var template = "<div onclick='showInfo()' class='rank-item-out'>" +
                "<span class='rank-item-number'>4</span>" +
                "<img class='avatar' src='" + avatar + "'>" +
                "<div class='info-div'>" +
                "<span class='info-div-name'>" + name + "</span>" +
                "<span class='info-div-number'>" + number + "</span>" +
                "</div>" +
                "<p class='poll-label'>" +
                "<span class='poll-number'>" + poll + "</span>票" +
                "</p>" +
                "</div>";
            $("#rank-list-div").append(template);
        }
    });
    function showInfo() {
        window.location.href = "/mbrgnv/info";
    }
</script>
</html>
