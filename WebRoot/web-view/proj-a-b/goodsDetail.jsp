<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'addIns.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="web-part/easyui/themes/metro/easyui.css" />
<link rel="stylesheet" href="web-part/easyui/themes/icon.css" />
<link rel="stylesheet" href="web-part/easy/css/base.css" />
<link rel="stylesheet" href="web-part/icon/css/font-awesome.min.css" />

</head>

<body>
	<div class="easyui-layout" fit="true">
		<div region="center">
			<table id="datagrid" class="easyui-datagrid"
				style="width:99%;height:99%" url="proja/Goods/queryGoodsById" fitColumns="true">
				<thead>
					<tr>
						<th field="id">产品编号</th>
						<th field="name" >产品</th>
						<th field="preiod" >保障期限</th>
						<th field="type" >针对人群</th>
						<th field="createid" >创建人编号</th>
						<th field="createname" >创建人</th>
						<th field="createtime" formatter="transferTime">创建时间</th>
						<th field="price" >价格</th>
						<th field="discount" >折扣</th>
						<th field="buttomprice" >折扣</th>
						<th field="bookprice" >折扣</th>
						<th field="memo">产品介绍</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</body>
</html>
