<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'view.jsp' starting page</title>
<link rel="stylesheet" href="web-part/easyui/themes/metro/easyui.css" />
<link rel="stylesheet" href="web-part/easyui/themes/icon.css" />
<link rel="stylesheet" href="web-part/easy/css/base.css" />
<link rel="stylesheet" href="web-part/icon/css/font-awesome.min.css" />
</head>
<body>
	<div class="easyui-layout" fit="true">
		<!-- 标题栏 -->
		<div region="north" class="h50 bgc-1">
			<div class="h10"></div>
			<div class="txt-c ft-0-c">
				<i class="fa fa-telegram"></i> 保 险 经 纪 网 上 约 单 平 台 A D M I N
			</div>
			<div class="ft-0-g">
				&nbsp;<i class="fa fa-user-circle"></i><span>未登录</span>
			</div>
		</div>
		<!-- 左侧导航 -->
		<div region="west" title="&nbsp;" class="w200">
			<div id="nav" class="easyui-accordion" style="height:250px;border:0;">
				<div title="<i class='fa fa-paper-plane'></i> 业务管理">
					<ul>
						<li style="line-height:25px;"><a class="link ft-g"
							href="javascript:" view="ins" onclick="toTab(this);">保险产品</a></li>
						<li style="line-height:25px;"><a class="link ft-g"
							href="javascript:" view="user" onclick="toTab(this);">注册用户</a></li>
						<li style="line-height:25px;"><a class="link ft-g"
							href="javascript:" view="user" onclick="toTab(this);">意向跟踪</a></li>
						<li style="line-height:25px;"><a class="link ft-g"
							href="javascript:" view="book" onclick="toTab(this);">签单记录</a></li>
					</ul>
				</div>
				<div title="<i class='fa fa-paper-plane'></i> 留言管理">
					<ul>
						<li style="line-height:25px;"><a class="link ft-g"
							href="javascript:">已处理</a></li>
						<li style="line-height:25px;"><a class="link ft-g"
							href="javascript:">未处理</a></li>
					</ul>
				</div>
				<div title="<i class='fa fa-paper-plane'></i> 统计分析"></div>
				<div title="<i class='fa fa-paper-plane'></i> 系统设置">
					<ul>
						<li style="line-height:25px;"><a class="link ft-g"
							href="javascript:">管理员登录</a></li>
						<li style="line-height:25px;"><a class="link ft-g"
							href="javascript:">其他设置</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- 中央区域 -->
		<div region="center">
			<div id="mytab" class="easyui-tabs" fit="true"></div>
		</div>
	</div>
	<!-- js -->
	<script src="web-part/easyui/jquery.min.js"></script>
	<script src="web-part/easyui/jquery.easyui.min.js"></script>
	<script>
		//打开子视图
		function toTab(obj) {
			//子视图iframe
			var frm = "<iframe scrolling='auto' frameborder='0' style='width:95%;height:95%;' src='demo/tab/"
					+ $(obj).attr("view") + "'></iframe>";
			//当tab已存在
			if ($("#mytab").tabs("exists", $(obj).text())) {
				$("#mytab").tabs("select", $(obj).text());
				return;
			}
			//新增tab
			$("#mytab").tabs("add", {
				title : $(obj).text(),
				content : frm,
				closable : true
			});
		}
	</script>
</body>
</html>
