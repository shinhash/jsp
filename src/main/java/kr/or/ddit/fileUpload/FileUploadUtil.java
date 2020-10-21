package kr.or.ddit.fileUpload;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUploadUtil {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtil.class);

	
	//form-data; name="img"; filename="moon.png"
	// ==> moon.png
	public static String getFilename(String contentDisposition) {

		Map<String, String> parseMap = new HashMap<String, String>();
		String[] parsingString = contentDisposition.split("; ");
		
		for(String parsed : parsingString) {
			if(!parsed.equals("form-data")) {
				String[] temp = parsed.split("=");
				parseMap.put(temp[0], temp[1].split("\"")[1]);
			}
		}
		
		return parseMap.get("filename");
	}
}
