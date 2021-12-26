<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>    
    <title>用户注册</title>
  </head>
  
  <body style="text-align:center;">
  	<form action="${pageContext.request.contextPath}/service/RegisterServlet" method="post">
    	用户名：<input type="text" name="username"><br/>
    	&nbsp; 密码： <input type="password" name="password"><br/>
    	&nbsp; 电话： <input type="text" name="phone"><br/>
        &nbsp; 邮箱： <input type="text" name="email"><br/>
    	<input type="submit" value="注册">
    </form>
  </body>
</html>
