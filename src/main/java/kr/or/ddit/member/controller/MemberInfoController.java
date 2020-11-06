package kr.or.ddit.member.controller;


import javax.annotation.Resource;

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
	
	@Resource(name = "memberService")
	private MemberServiceI memService;

	
	@RequestMapping("/view")
	public String memberInfoView(String userid, Model model) {
		
		MemberVO memVO = memService.getMember(userid);
		model.addAttribute("memVO", memVO);
		return "member/memberInfo";
	}
}
