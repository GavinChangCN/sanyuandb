<%--
  Created by IntelliJ IDEA.
  User: Gavin
  Mail: gavinchangcn@163.com
  Date: 2015/9/6 0006
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://"
          + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>
<%
  String account = "" ;
  try {
    account = session.getAttribute( "account" ).toString() ;
  }catch(Exception e) {
  }
%>
<html>
<head>
    <title></title>
</head>
<script type="text/javascript">
  var account = <%="'" + account + "'"%> ;
  if (account == "" || account == "undefined" || account == null) {
    alert("请先登录后尝试操作！");
    location.href="./signin"
  }
</script>
<body>

</body>
</html>
