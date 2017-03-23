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
<title>My JSP 'ins.jsp' starting page</title>
<link rel="stylesheet" href="web-part/easyui/themes/metro/easyui.css" />
<link rel="stylesheet" href="web-part/easyui/themes/icon.css" />
<link rel="stylesheet" href="web-part/easy/css/base.css" />
<link rel="stylesheet" href="web-part/icon/css/font-awesome.min.css" />
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div region="north" class="h150">业务管理-保险产品</div>
		<div region="center">业务管理-保险产品</div>
	</div>
	<!-- js -->
	<script src="web-part/easyui/jquery.min.js"></script>
	<script src="web-part/easyui/jquery.easyui.min.js"></script>
	<script>
		//
	</script>
</body>
</html>
