package kr.or.ddit.member.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.ModelTestConfig;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;


public class MemberDaoTest extends ModelTestConfig{

	
	@Resource(name="memberRepository")
	private MemberDaoI memDao;
	
	
	
	@Test
	public void getMemberTest() {
		/***Given***/
		
		/***When***/
		MemberVO member = memDao.getMember("brown");
		
		/***Then***/
		assertEquals("브라운", member.getUsernm());
	}
	
	
	@Test
	public void selectAllMemberTest() {
		/***Given***/

		/***When***/
		List<MemberVO> memList = memDao.selectAllMember();
		
		/***Then***/
		assertTrue(memList.size() > 13);
	}
	
	
	
	@Test
	public void selectMemberPageTest() {
		/***Given***/
		PageVO pageVO = new PageVO(1, 5);

		/***When***/
		List<MemberVO> memList = memDao.selectMemberPage(pageVO);

		/***Then***/
		assertEquals(5, memList.size());
	}
	
	
	
	
	@Test
	public void selectMemberTotalCntTest() {
		/***Given***/

		/***When***/
		int totalCnt = memDao.selectMemberTotalCnt();

		/***Then***/
		assertTrue(totalCnt > 13);
	}
	
	
	@Test
	public void insertMemberTest() {
		/***Given***/
		MemberVO member = new MemberVO("testuser001", "testuser001", "testuser001", "testuser001", "", "", "", "", "");

		/***When***/
		int insertCnt = memDao.insertMember(member);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}

	
	
	
	@Test
	public void updateMemberTest() {
		/***Given***/
		MemberVO upmember = new MemberVO("user001", "1234", "1234", "1234", "", "", "", "", "");

		/***When***/
		int updateCnt = memDao.updateMember(upmember);
		
		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	
	
	
	
}
