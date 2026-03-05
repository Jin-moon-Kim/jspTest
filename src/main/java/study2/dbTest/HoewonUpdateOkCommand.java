package study2.dbTest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HoewonUpdateOkCommand implements HoewonInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name")==null ? "" : request.getParameter("name"); 
		int age = (request.getParameter("age")==null) || (request.getParameter("age").equals("")) ? 0 : Integer.parseInt(request.getParameter("age")); 
		String gender = request.getParameter("gender")==null ? "" : request.getParameter("gender"); 
		String address = request.getParameter("address")==null ? "" : request.getParameter("address"); 
 
		HoewonDAO dao = new HoewonDAO();
		
		HoewonVO vo = new HoewonVO();
		vo = dao.getHoewonSearch(name);
				
		vo.setName(name);
		vo.setAge(age);
		vo.setGender(gender);
		vo.setAddress(address);
		
		int res = dao.setHoewonUpdateOk(vo);
		
		if(res != 0) {
			request.setAttribute("message", "회원정보 수정완료");
			request.setAttribute("url", "HoewonList.db");
		}
		else {
			request.setAttribute("message", "회원정보 수정실패");
			request.setAttribute("url", "HoewonUpdate.db?name="+name);
		}
	}

}
