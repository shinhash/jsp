package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import kr.or.ddit.common.model.PageVO;
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
		
		
//		assertEquals(answerMemberVO, memberVO);
		assertEquals(answerMemberVO.getUserid(), memberVO.getUserid());
		assertEquals(answerMemberVO.getPass(), memberVO.getPass());
	}
	
	
	
	
	
	
	
	@Test
	public void selectAllMemberTest() {
		
		/***Given***/
		MemberDaoI memDao = new MemberDao();

		/***When***/
		List<MemberVO> memList = memDao.selectAllMember();
		
		/***Then***/
		// 이때 당시 user 테이블에 있던 데이터의 수는 5개 이지만 추후에 데이터를 추가했다.
//		assertEquals(5, memList.size());
		
	}
	
	
	
	
	
	
	
	
	@Test
	public void selectMemberPageTest() {
		
		/***Given***/
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		MemberDaoI memDao = new MemberDao();
		
		PageVO pageInfo = new PageVO();
		pageInfo.setPageNum(1);
		pageInfo.setPageSize(7);
		
		/***When***/
		List<MemberVO> memListPage = memDao.selectMemberPage(pageInfo, sqlSession);
		sqlSession.close();
		
		/***Then***/
		assertEquals(7, memListPage.size());
		
	}
	
	
	
	
	
	@Test
	public void selectMemberCntTest() {
		
		/***Given***/
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		MemberDaoI memdao = new MemberDao();

		/***When***/
		float cnt = memdao.selectMemberTotalCnt(sqlSession);
		sqlSession.close();
		
		/***Then***/
//		assertEquals(15, cnt);
	}
	
	
	
}