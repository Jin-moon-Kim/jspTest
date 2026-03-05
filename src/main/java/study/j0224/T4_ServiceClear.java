package study.j0224;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/j0224/T4_ServerClear")
public class T4_ServiceClear extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.invalidate();		
		session.getServletContext().removeAttribute("aMid");
		
		String viewPage = req.getContextPath() + "/study/0224_storage/t4_ServerStorage.jsp";
		resp.sendRedirect(viewPage);
	}
}
