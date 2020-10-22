package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.fileUpload.FileUploadUtil;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;


@WebServlet("/memberRegist")
@MultipartConfig
public class memberRegist extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(memberRegist.class);
	
	private MemberServiceI memService;
	
	
	@Override
	public void init() throws ServletException {
		memService = new MemberService();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/member/memberRegist.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		request.setCharacterEncoding("UTF-8");
		
		String userid = request.getParameter("userid");
		String usernm = request.getParameter("usernm");
		String alias = request.getParameter("alias");
		String pass = request.getParameter("pass");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");
		
		logger.debug("parameters : {}, {}, {}, {}, {}, {}, {}", userid, usernm, alias, pass, addr1, addr2, zipcode);
		
		
		
		Part profile = request.getPart("realfilename");
		String headerInfo = profile.getHeader("Content-Disposition");
		String realfilename = FileUploadUtil.getFilename(headerInfo);
		
		// 파일 이름이 중복되는 현상이 발생하면 안되기 때문에 자바에서 지원하는 UUID라는 class를 사용한다.
		String filename = UUID.randomUUID().toString();
		String fileExtension = FileUploadUtil.getExtension(realfilename);
		
		logger.debug("header Info : {}", headerInfo);
		
		
		String filePath = "";
		if(profile.getSize() > 0) {
			filePath = "D:\\profile\\" + filename + "." +  fileExtension;
			profile.write(filePath);
		}
		
		// 사용자 정보 등록
		MemberVO memVO = new MemberVO(userid, pass, usernm, alias, addr1, addr2, zipcode, filePath, realfilename);
		int insertMemberCnt = memService.insertMember(memVO);
		logger.debug("insertMemberCnt : {}", insertMemberCnt);
		
		// 1건이 입력되었을때 : 정상 -> memberList 페이지로 이동
		if(insertMemberCnt == 1) {
			
			//response.sendRedirect()를 사용하면 해당 url을 다시 요청하는 것이기 때문에 contextPath를 사용해야한다.
			response.sendRedirect(request.getContextPath() + "/memberList");
		}
		// 1건이 아닐때 : 비정상 - 사용자가 데이터를 다시 입력할 수 있도록 등록페이지로 이동
		else {
			doGet(request, response);
		}
		
	}

}
