package kr.or.ddit.member.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceI;
import kr.or.ddit.mvc.fileupload.web.FileUploadUtil;


@RequestMapping("/memberUpdate")
@Controller
public class MemberUpdateController{
	
    private static final Logger logger = LoggerFactory.getLogger(MemberUpdateController.class);
    
    @Resource(name = "memberService")
	private MemberServiceI memService;
    
	private MemberVO memVO;
	private String memId;
	
	
	@RequestMapping(path="/view", method = RequestMethod.GET)
	public String memUpdateView(String userid, Model model) {
		memVO = memService.getMember(userid);
		memId = userid;
		model.addAttribute("memVO", memVO);
		
//		return "member/memberUpdate";
		return "tiles/member/memberUpdateContent";
	}
	
	
	
	@RequestMapping(path="/update", method = RequestMethod.POST)
	public String memberInfoUpdate(MemberVO upMember, @RequestPart("file") MultipartFile file) {
		
		upMember.setUserid(memId);			
		
		int updateCnt = 0;
		
		if(file.getSize() > 0 && !file.getOriginalFilename().equals("")) {
			
			String realfilename = file.getOriginalFilename();
			String uuid = UUID.randomUUID().toString();
			String extensName = FileUploadUtil.getExtension(realfilename);
			String filename = "D:\\profile\\" + uuid + "." + extensName;
			
			File upfile = new File(filename);
			try {
				file.transferTo(upfile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
			upMember.setFilename(filename);
			upMember.setRealfilename(realfilename);
			updateCnt = memService.updateMember(upMember);
			
		}else {
			upMember.setFilename(memVO.getFilename());
			upMember.setRealfilename(memVO.getRealfilename());
			updateCnt = memService.updateMember(upMember);
		}
		if(updateCnt == 1) {
			return "redirect:/memberInfo/view?userid=" + upMember.getUserid();
		}else {
			return "redirect:/memberUpdate/view?userid=" + memId;
		}
	}

}
