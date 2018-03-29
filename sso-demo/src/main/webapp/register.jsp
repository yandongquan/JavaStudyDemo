<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <META NAME="Author" CONTENT="javazhan.com">
	<meta name="keywords" content="" />
	<meta name="description" content="" />
    <title>注册</title>
	<link rel="icon" href="favicon.ico">
    <link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css">
    <!-- <link rel="stylesheet" type="text/css" href="static/css/style.css"> -->
    <link rel="stylesheet" type="text/css" href="static/css/font-awesome.min.css">
    <style type="text/css">
    	body {
		    background: rgb(90,90,90) url(static/images/bg.jpg) no-repeat fixed top;
		    background-size: 100% 100%;
		    line-height: 1.5;
		}
		.login {
			padding-top: 50px;
		}
		.main-box{
			background-color: #FFF;
			padding:18px 25px;
		}
		.form-header {
			text-align: center;
		}
		.vcode {
		    display: inline-block;
		    width: 200px;
		    margin-right: 0;
		}
		.btn-block {
			margin-bottom: 10px;
		}
		.extra {
			margin: 0 20px 20px 0;
		}
		.login-reg {
			text-align: center;
		}
    </style>
</head>
<body>
<div class="container login">
<div class="row">
<div class="col-sm-1 col-md-4">
&nbsp;
</div>
<div class="col-xs-12 col-sm-10 col-md-4">
<form id="form_sign" class="main-box" role="form" >
<h3 class="form-header">欢迎注册</h3>
    <div class="form-group">
        <input type="text" class="form-control" id="userName" name="userName" placeholder="请输入用户名">
    </div>
    <div class="form-group">
        <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
    </div>
    <div class="form-group">
        <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱">
    </div>
    <div class="form-group">
        <input type="text" class="form-control" id="phone" name="phone" placeholder="请输入手机号">
    </div>
<div class="form-group" id="error-msg"></div>
<a id="submitRegister" class="btn btn-primary btn-block">确认信息</a>
</form>
</div>
</div>
</div>
</div>
<script src='static/js/jquery-1.11.2.min.js'></script>
<script  src="static/js/base.js"></script>
</body>
</html>
