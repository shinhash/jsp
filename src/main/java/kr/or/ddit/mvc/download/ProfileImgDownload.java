package kr.or.ddit.mvc.download;

import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import kr.or.ddit.member.model.MemberVO;

public class ProfileImgDownload extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		MemberVO member = (MemberVO) model.get("member");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + member.getRealfilename() + "\"");
		response.setContentType("application/octet-stream");
		
		
		if(member.getFilename() != null) {
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
