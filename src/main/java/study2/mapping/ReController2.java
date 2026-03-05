package study2.mapping;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
//@WebServlet("*.re")
public class ReController2 extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("ReController");
		
		String uri = req.getRequestURI();
//		System.out.println("uri : " + uri);
		
		String com = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
//		System.out.println("com : " + com);
		if(com.equals("boardList")) {
			System.out.println("show board list");
		}
		if(com.equals("boardInput")) {
			System.out.println("write");
		}
		if(com.equals("boardUpdate")) {
			System.out.println("update");
		}
		if(com.equals("boardDelete")) {
			System.out.println("delete");
		}
		if(com.equals("boardSearch")) {
			System.out.println("search contents");
		}
		
		String viewPage = "/WEB-INF/study2/mapping/test2.jsp";
		req.getRequestDispatcher(viewPage).forward(req, resp);
	}

}
