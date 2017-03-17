<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>考勤管理系统</title>
<script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="http://cdn.amazeui.org/amazeui/2.7.2/js/amazeui.min.js"></script>
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<link href="css/mian.css" rel="stylesheet">
<link rel="stylesheet" href="css/amazeui.min.css" />
<script>
    	function toSkip(newurl){
    		alert(newurl);
    		$("#from01").attr('action',newurl);   
    		$("#from01").submit();	             
    	}
    	
    </script>
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
				<h1 class="page-header">用户查询</h1>
				<div class="admin-content">
					<div class="admin-content-body">
						<div class="am-g">
							<div class="am-u-sm-12 am-u-md-6">
								<div class="am-btn-toolbar">
									<div class="am-btn-group am-btn-group-xs">
										<button type="button" class="am-btn am-btn-default" onclick="window.location.href='pages/department/departmentAdd.jsp'">
											<span class="am-icon-plus"></span>新增
										</button>
										<button type="button" class="am-btn am-btn-default"  onclick="toSkip('depart/delDepartment')" >
											<span class="am-icon-trash-o"></span> 删除
										</button>
									</div>
								</div>
							</div>
							<div class="am-u-sm-12 am-u-md-3">
								<div class="am-form-group">
									<select data-am-selected="{btnSize: 'sm'}">
										<option value="option1">所有部门</option>
										<option value="option2">开发</option>
										<option value="option3">财务</option>
										<option value="option3">人事</option>

									</select>
								</div>
							</div>
							<div class="am-u-sm-12 am-u-md-3">
								<div class="am-input-group am-input-group-sm">
									<input type="text" class="am-form-field"> <span
										class="am-input-group-btn">
										<button class="am-btn am-btn-default" type="button">搜索</button>
									</span>
								</div>
							</div>
						</div>

						<div class="am-g">
							<div class="am-u-sm-12">
								<form class="am-form" id="from01" action="sss">
									<table
										class="am-table am-table-striped am-table-hover table-main">
										<thead>
											<tr>
												<th class="table-check"><input type="checkbox" /></th>
												<th>ID</th>
												<th>部门名字</th>
												<th>部门负责人</th>
												<th class="table-set">操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${departlist}" var="departlist">
												<tr> 
													<td><input type="checkbox" name="did" value="${departlist.d_id}"/></td>
													<td>${departlist.d_id}</td>
													<td><a href="#">${departlist.d_name}</a></td>
													<td><c:forEach items="${list}" var="user">
															<c:if test="${departlist.d_fuZeRenId == user.u_id}">
																<c:out value="${user.u_name}"></c:out>
															</c:if>
														</c:forEach>
													</td>


													<td>
														<div class="am-btn-toolbar">
															<div class="am-btn-group am-btn-group-xs">
																<button
																	class="am-btn am-btn-default am-btn-xs am-text-secondary" onclick="toSkip('depart/selectpage')">
																	<span class="am-icon-pencil-square-o"></span> 编辑
																</button>
																<button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="toSkip('depart/delDepartment')">
																	<span class="am-icon-trash-o"></span> 删除
																</button>
															</div>
														</div>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<div class="am-cf">
										共${fn:length(departlist)}条记录
										<div class="am-fr">
											<ul class="am-pagination">
												<li class="am-disabled"><a href="#">«</a></li>
												<li class="am-active"><a href="#">1</a></li>
												<li><a href="#">2</a></li>
												<li><a href="#">3</a></li>
												<li><a href="#">4</a></li>
												<li><a href="#">5</a></li>
												<li><a href="#">»</a></li>
											</ul>
										</div>
									</div>
								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
</body>
</html>
