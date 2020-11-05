package kr.or.ddit.mvc.multiparam.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.common.model.Rangers;

@RequestMapping("/multi")
@Controller
public class MultiParamController {
	
	private static final Logger logger = LoggerFactory.getLogger(MultiParamController.class);

	
	// 복수개의 파라미터를 전송할 수 있는 화면을 요청
	// localhost/multi/view
	@RequestMapping(path="/view", method = RequestMethod.GET)
	public String paramView() {
		return "multi/view";			// /WEB-INF/views/multi/view.jsp
	}
	
	
	// 복수개의 파라미터 전송을 처리하는 메서드
	// userid라는 이름의 파라미터로 복수개의 값이 전달됨
	@RequestMapping(path="/submit", method = RequestMethod.POST)
	public String paramSubmit(@RequestParam("userid") List<String> userids, 
							  @RequestParam("userid") String[] userArr, 
							  String[] userid,
							  Rangers rangers) {
		
		logger.debug("userids : {}", userids);
		logger.debug("userArr : {}", (Object)userArr);
		logger.debug("userid : {}", (Object)userid);
		logger.debug("rangers : {}", rangers);
		
		for(String user : userArr) {
			logger.debug("user : {}", user);
		}
		return"multi/view";
	}
	
	
}
