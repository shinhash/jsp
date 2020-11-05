package kr.or.ddit.member.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceI;

@RequestMapping("/memberList")
@Controller
public class MemberListController{
	
	private static final Logger logger = LoggerFactory.getLogger(MemberListController.class);


	@Resource(name = "memberService")
	private MemberServiceI memService;
	
	
	@RequestMapping(path="/view")
	public String memberList(@RequestParam(defaultValue = "1") String pageNum, Model model) {
		
		PageVO pageVO = new PageVO(Integer.parseInt(pageNum), 5);
		Map<String, Object> memMap = memService.selectMemberPage(pageVO);
		
		List<MemberVO> memListPage = (List<MemberVO>) memMap.get("memListPage");
		int pageCnt = (Integer) memMap.get("pageCnt");
		
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("memList", memListPage);
		model.addAttribute("pageCnt", pageCnt);
		
		return "member/memberList";
	}

}
