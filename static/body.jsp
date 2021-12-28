<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>  
    <title>首页体</title>
  </head>
  
  <body style="text-align:center;">
    <div id="content" style="margin:0 auto;width:840px;">

    	<div id="bookandpage" style="float:left; margin-left:30px;">   		
    		<div id="books">
    			<c:forEach var="book" items="${pagenum == null || pagenum == 1 ? sessionScope.indexPage : page.list}">
    				<div id="book" style="height:150; margin-top:20px;">
    					<div id="image" style="float:left;">
    						<img src="${pageContext.request.contextPath }/images/${book.image}" height=150 width=100>
    					</div>
    					<div id="bookinfo" style="float:left; text-align:left;">
    						<ul>
    							<li>${book.name }</li>
								<li>ID：${book.id}</li>
    							<li>作者：${book.author }</li>
    							<li>售价：${book.price }</li>
								<li>描述：${book.description} </li>
    							<li>
    								<a href="${pageContext.request.contextPath }/service/buyservlet?bookid=${book.id}&bookname=${book.name}&bookauthor=${book.author}&bookprice=${book.price}&bookimage=${book.image}&bookdescription=${book.description}">加入购物车</a>
    							</li>
    						</ul>
    					</div>
    				</div>
    				<div style="clear:both"></div><!-- 清除浮动效果 -->
    			</c:forEach>
    		</div>
    		<div style="clear:both"></div><!-- 清除浮动效果 -->
    		<div id="page" style="margin-top:20px; text-align:center;">
    			当前第[${page.pagenum }]页 &nbsp;&nbsp;
			    <c:forEach var="pagenum" begin="${page.startpage }" end="${page.endpage }">
			    	[<a href="${pageContext.request.contextPath }/indexservlet?method=${param.method }&pagenum=${pagenum}">${pagenum }</a>]
			    </c:forEach>
			    &nbsp;&nbsp;
			    总共[${page.totalpage }]页，共[${page.totalrecord }]条记录
    		</div>
    	</div>
    </div>
  </body>
</html>
