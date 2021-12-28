<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML">
<html>
  <head>
    <%
      request.setAttribute("url", "indexservlet?method=getAll");
      if(request.getAttribute("message").equals("用户名或密码不正确")){
        request.setAttribute("url", "static/head.jsp");
      }
    %>
    <%-- 3秒后跳转 --%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Refresh" content="3,url=${pageContext.request.contextPath}/${url}">
    <title>My JSP 'message.jsp' starting page</title>
  </head>
  
  <body>
    ${message}，三秒后将回到首页......
  </body>
</html>
