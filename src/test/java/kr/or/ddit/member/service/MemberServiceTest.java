package kr.or.ddit.member.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.model.MemberVO;

public class MemberServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceTest.class);

	
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
		
		
//		assertEquals(answerMemberVO, memberVO);
		assertEquals(answerMemberVO.getUserid(), memberVO.getUserid());
		assertEquals(answerMemberVO.getPass(), memberVO.getPass());
	}
	
	
	
	
	
	
	
	@Test
	public void selectAllMemberTest() {
		/***Given***/
		MemberServiceI memService = new MemberService();

		/***When***/
		List<MemberVO> memList =  memService.selectAllMember();
		/***Then***/
//		assertNotNull(memList);
		
		// 이때 당시 user 테이블에 있던 데이터의 수는 5개 이지만 추후에 데이터를 추가했다.
//		assertEquals(5, memList.size());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void selectMemberPageTest() {
		
		/***Given***/
		MemberServiceI memService = new MemberService();

		/***When***/
//		List<MemberVO> memListPage = memService.selectMemberPage(1);
		
		/***Then***/
//		assertEquals(7, memListPage.size());
	}
	
	
	
	
	@Test
	public void test() {
		/***Given***/
		

		/***When***/
		logger.debug("{}", Math.ceil(15/7f));
		
		/***Then***/
	}
	
	
	
	
}
