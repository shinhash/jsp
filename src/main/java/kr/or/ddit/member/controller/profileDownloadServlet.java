package kr.or.ddit.member.controller;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.FileInfo;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;


@WebServlet("/profileDownload")
public class profileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberServiceI memService;
	
	@Override
	public void init() throws ServletException {
		memService = new MemberService();
	}
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		// 사용자 아이디 파라미터 확인
		String userid = request.getParameter("userid");

		// db에서 사용자 filename 확인
		MemberVO memVO = memService.getMember(userid);
		
		// response content-type 설정
		response.setHeader("Content-Disposition", "attachment; filename=\"" + memVO.getRealfilename() + "\"");
		response.setContentType("application/octet-stream");

		
		// 경로 확인 후 파일 입출력을 통해 응답생성
		// 파일 읽기
		// 응답 생성
		String filename = memVO.getFilename(); // 파일경로
		
		
		if(filename != null) {
			FileInputStream fis = new FileInputStream(filename);
			ServletOutputStream sos = response.getOutputStream();
			
			byte[] buffer = new byte[512];
			while(fis.read(buffer) != -1) {
				sos.write(buffer);
			}
			fis.close();
			sos.flush();
			sos.close();
		}
	}
}
