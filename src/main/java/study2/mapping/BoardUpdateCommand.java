package study2.mapping;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardUpdateCommand implements ReInterface {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("update");
		
		request.setAttribute("name", "김말숙");
		request.setAttribute("content", "말숙이 소개서...");
		
		request.setAttribute("msg", "update contents");
	}

}
