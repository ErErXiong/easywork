<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'zero.jsp' starting page</title>
<link rel="stylesheet" href="web-part/easyui/themes/metro/easyui.css" />
<link rel="stylesheet" href="web-part/easyui/themes/icon.css" />
<link rel="stylesheet" href="web-part/easy/css/base.css" />
<link rel="stylesheet" href="web-part/icon/css/font-awesome.min.css" />
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div region="north" class="h50">新增产品</div>
		<div region="center">
			<form id="addInsForm" action="proja/Goods/addInsForm" method="post" style="margin-left:100px;" >
				产品名：<input type="text" id="name" name="name" /><br> 产品周期：<input
					type="text" id="preiod" name="preiod" /><br> 创建人姓名：<input
					type="text" id="createname" name="createname" /><br> 创建时间：<input
					type="datetime" id="createtime" name="createtime" /><br> 价格：<input
					type="text" id="price" name="price" /><br> 折扣：<input
					type="text" id="discount" name="discount" /><br> 底价：<input
					type="text" id="buttomprice" name="buttomprice" /><br> 定金价：<input
					type="text" id="bookprice" name="bookprice" /><br> 上架状态：<input
					type="text" id="state" name="state" /><input type="reset"
					style="margin-left: 120px;"><br> 产品类型：<input
					type="text" id="type" name="type" /><input type="submit"
					style="margin-left: 120px;"><br> 备注：
				<textarea rows="3" cols="40" name="memo"></textarea>

			</form>
		</div>
	</div>
	<!-- js -->
	<script src="web-part/easyui/jquery.min.js"></script>
	<script src="web-part/easyui/jquery.easyui.min.js"></script>
	<script>
	//
	</script>
</body>
</html>
