package kr.or.ddit.mvc.ajax.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.member.model.MemberVO;

@Controller
public class AjaxController {

	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);

	
	@RequestMapping("/ajax/view")
	public String view() {
		logger.debug("AjaxController.view()");
		return "ajax/view"; // jsp
	}
	
	
	// consumes, produce(수신, 응답 제한)
	// consumes : 사용자가 보내는 contentType을 제한
	// produces : 사용자가 응답 받기 희망(Accept header, jqery - dataType)하는
	//				mimeType을 제한
	// server controller 
	// 	==> consumes = {"application/xml"}
	// ajax
	//	==> type - json
	// 		==> Unsupported Media Type(415) --> 보내는 타입과 받는 타입이 일치하지 않다는 에러
	
	// 반환타입이 void일 경우 @RequestMapping의 path경로를 실행한다. ==> 간혹 404에러가 발생한다.
	
	@ResponseBody // controller에서 리턴하는 객체 결과를  converter를 통해 http body에 직접 전송
	@RequestMapping(path="/ajax/json", 
					consumes = {"application/json"}, 	// 수신 타입
					produces = {"application/json", "application/xml"}) 	// 응답 타입
	public MemberVO json(@RequestBody MemberVO member) { // --> 마샬링
		
		// 마샬링 ==> a객체언어를 b객체언어로 치환하는 행위
		//	=====> json(jsp) --> java
		
		logger.debug("member : {}", member);
		member.setAlias("베어그리스");
		
		
		return member; // jsp	--> 언 마샬링
	}
	
	
	
	
	
	
	
}
