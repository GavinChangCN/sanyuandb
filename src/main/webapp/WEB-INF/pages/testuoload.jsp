<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>测试文件上传</title>
</head>
<body>
<div style="align: center;">
    <input type="file" id="file"/>
    <img src="" alt="测试文件图片" id="resultimg">
    <p id="resulttext"></p>

</div>
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<script type="text/javascript">
    $(function(){
        $("#file").change(function(){
            $.ajaxFileUpload(
            {
              url : "./saveupload",
                type : "post",
                fileElementId : "file",
                dataType : "json",
                success : function(data, status) {
                    alert(data);
                    $("#resultimg").src = data;
                    $("#resulttext").val(data);
                },
                error : function(data, status, e) {
                    alert("【服务器异常，请连续管理员！】"+e);
                }
            }
            );
        });
    });
</script>
</body>
</html>
