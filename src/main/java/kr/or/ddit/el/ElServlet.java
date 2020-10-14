package kr.or.ddit.el;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

@WebServlet("/el")
public class ElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberServiceI memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(ElServlet.class);

	
	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/el/el.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String params = request.getParameter("scope");
		logger.debug("scope ==> {}", params);
		
		if(params.equals("requestValue")) {
			request.setAttribute("attr", params);
			
		}else if(params.equals("sessionValue")) {
			request.setAttribute("attr", params);
			request.getSession().setAttribute("attr", params);
			
		}else if(params.equals("applicationValue")) {
			request.setAttribute("attr", params);
			request.getSession().setAttribute("attr", params);
			getServletContext().setAttribute("attr", params);
			
		}
		
		
		// Map객체를 생성하여 request속성에 넣어준다
		Map<String, String> map = new HashMap<String, String>();
		map.put("brown", "브라운");
		map.put("sally", "셀리");
		request.setAttribute("map", map);
		
		
		
		List<String> list = new ArrayList<String>();
		request.setAttribute("rangerslist", memberService.selectAllMember());
		
		
		request.getRequestDispatcher("/el/el.jsp").forward(request, response);		
	}
}









