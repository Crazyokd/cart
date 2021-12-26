package pkg.ex11.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.ex11.domain.User;
import pkg.ex11.service.impl.BusinessServiceImpl;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		BusinessServiceImpl service = new BusinessServiceImpl();
		User user = service.loginUser(username, password);
		if(user == null){
			request.setAttribute("message", "用户名或密码不正确");
			request.getRequestDispatcher("/static/message.jsp").forward(request, response);
		}else{
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("cart", service.readCart(user.getId()));
			request.getRequestDispatcher("/static/head.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
