package study2.mapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import study.vo.TestVO;

public class BoardDeleteCommand implements ReInterface {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("delete contents");
		
		HttpSession session = request.getSession();
						
		List<TestVO> vos = (List<TestVO>) session.getAttribute("myList");
		if(vos==null) {
			vos = new ArrayList<TestVO>();
			TestVO vo = null;
			for(int i=1; i<=10; i++) {
				vo = new TestVO();
				vo.setMid("hkd"+i);
				vo.setName("홍길동"+i);
				vo.setAge(25+i);
				vo.setAddress("서울"+i);
				vos.add(vo);			
			}
			session.setAttribute("mylist", vos);
		}
		
		
//		request.setAttribute("num", num);
//		if(!(num==0) && num<11) vos.remove(num);
		request.setAttribute("vos", vos);		
		
		request.setAttribute("msg", "delete contents");		
	}

}
