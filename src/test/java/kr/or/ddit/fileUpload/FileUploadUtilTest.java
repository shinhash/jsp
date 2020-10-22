package kr.or.ddit.fileUpload;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUploadUtilTest {

	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtilTest.class);

	
	
	@Test
	public void FileUploadUtilTest() {
		
		/***Given***/
		FileUploadUtil fu = new FileUploadUtil();
		String temp = "form-data; name=\"img\"; filename=\"moon.png\"";

		/***When***/
		String fileName = fu.getFilename(temp);

		/***Then***/
		assertEquals("moon.png", fileName);
	}

	@Test
	public void UUIDtest(){
		/***Given***/
		

		/***When***/
		String uuid = UUID.randomUUID().toString();
		logger.debug("uuid = {}", uuid);
		
		/***Then***/
	}
	
	
	
	
	
	@Test
	public void getExtensionFailTest() {
		/***Given***/
		String filename = "sally.png";

		/***When***/
		String ext = FileUploadUtil.getExtension(filename);

		/***Then***/
		assertEquals("png", ext);
	}
	
	
}
