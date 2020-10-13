package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;

public class MemberService implements MemberServiceI {
	
	private MemberDaoI memDao;
	
	public MemberService() {
		memDao = new MemberDao();
	}
	

	@Override
	public MemberVO getMember(String userId) {
		return memDao.getMember(userId);
	}

	
	@Override
	public List<MemberVO> selectAllMember() {
		return memDao.selectAllMember();
	}

}
