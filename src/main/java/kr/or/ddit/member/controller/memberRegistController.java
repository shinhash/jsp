package kr.or.ddit.member.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.MemberVOValidator;
import kr.or.ddit.member.service.MemberServiceI;
import kr.or.ddit.mvc.fileupload.web.FileUploadUtil;

@RequestMapping("/memberRegist")
@Controller
public class memberRegistController{
	private static final Logger logger = LoggerFactory.getLogger(memberRegistController.class);

	@Resource(name = "memberService")
	private MemberServiceI memService;
	

	@RequestMapping(path="/view", method = RequestMethod.GET)
	public String memRegistView() {
//		return "member/memberRegist";
		return "tiles/member/memberRegistContent";
	}
	
	
	
	@RequestMapping(path="/regist", method = RequestMethod.POST)
	public String memRegistInsert(@Valid MemberVO memVO, BindingResult br, @RequestPart("file") MultipartFile file) {
//	public String memRegistInsert(MemberVO memVO, BindingResult br, @RequestPart("file") MultipartFile file) {
		
		
//		new MemberVOValidator().validate(memVO, br);
		
		
		if(br.hasErrors()) {
			return "tiles/member/memberRegistContent";
		}
		
		if(file.getSize() > 0 && !file.getOriginalFilename().equals("")) {
			
			String userRealFileName = file.getOriginalFilename();
			String uuid = UUID.randomUUID().toString();
			String userFileName = "D:\\profile\\" + uuid + "." + FileUploadUtil.getExtension(userRealFileName);

			memVO.setRealfilename(userRealFileName);
			memVO.setFilename(userFileName);
			
			File uuidFileName = new File(userFileName);
			try {
				file.transferTo(uuidFileName);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
		}else {
			memVO.setRealfilename("");
			memVO.setFilename("");
		}
		
		
		int insertMemberCnt = 0;
		try {
			insertMemberCnt = memService.insertMember(memVO);
		}catch(Exception e) { }
		
		if(insertMemberCnt == 1) {
			return "redirect:/memberList/view";
		}else {
			return "tiles/member/memberRegistContent";
		}
	}

}
