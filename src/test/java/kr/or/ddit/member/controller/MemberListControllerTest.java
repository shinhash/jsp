package kr.or.ddit.member.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.WebTestConfig;

public class MemberListControllerTest extends WebTestConfig{

	@Test
	public void memberListViewTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/memberList/view"))
												.andDo(print())
												.andReturn();
		ModelAndView mvc = result.getModelAndView();
		assertEquals("tiles/member/memberListContent", mvc.getViewName());
	}

}
