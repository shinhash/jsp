package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;


@WebServlet("/memberList")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberListServlet.class);



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pageNum = 1;
		try {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		catch(NumberFormatException e) {}
		
		logger.debug("page number = {}", pageNum);
		
		MemberServiceI memService = new MemberService();
		
		
		PageVO pageVO = new PageVO(pageNum, 9);
//		pageInfo.setPageNum(pageNum);
//		pageInfo.setPageSize(6);
		
		
		Map<String, Object> memMap = memService.selectMemberPage(pageVO);
		
		List<MemberVO> memListPage = (List<MemberVO>) memMap.get("memListPage");
		int pageCnt = (Integer)memMap.get("pageCnt");
		logger.debug("pageCnt = {}", pageCnt);
		
		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("memList", memListPage);
		request.getRequestDispatcher("/member/memberList.jsp").forward(request, response);
	}

}
