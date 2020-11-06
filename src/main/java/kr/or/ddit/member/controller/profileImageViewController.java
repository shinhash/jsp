package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceI;

@RequestMapping("/profileImg")
@Controller
public class profileImageViewController{
	
	@Resource(name = "memberService")
	private MemberServiceI memService;
	
	@RequestMapping("view")
	public String profileView(String userid, Model model) throws IOException {
		
		// 응답으로 생성하려고 하는 것 : 이미지 파일을 읽어서 output stream 객체에 쓰는것
		
		
		// 역할을 나누기 위해서 view객체를 개발자가 직접 재구현 한다.
		MemberVO member = memService.getMember(userid);
		String filepath = member.getFilename();
		model.addAttribute("filepath", filepath);
		return "profileImgView";
	}
}
