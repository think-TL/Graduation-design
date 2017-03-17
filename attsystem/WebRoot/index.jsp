<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Login Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <link href="css/signin.css" rel="stylesheet">
  </head>
  
      <div class="container">
        <h1 class="form-signin-heading">考勤打卡系统<h1>
        <form class="form-signin" action="login/main" method="get" role="form">
        <h2 class="form-signin-heading">Please login</h2>
         <input type="text" class="form-control" name="username" placeholder="username" required autofocus>
         <input type="password" class="form-control" name="password" placeholder="Password" required>
         <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
       </form>

     </div>
</html>
