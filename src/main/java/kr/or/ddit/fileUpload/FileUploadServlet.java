package kr.or.ddit.fileUpload;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// maxFileSize : 파일 하나당 최대 허용 사이즈
// maxRequestSize : 요청에 담긴 모든 사이즈
// 단위 : byte
// 1 mb = 1024 kb = 1024 * 1024
// 10 mb = 1024 * 1024 * 1024
@WebServlet("/fileUpload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 26)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(FileUploadServlet.class);


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// fileUpload url요청(get)
		// 접속
		// /fileUpload/uploadView.jsp 해당 경로로 요청을 위임
		
		
		logger.debug("get request.getContentType() : {}", request.getContentType());
		request.getRequestDispatcher("/fileUpload/uploadView.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// form 데이터를 받는다.
		// form데이터에서 userid, img 정보를 받는다.
		// userid는 parameter로 받는다.
		// img는 Part객체로 받는다.(file을 담을수 있는 객체)
		// 해당 img태그의 image파일의 해더정보를 통해서 파일의 이름을 추출한다.
		// 추출한 이름을 가지고 해당경로에 파일을 생성(저장)한다.
		// 해당 파일의 사이즈가 maxFileSize의 크기를 초과할 경우에는 브라우져상에서 임시저장이 된다.
		// 이때 임시저장된 파일이 기록에 남으므로 기존의 데이터를 삭제하는 Part객체의 delete() 메서드를 호출하여 객체를 삭제한다.
		
		
		request.setCharacterEncoding("UTF-8");
		
		logger.debug("post request.getContentType() : {}", request.getContentType());
		
		String userid = request.getParameter("userid");
		String img = request.getParameter("img");
		logger.debug("userid : {}", userid);
		logger.debug("img : {}", img);
		
		Part imgPart = request.getPart("img");
		logger.debug("imgPart : {}", imgPart);
		logger.debug("imgPart.getName() : {}", imgPart.getName());
		logger.debug("imgPart.getSize() : {}", imgPart.getSize());
		logger.debug("imgPart.getContentType() : {}", imgPart.getContentType());
		
		logger.debug("Content-disposition : {}", imgPart.getHeader("Content-disposition"));
		
		
		String fileName = FileUploadUtil.getFilename(imgPart.getHeader("Content-disposition"));
		logger.debug("fileName = {}", fileName);
		imgPart.write("d:\\upload\\" + fileName);
		imgPart.delete();
		
		
		//Content-disposition : form-data; name="img"; filename="moon.png"
		
//		//request.getInputStream()
//		BufferedReader br = request.getReader();
//		char[] buffer = new char[512];
//		while(br.read(buffer) != -1) {
//			for(int i=0; i<buffer.length; i++) {
//				System.out.print(buffer[i]);
//			}
//			System.out.println();
//		}
	}

}
