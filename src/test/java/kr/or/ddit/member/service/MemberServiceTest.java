package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.ModelTestConfig;
import kr.or.ddit.member.model.MemberVO;

public class MemberServiceTest extends ModelTestConfig{

	@Resource(name = "memberService")
	private MemberServiceI memService;
	
	
	
	@Test
	public void getMemberTest() {
		/***Given***/

		/***When***/
		MemberVO member = memService.getMember("brown");
		
		/***Then***/
		assertEquals("브라운", member.getUsernm());
	}
	
	
	
	@Test
	public void selectMemberPageTest() {
		/***Given***/
		PageVO pageVO = new PageVO(1, 5);

		/***When***/
		Map<String, Object> memMap = memService.selectMemberPage(pageVO);
		
		/***Then***/
		assertEquals(5, ((List<MemberVO>)memMap.get("memListPage")).size());
	}
	
	
	
	
	
	
	@Test
	public void insertMember_SUCCESS_Test() {
		
		/***Given***/
		MemberVO memVO = new MemberVO("test123", "test123", "test123", "test123", "", "", "", "", "");

		/***When***/
		int insertCnt = memService.insertMember(memVO);
		
		/***Then***/
		assertEquals(1, insertCnt);
		
	}
	
	
	
	
	
	//@Test
	public void insertMember_FAIL_Test() {
		
		/***Given***/
//		MemberVO memVO = new MemberVO("test123", "test123", "test123", "test123", "", "", "", "", "");

		/***When***/
//		int insertCnt = memService.insertMember(memVO);
		
		/***Then***/
//		assertEquals(1, insertCnt);
		
	}
	
	
	
	@Test
	public void updateMemberTest() {
		/***Given***/
		MemberVO member = new MemberVO("user001", "update", "update", "update", "", "", "", "", "");

		/***When***/
		int updateCnt = memService.updateMember(member);

		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	
	
	
	
	
	

}






