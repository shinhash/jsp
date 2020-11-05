package kr.or.ddit.member;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.InputStream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.WebTestConfig;

public class MemberUpdateControllerTest extends WebTestConfig{

	private static final Logger logger = LoggerFactory.getLogger(MemberUpdateControllerTest.class);

	
	@Test
	public void memberUpdateViewTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/memberUpdate/view")
														.param("userid", "user004"))
												.andDo(print())
												.andReturn();
		ModelAndView mvc = result.getModelAndView();
		assertEquals("member/memberUpdate", mvc.getViewName());
	}
	
	
	
	
	@Test
	public void memberUpdateInfoUpdateTest() throws Exception {
		
		InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/spongebob.png");
		MockMultipartFile file = new MockMultipartFile("file", "spongebob.png", "image/png", is);
		
		logger.debug("file size : {}", file.getSize());
		
		// is(302) ==> 리다이렉션 응답(해당 url에 대한 재요청)
		
		String userid = "user004";
		mockMvc.perform(fileUpload("/memberUpdate/update")
											.file(file)
										.param("userid", userid)
										.param("pass", "user004")
										.param("usernm", "user004")
										.param("alias", "user004")
										.param("addr1", "")
										.param("addr2", "")
										.param("zipcode", "")
										)
									.andDo(print())
									.andExpect(redirectedUrl("/memberInfo/view?userid="+userid))
									.andExpect(status().is(302));
	}

}
