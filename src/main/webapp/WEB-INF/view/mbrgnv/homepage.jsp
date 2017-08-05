<%--
  Created by IntelliJ IDEA.
  User: 张镇涛
  E-mail: zhangzhentao1995@163.com
  Date: 2017/8/5
  Time: 9:34
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link type="text/css" rel="stylesheet" href="/lib/bootstrap/css/bootstrap.min.css">
<style type="text/css">
    .item-out {
        margin: 2%;
        float: left;
        background: #f57077;
        width: 46%;
        height: 560px;
        border-radius: 10px;
        position: relative;
    }

    .item-img {
        width: 380px;
        height: 380px;
        margin-top: 10px;
    }

    .item-name {
        font-size: 40px;
        color: white;
        margin: 10px;
        border-bottom: 2px solid white;
    }

    .item-poll-out {
        font-size: 45px;
        margin-left: 20px;
        margin-right: 20px;
        overflow: hidden;
        zoom: 1;
    }

    .item-poll {
        color: #ffffff;
        float: left;
    }

    .item-button {
        float: right;
        background-color: white;
        font-size: 45px;
        color: #f57077;
    }

    .item-number {
        color: #ffffff;
        font-style: normal;
        padding-top: 10px;
        font-size: 45px;
        position: absolute;
        top: 0px;
        right: 30px;
        display: block;
        width: 120px;
        height: 90px;
        background-image: url('/resources/mbrgnv/img/icon.png');
        background-position: 0px 0px;
        background-size: 2000px 145px;
    }
</style>
<script type="text/javascript">
    var pageIndex = "homepage";
</script>
<script type="text/javascript" src="/lib/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/lib/bootstrap/js/bootstrap.min.js"></script>
<body style="text-align: center;position: relative;">
<div class="panel panel-default">
    <img style="width: 100%;" src="/resources/mbrgnv/img/homepage_top.png">
</div>
<ul style="list-style: none;font-size:45px;height: 100px;margin:0 40px 0 40px;">
    <li style="float: left;width:30%;">123456</li>
    <li style="float: left;width:30%;">123456</li>
    <li style="float: left;width:30%;">123456</li>
</ul>
<ul style="list-style: none;font-size:45px;border-top: 5px solid #7d7d7d;padding-top: 30px;margin:0 40px 0 40px;">
    <li style="float: left;width:30%;position: relative;">
        <i style="position: absolute;top: -70px;left: 100px;background: url('/resources/mbrgnv/img/icon.png');background-size:3125px 208px;background-position:-185px -5px;width: 65px;height: 70px;display: block;"></i>参与数
    </li>
    <li style="float: left;width:30%;position: relative;">
        <i style="position: absolute;top: -70px;left: 100px;background: url('/resources/mbrgnv/img/icon.png');background-size:3125px 208px;background-position:-185px -5px;width: 65px;height: 70px;display: block;"></i>总票数
    </li>
    <li style="float: left;width:30%;position: relative;">
        <i style="position: absolute;top: -70px;left: 100px;background: url('/resources/mbrgnv/img/icon.png');background-size:3125px 208px;background-position:-185px -5px;width: 65px;height: 70px;display: block;"></i>访问量
    </li>
</ul>
<div id="div-search"
     style="padding-top:25px;width: 70%;height: 100px;border: 2px solid #f74f97;border-radius:30px;margin:0 auto;margin-top: 100px;">
    <i id="search-icon" class="glyphicon glyphicon-search" style="font-size: 37px;margin-right: 15px;"></i>
    <input id="search-input" type="text"
           style="display: none;width: 80%;font-size: 45px;height: 45px;border-style: none;outline: none;"
           placeholder="请输入选手编号或名字">
    <span id="search-hint" style="font-size: 45px;color: #8b8b8b;line-height: 5px;">
        请输入选手编号或名字
    </span>
    <i id="search-close" class="glyphicon glyphicon-remove"
       style="display: none;font-size: 37px;margin-left: 15px;"></i>
</div>
<div style="background-color: #f3f88c;width: 80%;height: 150px;margin: 40px auto;">
    <p style="font-size: 45px;color: #f7397c;">活动时间</p>
    <p style="font-size: 45px;color: #f7397c;">2017.08.05&nbsp;12:12&nbsp;-&nbsp;2017.08.05&nbsp;12:12</p>
</div>
<div id="list-div" style="width: 90%;margin:0 auto 190px;overflow:hidden;zoom:1;">
    <div class="item-out">
        <img onclick="showInfo()" class="item-img" src="/resources/mbrgnv/img/avatar.png">
        <p class="item-name">名称A</p>
        <div class="item-poll-out">
            <span class="item-poll">99票</span>
            <button class="btn btn-default item-button">投票</button>
        </div>
        <i class="item-number">1号</i>
    </div>
</div>
<%@include file="footer.html" %>
</body>
<script type="text/javascript">
    var isSearchShow = false;
    $("#div-search").on("click", function () {
        if (!isSearchShow) {
            $("#search-hint").hide();
            $("#search-input").show();
            $("#search-close").show();
            $("#search-input").focus();
            isSearchShow = true;
        }
    });
    $("#search-icon").on("click", function () {
        if (isSearchShow) {
            //do search

        }
    });
    $("#search-close").on("click", function () {
        if (isSearchShow) {
            $("#search-hint").show();
            $("#search-input").hide();
            $("#search-close").hide();
            $("#search-input").blur();
            isSearchShow = false;
            return false;
        }
    });
    $(window).scroll(function () {
        var scrollTop = $(this).scrollTop();
        var documentHeight = $(document).height();
        var windowHeight = window.innerHeight;
        if (scrollTop + windowHeight == documentHeight) {
            //scroll to bottom
            for (var i = 0; i < 10; i++) {
                var name = "名字A";
                var poll = "99";
                var number = "99";
                var avatar = "/resources/mbrgnv/img/avatar.png";
                var template = "<div class='item-out'><img onclick='showInfo()' class='item-img' src='" + avatar + "'> <p class='item-name'>" + name + "</p> <div class='item-poll-out'> <span class='item-poll'>" + poll + "票</span> <button class='btn btn-default item-button'>投票</button> </div> <i class='item-number'>" + number + "号</i> </div>";
                $("#list-div").append(template);
            }
        }
    });
    function showInfo() {
        window.location.href = "/mbrgnv/info";
    }
</script>
</html>
