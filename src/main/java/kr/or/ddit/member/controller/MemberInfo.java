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


@WebServlet("/memberInfo")
public class MemberInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberServiceI memService;

	
	
	@Override
	public void init() throws ServletException {
		memService = new MemberService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// userid 파라미터 받기
		// service 객체 준비
		// jsp 위임
		
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		MemberVO memVO = memService.getMember(userid);
		request.setAttribute("memVO", memVO);
		request.getRequestDispatcher("/member/memberInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
