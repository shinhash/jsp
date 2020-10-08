package kr.or.ddit.member.service;

import static org.junit.Assert.assertEquals;

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
		answerMemberVO.setUserId("brown");
		answerMemberVO.setPassword("passBrown");
		
		
		/***When***/
		MemberVO memberVO =  memService.getMember(userId);
		
		/***Then***/
//		assertEquals("brown", memberVO.getUserId());
//		assertEquals("passBrown", memberVO.getPassword());
		
		
		assertEquals(answerMemberVO, memberVO);
	}
}
