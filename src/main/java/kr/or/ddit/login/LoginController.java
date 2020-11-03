package kr.or.ddit.login;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceI;



// @WebServlet 혹은 web.xml url-mappring을 통해 url 등록
@RequestMapping("/login")
@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Resource(name = "memberService")
	private MemberServiceI memService;
	
	
	
	// localhost/login/view 요청시 처리되는 메서드
	@RequestMapping("/view.do")
	public String getView() {
		logger.debug("LoginController.getView()");
		return "login/view";
	}
	
	
	// 파라미터 이름과 동일한 이름의 메서드 인자를 선언하면
	// 스프링 프레임워크가 자동으로 바인딩 해준다.
	// 값을 담을 수 있는 객체를 메서드 인자로 선언한 경우에도 필드명과 파라미터 명이
	// 동일하면 자동으로 바인딩 처리를 해준다.
	// 이때 값을 담는 객체를 스프링 프레임워크에서는 command 객체라고 명명한다.
	@RequestMapping("/process")
	public String procecss(String userid, String pass, MemberVO memVO) {
		
		MemberVO memberVO = memService.getMember(userid);
		
//		logger.debug("LoginController.process() {} / {} //// {}", userid, pass, memVO);
		logger.debug("LoginController.process()member : {}", memberVO);
		return "login/view";
	}
	
}
