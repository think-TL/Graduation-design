<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>考勤管理系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="http://cdn.amazeui.org/amazeui/2.7.2/js/amazeui.min.js"></script>
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<link href="css/mian.css" rel="stylesheet">
<link rel="stylesheet" href="css/amazeui.min.css" />
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"> 考勤系统 </a>
		</div>

		<div id="navbar" class="navbar-collapese collapse in"
			aria-expanded="true">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">用户: xxx</a></li>
				<li><a href="#">退出</a></li>
				<li><a href="#">帮助</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
				<div class="col-sm-3 col-md-2 sidebar">

				<ul class="nav nav-sidebar">
					<li data-am-collapse="{target: '#collapse-nav'}"><a>人员模块</a></li>
				</ul>
				<ul class="am-collapse nav nav-sidebar" id="collapse-nav">
					<li><a href="javascript:void(0)" id="useralter"
						onclick="toSkip('user/returnPage')">人员信息修改</a></li>
					<li><a href="javascript:void(0)" onclick="toSkip('user/userManage')">人员管理</a></li>
				</ul>

				<ul class="nav nav-sidebar">
					<li><a>打卡</a></li>
				</ul>

				<ul class="nav nav-sidebar">
					<li data-am-collapse="{target: '#collapse03-nav'}"><a>部门管理</a>
					</li>
				</ul>
			
				<ul class="nav nav-sidebar">
					<li data-am-collapse="{target: '#collapse04-nav'}"><a>日常操作查询</a>
					</li>
				</ul>
				<ul class="am-collapse nav nav-sidebar" id="collapse04-nav">
					<li><a href="#">考勤记录分析</a></li>
				</ul>

				<ul class="nav nav-sidebar">
					<li data-am-collapse="{target: '#collapse05-nav'}"><a>数据处理分析</a>
					</li>
				</ul>
				<ul class="am-collapse nav nav-sidebar" id="collapse05-nav">
					<li><a href="#">数据月汇总</a></li>
					<li><a href="#">数据年汇总</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main ">
				<h1 class="page-header">个人资料</h1>
				<div class="admin-content">
					<div class="admin-content-body">
						<div class="am-g">
							<div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
								<div class="am-panel am-panel-default">
									<div class="am-panel-bd">
										<div class="am-g">
											<div class="am-u-md-4">
												<img class="am-img-circle am-img-thumbnail"
													src="http://s.amazeui.org/media/i/demos/bw-2014-06-19.jpg?imageView/1/w/200/h/200/q/80"
													alt="" />
											</div>
											<div class="am-u-md-8">
												<form class="am-form">
													<div class="am-form-group">
														<input type="file" id="user-pic">
														<p class="am-form-help">请选择要上传的文件...</p>
														<button type="button"
															class="am-btn am-btn-primary am-btn-xs">保存</button>
													</div>
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
								<form class="am-form am-form-horizontal" action="user/saveUser" method="get" >
									<div class="am-form-group">
										<label class="am-u-sm-3 am-form-label">姓名 / Name</label>
										<div class="am-u-sm-9">
											<input type="text" name="user_name">
										</div>
									</div>
									<div class="am-form-group">
										<label class="am-u-sm-3 am-form-label">密码 /Password </label>
										<div class="am-u-sm-9">
											<input type="text" name="user_password">
										</div>
									</div>

									<div class="am-form-group">
										<label class="am-u-sm-3 am-form-label">性别 / Sex</label>
										<div class="am-u-sm-9">
											<input type="text" name="user_sex">
										</div>
									</div>
									
									<div class="am-form-group">
										<label class="am-u-sm-3 am-form-label">电子邮件 / Email</label>
										<div class="am-u-sm-9">
											<input type="text" name="user_email">
										</div>
									</div>

									<div class="am-form-group">
										<label class="am-u-sm-3 am-form-label">电话 / Telephone</label>
										<div class="am-u-sm-9">
											<input type="text" name="user_phone">
										</div>
									</div>

									<div class="am-form-group">
										<label class="am-u-sm-3 am-form-label">QQ</label>
										<div class="am-u-sm-9">
											<input type="text" name="user_QQ">
										</div>
									</div>

									<div class="am-form-group">
										<label class="am-u-sm-3 am-form-label">家庭地址</label>
										<div class="am-u-sm-9">
											<input type="text" name="user_address">
										</div>
									</div>
									<div class="am-form-group">
										<label class="am-u-sm-3 am-form-label">职位/job</label>
										<div class="am-u-sm-9">
											<input type="text" name="user_job">
										</div>
									</div>
									<div class="am-form-group">
										<label class="am-u-sm-3 am-form-label">部门 /department</label>
										<div class="am-u-sm-9">
											<input type="text" name="user_depart">
										</div>
									</div>
									<div class="am-form-group">
										<label class="am-u-sm-3 am-form-label">权限 / Jurisdiction</label>
										<div class="am-u-sm-9">
											<input type="text" name="user_quanxian">
											<small>0表示普通用戶，1表示管理用戶</small>
										</div>
									</div>
									<div class="am-form-group">
										<div class="am-u-sm-6 am-u-sm-push-3">
											<button type="submit" class="am-btn am-btn-primary">用户添加</button>
										</div>

										<div class="am-u-sm-6 am-u-sm-push-3">
											<button type="button" class="am-btn am-btn-primary">返回</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			>
		</div>
	</diV>
	</div>
</body>
</html>
