package kr.or.ddit.fileUpload;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileUploadUtilTest {

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

}
