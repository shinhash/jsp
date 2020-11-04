package kr.or.ddit.fileupload.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.WebTestConfig;


public class FileUploadControllerTest extends WebTestConfig{

	
	@Test
	public void fileuploadGetTest() throws Exception {
		
		mockMvc.perform(get("/fileupload/view")).andDo(print());
//		mockMvc.perform(get("/fileupload/view")).andExpect(status().isOk()).andExpect(view().name("fileupload/fileupload"));
		MvcResult result = mockMvc.perform(get("/fileupload/view")).andReturn();
		
		ModelAndView mav = result.getModelAndView();
		String viewName = mav.getViewName();
		assertEquals("fileupload/fileupload", viewName);
	}
	
	
	
	@Test
	public void fileuploadPostTest() throws Exception {
		
		InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/sally.png");
//		InputStream is = Thread.currentThread()
//								.getContextClassLoader()
//								.getClass()
//								.getResourceAsStream("/kr/or/ddit/upload/sally.png");
		
//		FileInputStream fis = new FileInputStream("D:\\A_TeachingMaterial\\6.JspSpring\\workspace\\spring\\src\\test\\resources\\kr\\or\\ddit\\upload\\sally.png");
		MockMultipartFile file = new MockMultipartFile("file", "sally.png", "image/png", is);
		mockMvc.perform(fileUpload("/fileupload/upload")
								.file(file)
								.param("userid", "brown"))
						.andExpect(view().name("fileupload/fileupload"))
						.andExpect(status().isOk());
	}
}
