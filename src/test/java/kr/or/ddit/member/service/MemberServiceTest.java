package kr.or.ddit.member.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.model.MemberVO;

public class MemberServiceTest {

	
	@Test
	public void getMemberTest() {

		/***Given***/
		MemberServiceI memService = new MemberService();
		String userId = "brown";
		
		MemberVO answerMemberVO = new MemberVO();
		answerMemberVO.setUserid("brown");
		answerMemberVO.setPass("brownPass");
		
		
		/***When***/
		MemberVO memberVO =  memService.getMember(userId);
		
		/***Then***/
//		assertEquals("brown", memberVO.getUserId());
//		assertEquals("passBrown", memberVO.getPassword());
		
		
		assertEquals(answerMemberVO, memberVO);
	}
	
	
	
	@Test
	public void selectAllMemberTest() {
		/***Given***/
		MemberServiceI memService = new MemberService();

		/***When***/
		List<MemberVO> memList =  memService.selectAllMember();
		/***Then***/
//		assertNotNull(memList);
		assertEquals(5, memList.size());
	}
	
	
	
}
