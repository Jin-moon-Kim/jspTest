package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/login/*")
public class CertiifcationFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)	throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
				
		HttpSession session = req.getSession(); // req.getSession(false);세션이 없으면 안 만든다.
		
		String login = (String) session.getAttribute("sLogin") == null ? "" : (String) session.getAttribute("sLogin");
//		System.out.println("getSession : " + session.getAttribute("sLogin"));
		
		String uri = req.getRequestURI();
		
		if(!uri.contains("/") && !uri.contains("/Main") && !uri.contains("/guest*") && !uri.contains("/login/") ) {			
			if(!uri.contains("/css/") && !uri.contains("/js/") /*&& !uri.contains("/images/")*/ ) {
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");			
			};
			if(login == null) {
				PrintWriter out = response.getWriter();
				out.println();
				out.println("<script>");
				out.println("alert('login plz');");
				out.println("location.href='"+req.getContextPath()+"/Login?loginSw=main_Login'");
				out.println("</script>");
			};			
		};
		
		
		chain.doFilter(request, response);
	}

}
