<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.gavin.sanyuandb.common.PageParam"%>
<%@ page import="com.gavin.sanyuandb.model.Menus" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setAttribute("domain", "http://localhost/sanyuandb/");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
<style type="text/css">
	td {
		padding: auto 0 auto 0;
		margin: auto 0 auto 0;
	}
</style>
<title>首页</title>

</head>
<body>
	<div id="addMenuBody" class="modal fade" tabindex="-1" role="dialog" data-backdrop="static" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button id = "modalClose" type="button" class="close"
							data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title">
						添加分类
					</h4>
				</div>
				<div class = "modal-body">
					<div align="center"><b style="font-size: 18px;">添加分类</b></div>
					<table class="table table-striped" align="center" style="width: 80%; margin-top: 15px;">
						<tr>
							<td width="30%">分类标题</td>
							<td width="70%"><input type="text" id="mtitle" placeholder="Title"/></td>
						</tr>
					</table>
					<div align="center" style="margin-bottom: 10px;"><input type="button" class="btn btn-primary" style="width: 100px;" onclick="add_menu()" value="确认"/></div>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal fade -->
	<div id="optiondiv" align="center" style="margin: 30px 25% 0;">
		<table class="table" style="border: solid thin white;">
			<tr>
				<td style="width: 50%; float: left;">
					<select id="menuselect" class="selectpicker" data-style="btn-inverse" style="height: 34px; width:60%;">
						<option value="0" selected="
						<%
							PageParam pageParam = (PageParam) request.getAttribute("pageParam");
							int mid = pageParam.getMid();
							if (mid == 0) {
								%>selected<%
							}
						%>
						">全部</option>
						<c:forEach items="${menuParam.data}" var="menu">
							<option value="${menu.id}">${menu.title}</option>
						</c:forEach>
						<%--<%--%>
							<%--List<Menus> menulist = pageParam.getMenus() ;--%>
							<%--for ( Menus menu : menulist ) {--%>
								<%--if ( menu.getId() == mid ) {--%>
									<%--%><option value="<%=mid %>" selected="selected"><%=menu.getTitle() %></option><%--%>
								<%--}--%>
							<%--}--%>
						<%--%>--%>
					</select>
					<input type="button" class="btn btn-warning" value="添加分类" data-toggle="modal" data-target="#addMenuBody"/>
				</td>
				<td style="width: 50%; float: right;">
					<input class="btn btn-success" style="float: right; width:60%;" type="button" value="增加产品" onclick="add_product()" />
				</td>
			</tr>
		</table>
	</div>
	<div id="tablediv" align="center" style="margin: 0 25%;">
		<table class="table table-hover table-bordered">
			<tr class="info">
				<th>#</th>
				<th>类别</th>
				<th>描述</th>
				<th>Icon</th>
				<th>内附大图</th>
				<th>视频链接</th>
				<th>创建时间</th>
			</tr>
			<c:forEach items="${pageParam.data}" var="item">
			<tr>
				<th scope="row">${item.id}</th>
				<td>${item.mid}</td>
				<td>${item.pdesc}</td>
				<td>${item.icon}</td>
				<td>${item.pic}</td>
				<td>${item.video}</td>
				<td>${item.createtime}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<div id="pagediv" align="center">
		<nav>
			<ul class="pagination" style="margin-top: 0;">
				<%
					int currPage = pageParam.getCurrPage();
					int totalPage = pageParam.getTotalPage();
					%><li class="<%
					if (currPage == 1) {
						%>disabled<%
					}
					%>"><a href="index?mid=<%=mid %>&page=<%=currPage-1 %>" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li><%
					for (int i = 1; i <= totalPage; i ++) {
						if (i == currPage) {
							%><li class="active"><a href="#"><%=currPage %> <span class="sr-only">(current)</span></a></li><%
						} else {
							%><li><a href="index?mid=<%=mid %>&page=<%=i %>"><%=i %></a></li><%
						}
					}
					%><li class="<%
					if (currPage == totalPage) {
						%>disabled<%
					}
					%>"><a href="index?mid=<%=mid %>&page=<%=currPage+1 %>" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li><%
				%>
			</ul>
		</nav>
	</div>
	<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/bootstrap/bootstrap.min.js"></script>
	<script>
		var smid='<%=mid %>';
	</script>
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript" src="js/add_menu.js"></script>
</body>
</html>
