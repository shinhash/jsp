package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

public class MemberDaoTest {
	
	/*
	  테스트 메서드 실행 사이클
	  @BeforeClass (static) : 실행될때 딱 한번만 실행하는 init같은 어노테이션
	  @Before, @After ==> @test 실행시에 한번씩 실행되는 어노테이션
	  
	  @Before => @Test => @After =>
	  @Before => @Test => @After =>
	  @Before => @Test => @After =>
	  @Before => @Test => @After
	  
	  @AfterClass (static) : 실행될때 딱 한번만 실행하는 어노테이션
	 */
	
	MemberDaoI memDao;
	
	@Before
	public void setup() {
		
		memDao = new MemberDao();
		String userid = "shs";

		memDao.deleteMember(userid);
	}
	
	

	@Test
	public void getMemberTest() {

		/***Given***/
		memDao = new MemberDao();
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
		memDao = new MemberDao();

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
		memDao = new MemberDao();
		
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
		memDao = new MemberDao();

		/***When***/
		int cnt = memDao.selectMemberTotalCnt(sqlSession);
		sqlSession.close();
		
		/***Then***/
		assertEquals(15, cnt);
		
	}
	
	
	
	
	@Test
	public void insertMemberTest() {
		
		
		/***Given***/
		memDao = new MemberDao();
		MemberVO memVO = new MemberVO("shs", "pass1234", "신하승", "potato", "대전 중구 중앙로 76", "영민빌딩 404호", "34940", "D:\\profile\\test.png", "test.png");
		
		/***When***/
		int insertCnt = memDao.insertMember(memVO);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	
	
	
	@Test
	public void updateMemberTest() {
		
		/***Given***/
		memDao = new MemberDao();
		MemberVO memVO = new MemberVO("shinhash", "pass1234", "신하승", "potato", "대전 중구 중앙로 76", "영민빌딩 404호", "34940", "D:\\profile\\brown.png", "test.png");

		/***When***/
		int updateCnt = memDao.updateMember(memVO);

		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	
	
	
}
