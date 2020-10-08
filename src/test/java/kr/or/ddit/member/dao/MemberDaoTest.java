package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.member.model.MemberVO;

public class MemberDaoTest {

	@Test
	public void getMemberTest() {

		/***Given***/
		MemberDaoI memDao = new MemberDao();
		String userId = "brown";
		
		MemberVO answerMemberVO = new MemberVO();
		answerMemberVO.setUserId("brown");
		answerMemberVO.setPassword("passBrown");
		
		
		
		/***When***/
		MemberVO memberVO =  memDao.getMember(userId);
		
		/***Then***/
//		assertEquals("brown", memberVO.getUserId());
//		assertEquals("passBrown", memberVO.getPassword());
		
		
		assertEquals(answerMemberVO, memberVO);
	}

}
