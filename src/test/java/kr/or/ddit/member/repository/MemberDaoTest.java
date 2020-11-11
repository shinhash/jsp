package kr.or.ddit.member.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.member.ModelTestConfig;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;


public class MemberDaoTest extends ModelTestConfig{

	
	@Resource(name="memberRepository")
	private MemberDaoI memDao;
	
	
	@Test
	public void selectAllMemberTest() {
		/***Given***/
		

		/***When***/
		List<MemberVO> memList = memDao.selectAllMember();
		
		/***Then***/
		assertTrue(memList.size() > 13);
		
	}

}
