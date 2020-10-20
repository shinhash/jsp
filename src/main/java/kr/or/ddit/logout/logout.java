package kr.or.ddit.logout;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 삭제할 세션 정보를 임시적으로 저장하는 세션 생성
//		MemberVO memVO = (MemberVO) request.getSession().getAttribute("S_MEMBER");
//		request.getSession().setAttribute("logoutMember", memVO);
//		request.getSession().removeAttribute("S_MEMBER");

		request.getSession().invalidate();
		response.sendRedirect("login");
	}
}
