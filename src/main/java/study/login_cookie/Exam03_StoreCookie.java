package study.login_cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/login_cookie/Exam03_StoreCookie")
public class Exam03_StoreCookie extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("text/html; charset=UTF-8");
		String adminPage = "/study/exam/exam03_Admin.jsp";
		String loginPage = req.getContextPath()+"/study/exam/exam03_Login.jsp";		
		
		String mid = req.getParameter("mid")==null ? "guest" : req.getParameter("mid");
		Cookie cookieMid = new Cookie("cMid", mid);
		cookieMid.setMaxAge(60*60*24*7);
		resp.addCookie(cookieMid);
		
		String pwd = req.getParameter("pwd")==null ? "" : req.getParameter("pwd");
		Cookie cookiePwd = new Cookie("cPwd", pwd);
//		cookiePwd.setMaxAge(60*60*24*7);
		resp.addCookie(cookiePwd);
				
		if(!mid.equals("admin") || !pwd.equals("1234")) {			
			resp.sendRedirect(loginPage + "?error=invalid"); // a query for the err message 		
		}else {
			req.setAttribute("message", "Welcome Admin");
			req.getRequestDispatcher(adminPage).forward(req, resp);
		}
	}
}
