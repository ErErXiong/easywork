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
<title>My JSP 'ins.jsp' starting page</title>
<link rel="stylesheet" href="web-part/easyui/themes/metro/easyui.css" />
<link rel="stylesheet" href="web-part/easyui/themes/icon.css" />
<link rel="stylesheet" href="web-part/easy/css/base.css" />
<link rel="stylesheet" href="web-part/icon/css/font-awesome.min.css" />
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div region="north" class="h40">业务管理-保险产品</div>
		<div region="center">
			<table id="datagrid" class="easyui-datagrid"
				style="width:99%;height:99%" url="proja/Goods/queryGoodsByPaging"
				toolbar="#toolbar" rownumbers="true" fitColumns="true"
				pagination="true">
				<thead>
					<tr>
						<th field="id" hidden="true" >产品编号</th>
						<th field="name" width="15">产品</th>
						<th field="preiod" width="15">保障期限</th>
						<th field="type" width="15">产品针对人群</th>
						<th field="createname" width="15">创建人</th>
						<th field="createtime" width="15" formatter="transferTime">创建时间</th>
						<th field="price" width="15">价格</th>
						<th field="memo" width="50">产品介绍</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar">
				<a href="javascript:0" class="easyui-linkbutton" iconCls="icon-edit"
					plain="true" onclick="lookINS('lookGoodsView')">查看</a> <a
					href="javascript:" class="easyui-linkbutton" iconCls="icon-add"
					plain="true" onclick="newINS('addGoodsView')">新增</a> <a
					href="javascript:0" class="easyui-linkbutton" iconCls="icon-edit"
					plain="true" onclick="editINS('editGoodsView')">修改</a> <a
					href="javascript:0" class="easyui-linkbutton" iconCls="icon-remove"
					plain="true" onclick="destroyINS()">删除</a>
			</div>
		</div>
	</div>
	<!-- 设置弹窗 -->
	<div id="newView"></div>

	<!-- js -->
	<script src="web-part/easyui/jquery.min.js"></script>
	<script src="web-part/easyui/jquery.easyui.min.js"></script>
	<script src="web-part/easy/js/jquery.time.js"></script>
	<script type="text/javascript">
		/* formatter方法封装： val表示时间值，row表示影响的行数 */
		function transferTime(val, row) {
			return $.msfmt.todate(val, true, 8);
		}
		/* 点击 查看 按钮 ，在自定义的div里面 弹出一个弹窗 */
		function lookINS(url) {
			var iframePrefix = "<iframe id='newView' src='proja/Goods/";
			var iframeSuffix = "'style='height:97%;width:99%''/>";
			$("#newView").window({
				title : "保险详情",
				width : 800,
				height : 500,
				content : iframePrefix + url + iframeSuffix
			});
			/* 显示数据 */
			var ids = [];
			var rows = $("#datagrid").datagrid("getSelections");
			for (var i = 0; i < rows.length; i++) {
				ids.push(rows[i].id);
			};
			alert(ids);
			/*异步提交的另一种写法  $.post("url",{json参数},function(){成功后的函数})) */
			$.post("proja/Goods/queryGoodsById?state=b", {
				/* 传参，用JSON格式传 */
				rows : ids.toString()
			}, function(data) {});
		}
		/* 点击 新增 按钮 ，在自定义的div里面 弹出一个弹窗 */
		function newINS(url) {
			var iframePrefix = "<iframe id='newView' src='proja/Goods/";
			var iframeSuffix = "'style='height:97%;width:99%''/>";
			$("#newView").window({
				title : "新增保险",
				width : 800,
				height : 500,
				content : iframePrefix + url + iframeSuffix
			});
		}
	
		/* 点击 修改 按钮 ，在自定义的div里面 弹出一个弹窗 */
		function editINS(url) {
			var iframePrefix = "<iframe id='newView' src='proja/Goods/";
			var iframeSuffix = "'style='height:97%;width:99%''/>";
			$("#newView").window({
				title : "修改保险",
				width : 800,
				height : 500,
				content : iframePrefix + url + iframeSuffix
			});
		}
	
		function destroyINS() {
			var ids = [];
			var rows = $("#datagrid").datagrid("getSelections");
			for (var i = 0; i < rows.length; i++) {
				ids.push(rows[i].id);
			};
			alert(ids);
			/*异步提交的另一种写法  $.post("url",{json参数},function(){成功后的函数})) */
			$.post("proja/Goods/deleteGoods", {
				/* 传参，用JSON格式传 */
				rows : ids.toString()
			}, function(data) {
				/* 执行成功后， 查询数据（刷新页面） */
				alert("成功1");
				$("#datagrid").datagrid("load", {});
			});
		}
	</script>
</body>
</html>
