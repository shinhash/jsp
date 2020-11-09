package kr.or.ddit.mvc.download;

import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.AbstractView;

import kr.or.ddit.member.model.MemberVO;

public class ProfileImgDownload extends AbstractView{

	private static final Logger logger = LoggerFactory.getLogger(ProfileImgDownload.class);

	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setCharacterEncoding("utf-8");
		
		MemberVO member = (MemberVO) model.get("member");
		
		logger.debug("member info : {}", member);
		
		response.setContentType("application/octet-stream; charset=UTF-8");
		
		String downFileName = new String(member.getRealfilename().getBytes("UTF-8"), "ISO-8859-1");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + downFileName + "\"");
		
		
		if(member.getRealfilename() != null && !member.getFilename().equals("")) {
			FileInputStream fis = new FileInputStream(member.getFilename());
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
