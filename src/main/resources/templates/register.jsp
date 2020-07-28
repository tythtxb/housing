<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String proto = request.getHeader("X-Forwarded-Proto");
    String port = request.getHeader("X-Forwarded-Port");
    if (proto == null)
        proto = request.getScheme();
    if (port == null)
        port = "" + request.getServerPort();
    String basePath = proto + "://" + request.getServerName() + ":"
            + port + path + "/";
%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <title>注册</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet"  th:href="@{/static/lib/bootstrap/css/bootstrap.css}">

    <link rel="stylesheet"   th:href="@{/static/stylesheets/theme.css}">
    <link rel="stylesheet"   th:href="@{/static/lib/font-awesome/css/font-awesome.css}">

    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
</head>

<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
<!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
<!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<body class="">
<!--<![endif]-->

<div class="navbar">
    <div class="navbar-inner">
        <ul class="nav pull-right">
        </ul>
        <a class="brand" href="old_index.html"><span class="first">皓星士</span> <span class="second">后台管理系统</span></a>
    </div>
</div>

<div class="row-fluid">
    <div class="dialog">
        <div class="block">
            <p class="block-heading">注册信息</p>
            <div class="block-body">
                <form id="loginForm" name="loginForm" method="post" modelAttribute="User">
                    <div class="form-group">
                        <label>用户名</label>
                        <input type="text" id="name" name="name" class="span12">
                    </div>
                    <div class="form-group">
                        <label>密码</label>
                        <input id="password" type="password" class="span12">
                    </div>
                    <div class="form-group">
                        <label>地址</label>
                        <input id="address" type="address" class="span12">
                    </div>
                    <div class="form-group">
                        <label>电话号码</label>
                        <input id="tel" type="tel" class="span12">
                    </div>
                    <a class="btn btn-primary pull-right" th:href="@{/user/register}"  onclick="loginForm.submit();">注册</a>
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>
    </div>
</div>
<script th:src="@{/static/lib/jquery-1.10.2.min.js}"></script>
<script th:src="@{/static/lib/bootstrap/js/bootstrap.js}"></script>
<script th:inline="javascript">
    $('#submit').click(function () {
        return checkForm();
    })
    function checkForm(){

        if($('#name').val() == ""){
            alert("用户名不能为空")
            return false;
        }else if($('#password').val() == ""){
            alert("密码不能为空");
            return false;
        }
        return true;
    }

    $("[rel=tooltip]").tooltip();
    $(function() {
        $('.demo-cancel-click').click(function(){return false;});
    });
</script>

</body>
</html>


