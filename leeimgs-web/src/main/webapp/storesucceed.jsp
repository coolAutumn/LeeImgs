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
<body style="text-align: center">
    <h2>Congratulations!You have store the img sucessful.</h2>
    <br/>
    You can get the img by <a href=<%=basepath%>service/fetchimg?imgurl=<%=request.getAttribute("imgurl")%> > <%=basepath%>service/fetchimg?imgurl=<%=request.getAttribute("imgurl")%> </a></p>
    <img src="<%=basepath%>service/fetchimg?imgurl=<%=request.getAttribute("imgurl")%>"/>
</body>
</html>
