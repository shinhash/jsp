package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;


@WebServlet("/profileImg")
public class profileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberServiceI memService;
	
	@Override
	public void init() throws ServletException {
		memService = new MemberService();
	}
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 사용자 아이디 파라미터 확인
		// db에서 사용자 filename 확인
		// 경로 확인 후 파일 입출력을 통해 응답생성
		
		String userid = request.getParameter("userid");
		MemberVO memVO = memService.getMember(userid);
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
