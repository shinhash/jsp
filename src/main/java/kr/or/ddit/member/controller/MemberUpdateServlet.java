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


@WebServlet("/memberUpdate")
@MultipartConfig
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(MemberUpdateServlet.class);

	private MemberServiceI memService;
	private MemberVO memVO;
	
	@Override
	public void init() throws ServletException {
		memService = new MemberService();
		memVO = new MemberVO();
	
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		memVO = memService.getMember(userid);
		
		request.setAttribute("memVO", memVO);
		request.getRequestDispatcher("/member/memberUpdate.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("post");
		
		String userid = memVO.getUserid();
		String usernm = request.getParameter("usernm");
		String alias = request.getParameter("alias");
		String pass = request.getParameter("pass");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");
		
		
		Part filePart = request.getPart("realfilename");
		
		int updateCnt = 0;
		
		if(filePart != null && filePart.getSize() > 0) { // 파일이 추가 또는 변경된 경우

			String headerInfo = filePart.getHeader("Content-Disposition");
			String realfilename = FileUploadUtil.getFilename(headerInfo);
			String uuid = UUID.randomUUID().toString();
			String extensName = FileUploadUtil.getExtension(realfilename);
			String filename = "D:\\profile\\" + uuid + "." + extensName;
			filePart.write(filename);
			
			MemberVO newMemVO = new MemberVO(userid, pass, usernm, alias, addr1, addr2, zipcode, filename, realfilename);
			updateCnt = memService.updateMember(newMemVO);
			filePart.delete();
			
		}else { // 파일이 변경되지 않은경우
			
			MemberVO newMemVO = new MemberVO(userid, pass, usernm, alias, addr1, addr2, zipcode, memVO.getFilename(), memVO.getRealfilename());
			updateCnt = memService.updateMember(newMemVO);
		}
		
		
		if(updateCnt == 1) { // 성공적으로 update 했을 경우
			response.sendRedirect(request.getContextPath() + "/memberInfo?userid=" + userid);
		}else {// update 실패했을 경우
			doGet(request, response);
		}
		
		
	}
}
