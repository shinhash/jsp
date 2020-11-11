package kr.or.ddit.member.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.InputStream;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.WebTestConfig;

public class MemberRegistControllerTest extends WebTestConfig{

	@Test
	public void memberRegistViewTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/memberRegist/view"))
											.andDo(print())	
											.andReturn();
		ModelAndView mvc = result.getModelAndView();
		assertEquals("tiles/member/memberRegistContent", mvc.getViewName());
	}
	
	
	@Test
	public void memberRegistInsertTest() throws Exception {
		
		InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/spongebob.png");
		MockMultipartFile file = new MockMultipartFile("file", "spongebob.png", "image/png", is);
		
		// is(302) ==> 리다이렉션 응답(해당 url에 대한 재요청)
		
		mockMvc.perform(fileUpload("/memberRegist/regist").file(file)
												.param("userid", "testuser001")
												.param("pass", "testuser001")
												.param("usernm", "testuser001")
												.param("alias", "testuser001")
												.param("addr1", "")
												.param("addr2", "")
												.param("zipcode", "")
												)
											.andDo(print())
											.andExpect(redirectedUrl("/memberList/view"))
											.andExpect(status().is3xxRedirection());
	}

}
