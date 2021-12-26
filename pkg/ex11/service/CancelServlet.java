package pkg.ex11.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.ex11.domain.Cart;
import pkg.ex11.service.impl.BusinessServiceImpl;

public class CancelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        try{
            String bookid = request.getParameter("bookid");
            BusinessService service = new BusinessServiceImpl();
            Cart cart = (Cart) request.getSession().getAttribute("cart");
            service.removeBook(cart, bookid);
            request.getRequestDispatcher("/static/listcart.jsp").forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
            request.setAttribute("message", "移除失败");
            request.getRequestDispatcher("/static/message.jsp").forward(request, response);
        }
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}