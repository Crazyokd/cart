package pkg.ex11.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkg.ex11.domain.Page;
import pkg.ex11.service.impl.BusinessServiceImpl;

public class IndexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if(method.equalsIgnoreCase("getAll")){
			getAll(request, response);
		}
	}

	private void getAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BusinessServiceImpl service = new BusinessServiceImpl();
		String pagenum = request.getParameter("pagenum");
		boolean isQuery = false;
		HttpSession session = request.getSession();
		if (session.getAttribute("indexPage") == null || (pagenum != null && Integer.parseInt(pagenum) > 1)){
			isQuery = true;
		}
		Page page = service.getBookPageData(pagenum, isQuery);
		if(page !=  null){
			if(pagenum == null || pagenum.equals("1")){
				session.setAttribute("indexPage", page.getList());
			}else{
				request.setAttribute("page", page);
			}
		}
		request.getRequestDispatcher("/static/body.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
