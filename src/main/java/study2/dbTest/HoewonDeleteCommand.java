package study2.dbTest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HoewonDeleteCommand implements HoewonInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name")==null ? "" : request.getParameter("name"); 
		
		HoewonDAO dao = new HoewonDAO();
				
		int res = dao.setHoewonDelete(name);
		
		if(res != 0) {
			request.setAttribute("message", "회원정보삭제완료");
			request.setAttribute("url", "HoewonList.db");
		}
		else {
			request.setAttribute("message", "회원정보삭제실패");
			request.setAttribute("url", "DbTest.db");
		}

	}

}
