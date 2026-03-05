package study2.mapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.vo.TestVO;

public class BoardDeleteOkCommand implements ReInterface {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int num = request.getParameter("num")==null ? 0 : Integer.parseInt(request.getParameter("num"));
//		num = Math.abs(num);
		System.out.println("delete contents");
		
		List<TestVO> vos = new ArrayList<TestVO>();
		TestVO vo = null;
		for(int i=1; i<=10; i++) {
			vo = new TestVO();
			vo.setMid("hkd"+i);
			vo.setName("홍길동"+i);
			vo.setAge(25+i);
			vo.setAddress("서울"+i);
			vos.add(vo);			
		}
//		vos.remove(num);
		request.setAttribute("vos", vos);		
		
		request.setAttribute("msg", "delete contents");
		
		request.setAttribute("message", "the content deleted");
		request.setAttribute("url", "boardDelete.re");
	}

}
