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
		
		logger.debug("get request.getContentType() : {}", request.getContentType());
		request.getRequestDispatcher("/fileUpload/uploadView.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		request.setCharacterEncoding("UTF-8");
		
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
