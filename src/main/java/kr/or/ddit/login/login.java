package kr.or.ddit.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(login.class);
    
    
    private MemberServiceI memService;
    
    @Override
    public void init() throws ServletException {
    	// service 객체 생성
    	memService = new MemberService();
    }
    
    

	// 로그인 화면을 클라이언트에게 응답으로 생성
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("loginServlet doGet()");
		logger.debug("UNT_CD parameter : {}", request.getParameter("UNT_CD"));
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}


	
	// login 화면에서 사용자가 보낸 아이디 비밀번호를 사용하여 로그인 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		logger.debug("userId = {}", userId);
		logger.debug("password = {}", password);
		
		System.out.println(userId);
		System.out.println(password);
		
		
		// 파라미터로 온 userId가 db상에 존재하는지 확인하고, 비밀번호가 데이터베이스에 저장된 비밀번호와 일치하는지 확인
		// 일치할 경우
		//	main페이지로 이동
		// 불일치할 경우
		//	login페이지로 이동
		//public MemberVO getMember(String userId)
		
		
		MemberVO memVO = memService.getMember(userId);
		
		
		// db에 등록된 회원이 없거나 비밀번호가 틀린 경우
		if(memVO == null || !memVO.getPass().equals(password)) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		// 비밀번호가 일치하는 경우 (메인페이지로 이동)
		else if(memVO.getPass().equals(password)) {
			request.getSession().setAttribute("S_MEMBER", memVO);
			request.getRequestDispatcher("/main.jsp").forward(request, response);			
		}
		
		
		// 쿠키정보
		Cookie[] cookies = request.getCookies();
		for(Cookie cookieInfo : cookies) {
			
			logger.debug("name = {}, value = {}", cookieInfo.getName(), cookieInfo.getValue());
		}
		Cookie cookie = new Cookie("SERVERCOOKIE", "COOKIEVALUE");
		cookie.setMaxAge(60*60*24);
		
		response.addCookie(cookie);
	}

}
