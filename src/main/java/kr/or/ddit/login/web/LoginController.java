package kr.or.ddit.login.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceI;



// @WebServlet 혹은 web.xml url-mappring을 통해 url 등록
@SessionAttributes("rangers")
@RequestMapping("/login")
@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Resource(name = "memberService")
	private MemberServiceI memService;
	
	
	
	
	
	
	@ModelAttribute("rangers")
	public List<String> ranger(){
		
		logger.debug("rangers()");
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("sally");
		rangers.add("moon");
		rangers.add("ryan");
		
		return rangers;
	}
	
	
	
	
	
	
	
	// localhost/login/view 요청시 처리되는 메서드
	// 요청 메서드가 GET일 때만 처리
	// 요청 메서드가 복수개일 경우 ==> method={method=RequestMethod.GET, method=RequestMethod.POST}
	@RequestMapping(path="/view", method=RequestMethod.GET)
	@GetMapping
	public String getView() {
		logger.debug("LoginController.getView()");
		return "login/view";
	}
	
	
	// 파라미터 이름과 동일한 이름의 메서드 인자를 선언하면 스프링 프레임워크가 자동으로 바인딩 해준다.
	// 값을 담을 수 있는 객체를 메서드 인자로 선언한 경우에도 필드명과 파라미터 명이 동일하면 자동으로 바인딩 처리를 해준다.
	// 이때 값을 담는 객체를 스프링 프레임워크에서는 command 객체라고 명명한다. ==> MemberVO memVO
	
	// Model : view객체에서 응답을 생성할 때 참조할 데이터를 담는 객체
	//		   jsp/servlet 기반의 request역할을 담당
	@RequestMapping(path="/process", params = {"userid"})
	public String procecss(String userid, String pass, MemberVO memVO, 
					HttpSession session, Model model, 
					@RequestParam(name = "email", 
								  required = false, 
								  defaultValue = "tester@V@") String user_id) {
		
		MemberVO dbmember = memService.getMember(memVO.getUserid());
		logger.debug("LoginController.process()member : {}", dbmember);
		logger.debug("user_id : {}", user_id);
		
		// db에서 조회한 사용자 정보가 존재하면 ==> main.jsp로 이동
		// db에서 조회한 사용자 정보가 존재하지 않으면 ==> login.jsp로 이동
		if(dbmember != null && memVO.getPass().equals(dbmember.getPass())) {
			
			// session객체를 사용할 수 있다.
			session.setAttribute("S_MEMBER", dbmember);
			
			// jsp/servlet의 request.setAttribute("today", new Date())와 동일한 역할을 수행한다.
			model.addAttribute("to_day", new Date());
			
			// prefix : /WEB-INF/views/
			// surfix : .jsp
			return "main";
		}else {
			model.addAttribute("msg", "fail");
			return "login/view";			
		}
	}
	
	
	
	// localhost/login/unt/dd
	@RequestMapping("/unt/{unt_cd}")
	public String untMain(@PathVariable("unt_cd") String unt_cd) {
		logger.debug("unt_cd : {}", unt_cd);
		return "main";
	}
	
	
	
	
	
	// localhost/login/mavView
	@RequestMapping("/mavView")
	public ModelAndView mavView(@ModelAttribute("rangers") List<String> rangers,
								@ModelAttribute("test") MemberVO memVO) {
		
		// @ModelAttribute("test") MemberVO memVO는 null이 아닌 객체안의 값이 null인 객체를 불러온다 
		// 즉 초기화된 MemberVO를 가져온다.
		
		ModelAndView mav = new ModelAndView();
		
		logger.debug("mav attribute rangers : {}", rangers);
		logger.debug("mav attribute memVO : {}", memVO);
		
		// viewName을 설정
		mav.setViewName("main");
		mav.getModel().put("msg", "success");
		mav.getModelMap().addAttribute("msg", "fail");
		return mav;
	}
	
	
	
	
	
	
}