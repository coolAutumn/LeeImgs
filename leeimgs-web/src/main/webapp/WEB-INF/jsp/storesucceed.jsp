<%--
  Created by IntelliJ IDEA.
  User: coolAutumn
  Date: 10/12/16
  Time: 08:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Store Succeed</title>
</head>
<body>
    <h2>Congratulations!You have store the img sucessful.</h2>
    <br/>
    <p>You can get the img by <code><%=basepath%>/fetchimg?imgurl=${imgurl}</code></p>
</body>
</html>
