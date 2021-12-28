<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
  <head>  
    <title>首页头</title>
  </head>
  
  <body style="text-align:center;">
    <%-- <h1>登录</h1>

    <div>
	    <a href="${pageContext.request.contextPath }/indexservlet?method=getAll" target="body">首页</a>
	    <a href="${pageContext.request.contextPath }/static/listcart.jsp" target="body">查看购物车</a>
    </div> --%>
    <div style>
    	<c:if test="${user == null }"> 
      <br/>
	    <form action="${pageContext.request.contextPath }/service/loginservlet" method="post">
	    	<div>用户名：<input type="text" name="username" style="width:60px;"></div>
	    	<div> &nbsp;密码：&nbsp;&nbsp;<input type="password" name="password" style="width:60px;"></div><br/>
	    	<div><input type="submit" value="登录"></div>
	    </form>
	    </c:if>
    </div>
  </body>
</html>
