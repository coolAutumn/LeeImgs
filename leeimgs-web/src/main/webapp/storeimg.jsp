<%--
  Created by IntelliJ IDEA.
  User: coolAutumn
  Date: 10/12/16
  Time: 08:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Store Imgs</title>
</head>
<body style="text-align: center">
<form action="service/uploadimg" method="post" enctype="multipart/form-data">
    <input type="file" name="upimgs"/>
    <br/>
    <input type="submit"/>
</form>
</body>
</html>
