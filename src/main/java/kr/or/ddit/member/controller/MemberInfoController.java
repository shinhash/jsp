package kr.or.ddit.member.controller;


import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.MemberVOValidator;
import kr.or.ddit.member.service.MemberServiceI;

@RequestMapping("/memberInfo")
@Controller
public class MemberInfoController{
	
	private static final Logger logger = LoggerFactory.getLogger(MemberInfoController.class);

	
	
	@Resource(name = "memberService")
	private MemberServiceI memService;

	
	
	
	@RequestMapping("/view")
	public String memberInfoView(String userid, Model model) {
		
		MemberVO memVO = memService.getMember(userid);
		model.addAttribute("memVO", memVO);
		
//		return "member/memberInfo";
		return "tiles/member/memberInfoContent";
	}
	
	
	
	
	
	@RequestMapping("/ajaxView")
	public String memberInfoAjaxView() {
		return "tiles/member/memberInfoAjax";
	}
	
	
	@RequestMapping("/ajaxRes")
	public String memberInfoAjax(String userid, Model model) {
		
		MemberVO memVO = memService.getMember(userid);
		
		logger.debug("memVO : {}", memVO);
		model.addAttribute("memVO", memVO);
		
		return "jsonView";
	}
	
	
}
