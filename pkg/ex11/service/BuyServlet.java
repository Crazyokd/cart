package pkg.ex11.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.ex11.domain.Book;
import pkg.ex11.domain.Cart;
import pkg.ex11.service.impl.BusinessServiceImpl;

public class BuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			Book book = new Book(Integer.parseInt(request.getParameter("bookid")), request.getParameter("bookname"), 
				request.getParameter("bookauthor"), Double.parseDouble(request.getParameter("bookprice")), request.getParameter("image"), 
				request.getParameter("bookdescription"));
			BusinessService service = new BusinessServiceImpl();
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			if(cart == null){
				cart = new Cart();
				request.getSession().setAttribute("cart", cart);
			}
			service.buyBook(cart, book);
			request.getRequestDispatcher("/static/listcart.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "购买失败");
			request.getRequestDispatcher("/static/message.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
