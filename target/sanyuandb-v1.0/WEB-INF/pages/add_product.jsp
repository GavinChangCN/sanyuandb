<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加用户</title>
    <link type="text/css" rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="css/add_product.css">
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
<div align="center">
    <div align="center"><b style="font-size: 24px;">录入产品</b></div>
    <table class="table table" style="margin:0 30%; width: 40%;">
        <tr>
            <td class="tdlabel">分类</td>
            <td>
                <select id="midselect" name="midselect">
                    <option selected="selected">请选择分类</option>
                    <c:forEach items="${menuList}" var="item">
                        <option value="${item.id}">${item.title}</option>
                    </c:forEach>
                </select>
                <input type="button" class="btn btn-warning" style="width: 85px;" value="添加分类" data-toggle="modal" data-target="#addMenuBody"/>
            </td>
        </tr>
        <tr>
            <td class="tdlabel">描述</td>
            <td><textarea id="pdesc" name="pdesc" cols="30" rows="3" ></textarea></td>
        </tr>
        <tr>
            <td class="tdlabel">小图</td>
            <td>
                <%--图片上传动画--%>
                <div id="uploadicon" class="uploading" style="display: none;">
                    <i></i>
                    <i></i>
                    <i></i>
                    <i></i>
                    <i></i>
                    <i></i>
                    <i></i>
                    <i></i>
                </div>
                <img class="addlogo" style="display: none;" id="iconimg" />
                <input id="icon" name="icon" type="file" class="btn btn-info"/>
            </td>
        </tr>
        <tr>
            <td class="tdlabel">大图</td>
            <td>
                <%--图片上传动画--%>
                <div id="uploadpic" class="uploading" style="display: none;">
                    <i></i>
                    <i></i>
                    <i></i>
                    <i></i>
                    <i></i>
                    <i></i>
                    <i></i>
                    <i></i>
                </div>
                <img class="addpic" style="display: none;" id="picimg"/>
                <input id="pic" name="pic" type="file" class="btn btn-primary"/>
            </td>
        </tr>
        <tr>
            <td class="tdlabel">视频</td>
            <td><input id="video" name="video" type="text" class="form-control" style="width: 200px;" placeholder="请输入Youtube视频链接"/></td>
        </tr>
    </table>
    <div align="center"><input type="button" class="btn btn-danger" value="保存" onclick="saveProduct()" /></div>
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="js/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/ajaxfileupload.js"></script>
    <script type="text/javascript" src="js/add_menu.js"></script>
    <script type="text/javascript" src="js/add_product.js"></script>
</div>

</body>
</html>
