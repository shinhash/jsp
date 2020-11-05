package kr.or.ddit.member.controller;

import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceI;


@RequestMapping("/profileDownload")
@Controller
public class profileDownloadController{
	private static final long serialVersionUID = 1L;

	@Resource(name = "memberService")
	private MemberServiceI memService;

    
	@RequestMapping("/down")
	public void profileDown(String userid, HttpServletResponse response) throws IOException {
		
		MemberVO memVO = memService.getMember(userid);
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + memVO.getRealfilename() + "\"");
		response.setContentType("application/octet-stream");
		
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
