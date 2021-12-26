<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>  
    <title>前台首页</title>
  </head>
  
  <frameset rows="17%,*">
  	<frame src="${pageContext.request.contextPath}/static/head.jsp" name="head">
  	<frame src="${pageContext.request.contextPath }/indexservlet?method=getAll" name="body">
  </frameset>

</html>