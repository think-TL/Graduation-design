<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>My JSP 'hello.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<title>考勤管理系统</title>
<script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="http://cdn.amazeui.org/amazeui/2.7.2/js/amazeui.min.js"></script>
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<link href="css/mian.css" rel="stylesheet">
<link rel="stylesheet" href="css/amazeui.min.css" />
<script src="http://code.highcharts.com/highcharts.js"></script>
<!--  <script>
      	$(document).ready(function(){
      		$("#useralter").click(function(){
      			$.ajax({
      			    type:"GET",
      			    url:"user/alter?u_id="+${user.u_id},
      			    dataType:"json",
      			    success:function(data){
      			    	alert("1");
						alert(data[0]);
      			    },
      			    error:function(jqXHR){
      			    	alert("发生错误:"+request.status);
      			    }
      			});
      		});
      	});
    </script> -->
    <script>
    	function toSkip(newurl){
    		$("#from01").attr('action',newurl);   
    		$("#from01").submit();	             
    	}
    	
    </script>
    
    
 <script language="JavaScript">
        $(document).ready(function() {
            var chart = {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            };
            var title = {
                text: '本月考勤情况'
            };
            var tooltip = {
                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
            };
            var plotOptions = {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        format: '<b>{point.name}%</b>: {point.percentage:.1f} %',
                        style: {
                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                        }
                    }
                }
            };
            var series = [{
                type: 'pie',
                name: 'Browser share',
                data: [
                    ['正常', ${test01}],
                    ['迟到', ${test02}],
                    ['早退', ${test03}],
                ]
            }];

            var json = {};
            json.chart = chart;
            json.title = title;
            json.tooltip = tooltip;
            json.series = series;
            json.plotOptions = plotOptions;
            $('#container').highcharts(json);
        });
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
				<li><a href="#">用户: <span>${user.u_name}</span></a></li>
				<li><a href="index.jsp">退出</a></li>
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
					<li data-am-collapse="{target: '#collapse03-nav'}"><a href="javascript:void(0)" onclick="toSkip('depart/departManage')">部门管理</a>
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
			 <form action="sss" method="post" id="from01"> 
			 	<input type="text" name="u_id" value="${user.u_id}" style="display:none"/>
			 </form>
				<h1 class="page-header">个人信息</h1>
				<h2><span>${user.u_name}</span><small>${user.u_job}</small>
				</h2>
				<table class="table table-striped">
					<tbody>
						<tr>
							<td><strong>性别：</strong></td>
							<td>${user.u_sex}</td>
							<td><strong>部门：</strong></td>
							<td>${department.d_name}</td>
						</tr>
						<tr>
							<td><strong>电子邮箱：</strong></td>
							<td>${user.u_email}</td>
							<td><strong>电话号码：</strong></td>
							<td>${user.u_phone}</td>
						</tr>
						<tr>
							<td><strong>家庭地址</strong></td>
							<td>${user.u_address}</td>
						</tr>
					</tbody>
				</table>
				
				<h2 class="sub-header">考勤分析</h2>
				<div class="row placeholders">
					<div class="col-xs-6 col-sm-3 placeholder ">
    					<div id="container" style="width: 550px; height: 400px; margin: 0 auto"></div>
					</div>

				</div>
			</div>
		</diV>
	</div>
</body>
</html>
