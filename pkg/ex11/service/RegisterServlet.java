package pkg.ex11.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.ex11.service.impl.BusinessServiceImpl;
// import utils.WebUtils;
import pkg.ex11.domain.User;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("进入doGet方法");
		try{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			
			User user = new User();
			user.setEmail(email);
			// user.setId(WebUtils.makeID());
			user.setPassword(password);
			user.setPhone(phone);
			user.setUsername(username);
			
			BusinessServiceImpl service = new BusinessServiceImpl();
			service.registerUser(user);
			request.setAttribute("message", "注册成功");
			request.getRequestDispatcher("/static/message.jsp").forward(request, response);//这里要跳转到首页，并且显示欢迎您，，，待修改
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "注册失败");
			request.getRequestDispatcher("/static/message.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
