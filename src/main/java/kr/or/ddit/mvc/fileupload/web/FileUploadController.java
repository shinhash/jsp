package kr.or.ddit.mvc.fileupload.web;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/fileupload")
@Controller
public class FileUploadController {

	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	
	// localhost/fileupload/view 요청시
	// jsp로 응답생성
	// jsp 에서는 파일을 선택할 수 있는 input태그 1개
	// userid 파라미터를 보낼수 있는 input 태그 1개
	// 전송을 담당하는 submit input 태그 1개
	// jsp : /WEB-INF/views/fileupload/fileupload.jsp
	
	
	
	
	
	@RequestMapping(path="/view", method = RequestMethod.GET)
	public String fileuploadGet() {
//		logger.debug("file upload get");
		return "fileupload/fileupload";
	}
	
	
	// 파일 업로드 처리 메서드
	@RequestMapping(path="/upload", method = RequestMethod.POST)
	public String fileuploadPost(String userid, @RequestPart("file") MultipartFile file) {
		
		logger.debug("userid : {}", userid);
		logger.debug("name : {} / fileName : {} / size : {}", file.getName(), file.getOriginalFilename(), file.getSize());
		
		File uploadFile = new File("D:\\upload\\" + file.getOriginalFilename());
		try {
			file.transferTo(uploadFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		// transferTo() 파일 데이터를 지정한 file로 저장
		return "fileupload/fileupload";
	}
	
	
	
	
	
}
