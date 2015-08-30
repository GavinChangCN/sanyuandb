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
    <style>
        body{
            margin: 0 auto 0 auto;
        }
        input {
            width: 200px;
        }
        textarea {
            width: 200px;
        }
        td {
            padding: auto 0 auto 0;
            margin: auto 0 auto 0;
        }
        .tdlabel {
            width: 240px;
            text-align: right;
            font-size: 16px;
        }
    </style>
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
    <form action="./addProductResult" method="post">
    <table class="table table" style="margin:0 30%; width: 40%;">
        <tr>
            <td class="tdlabel">分类</td>
            <td>
                <select name="midselect">
                    <option selected="selected">请选择分类</option>
                    <c:forEach items="${menuList}" var="item">
                        <option value="${item.id}">${item.title}</option>
                    </c:forEach>
                </select>
                <input type="button" class="btn btn-warning" value="添加分类" data-toggle="modal" data-target="#addMenuBody"/>
            </td>
        </tr>
        <tr>
            <td class="tdlabel">描述</td>
            <td><textarea name="pdesc" cols="30" rows="3" ></textarea></td>
        </tr>
        <tr>
            <td class="tdlabel">小图</td>
            <td><input name="icon" type="file" /></td>
        </tr>
        <tr>
            <td class="tdlabel">大图</td>
            <td><input name="pic" type="file" /></td>
        </tr>
        <tr>
            <td class="tdlabel">视频</td>
            <td><input name="video" type="file" /></td>
        </tr>
    </table>
        <div align="center"><input type="submit" class="btn btn-danger" value="保存" /></div>
    </form>
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="js/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/add_menu.js"></script>
</div>

</body>
</html>
