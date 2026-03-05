package study.j0303;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet()
public class T3_lifeCycle extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		
		String viewPage = "/study/0303/t3_lifeCycle.jsp";
		request.getRequestDispatcher(viewPage).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()");
		
		String viewPage = "/study/0303/t3_lifeCycle.jsp";
		request.getRequestDispatcher(viewPage).forward(request, response);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service()");
		
		String viewPage = "/study/0303/t3_lifeCycle.jsp";
		request.getRequestDispatcher(viewPage).forward(request, response);
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init()");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy()");
	}
}
