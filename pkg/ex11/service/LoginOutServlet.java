package pkg.ex11.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.ex11.domain.Cart;
import pkg.ex11.domain.User;
import pkg.ex11.service.impl.BusinessServiceImpl;

public class LoginOutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BusinessService service = new BusinessServiceImpl();
		Object u = request.getSession().getAttribute("user");
		Object c = request.getSession().getAttribute("cart");
		if(u != null && c != null){
			User user = (User)u;
			service.writeCart((Cart)c, user.getId());
		}
		
		request.getSession().invalidate();
		request.getRequestDispatcher("/static/head.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}