<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
  <head>  
    <title>首页头</title>
  </head>
  
  <body style="text-align:center;">
    <h1>网上书店</h1>

    <div>
	    <a href="${pageContext.request.contextPath }/indexservlet?method=getAll" target="body">首页</a>
	    <a href="${pageContext.request.contextPath }/static/listcart.jsp" target="body">查看购物车</a>
		<c:if test="${user==null }">
		<a href="${pageContext.request.contextPath}/static/login.jsp" target="head">登录</a>
		<a href="${pageContext.request.contextPath}/static/register.jsp" target="body">注册</a> 
	    </c:if>
	    
	    <c:if test="${user!=null }">
	    	${user.username } <a href="${pageContext.request.contextPath }/service/loginoutservlet">注销</a>
	    </c:if>
    </div>
  </body>
</html>
