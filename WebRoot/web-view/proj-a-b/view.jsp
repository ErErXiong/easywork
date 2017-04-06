<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<!-- css/js -->
<link rel="stylesheet" href="web-part/easyui/themes/insdep/easyui.css" />
<link rel="stylesheet"
	href="web-part/easyui/themes/insdep/easyui_animation.css" />
<link rel="stylesheet"
	href="web-part/easyui/themes/insdep/easyui_plus.css" />
<link rel="stylesheet"
	href="web-part/easyui/themes/insdep/insdep_theme_default.css" />
<link rel="stylesheet" href="web-part/easyui/themes/insdep/icon.css" />
<link rel="stylesheet"
	href="web-part/easyui/plugin/font-awesome-4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="web-part/easy/css/base.css" />
<script src="web-part/easyui/jquery.min.js"></script>
<script src="web-part/easyui/jquery.easyui-1.5.1.min.js"></script>
<script src="web-part/easyui/themes/insdep/jquery.insdep-extend.min.js"></script>
<script src="web-part/easy/js/base.js"></script>
<script src="web-part/easy/js/jquery.cookie.js"></script>
<script src="web-part/easy/js/jquery.time.js"></script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<!-- 标题栏 -->
		<div region="north" class="h60 bgc-1" border="false">
			<div class="vbox-0 ft-0">
				<i class="fa fa-paper-plane"></i>&nbsp;&nbsp;保 险 经 纪 网 上 约 单 平
				台&nbsp;&nbsp;->
			</div>
		</div>
		<!-- 导航栏 -->
		<div region="west" title="&nbsp;" class="theme-left-layout w250"
			border="false">
			<!-- 常规导航 -->
			<div class="theme-left-normal">
				<div class="easyui-layout" fit="true">
					<!-- 信息面板 -->
					<div region="north" class="theme-left-user-panel h50">
						<dl>
							<dt style="width:70px;font-size:42px;text-align:center;">
								<i class="fa fa-desktop"></i>
							</dt>
							<dd>
								<b>ADMIN</b><span>未登录</span>
							</dd>
						</dl>
					</div>
					<!-- 导航菜单 -->
					<div region="center">
						<div class="easyui-accordion" fit="true" border="false">
							<div title="业务管理">
								<ul class="easyui-datalist" fit="true" border="false">
									<li><span view="product" onclick="totab(this);">保险产品</span></li>
									<li><span view="intent" onclick="totab(this);">意向跟踪</span></li>
									<li><span view="apply" onclick="totab(this);">约单签单</span></li>
									<li><span view="allBought" onclick="totab(this);">已签订单</span></li>
								</ul>
							</div>
							<div title="留言管理">
								<ul class="easyui-datalist" fit="true" border="false">
									<li>已处理</li>
									<li>未处理</li>
								</ul>
							</div>
							<div title="统计分析"></div>
							<div title="系统设置">
								<ul class="easyui-datalist" fit="true" border="false">
									<li>管理员登录</li>
									<li>业务参数</li>
									<li>数据清理</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 最小化导航 -->
			<div></div>
		</div>
		<!-- 工作区 -->
		<div region="center" border="false">
			<!-- 标签页 -->
			<div id="mytab"
				class="easyui-tabs theme-tab-black-block theme-tab-unborder vbox-0"
				fit="true">
				<!-- 欢迎 -->
				<div title="欢迎访问"></div>
			</div>
		</div>
	</div>
	<script>
		//打开标签页
		function totab(obj) {
			//iframe
			var frm = "<iframe scrolling='auto' frameborder='0' style='width:98%;height:98%;' src='demo/tab/"
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
