package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

public class MemberDaoTest {

	@Test
	public void getMemberTest() {

		/***Given***/
		MemberDaoI memDao = new MemberDao();
		String userId = "brown";
		
		MemberVO answerMemberVO = new MemberVO();
		answerMemberVO.setUserid("brown");
		answerMemberVO.setPass("brownPass");
		
		
		
		/***When***/
		MemberVO memberVO =  memDao.getMember(userId);
		
		/***Then***/
//		assertEquals("brown", memberVO.getUserId());
//		assertEquals("passBrown", memberVO.getPassword());
		
		
		assertEquals(answerMemberVO, memberVO);
	}
	
	
	
	
	
	
	
	
	
	@Test
	public void selectAllMemberTest() {
		
		/***Given***/
		MemberDaoI memDao = new MemberDao();

		/***When***/
		List<MemberVO> memList = memDao.selectAllMember();
		
		/***Then***/
		assertEquals(5, memList.size());
		
	}
	
	
}
