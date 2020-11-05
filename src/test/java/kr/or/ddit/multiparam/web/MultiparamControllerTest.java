package kr.or.ddit.multiparam.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.WebTestConfig;


public class MultiparamControllerTest extends WebTestConfig{

	@Test
	public void multiParamViewTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/multi/view")).andReturn();
		ModelAndView mvc = result.getModelAndView();
		assertEquals("multi/view", mvc.getViewName());
	}
	
	
	@Test
	public void multiParamSubmitTest() throws Exception {
		MvcResult result = mockMvc.perform(post("/multi/submit")
												.param("userid", "brown", "sally", "ryan"))
											.andDo(print())
											.andReturn();
		ModelAndView mvc = result.getModelAndView();
		assertEquals("multi/view", mvc.getViewName());
	}
	
	
	
	

}













