package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;

public class MemberService implements MemberServiceI {

	@Override
	public MemberVO getMember(String userId) {
		MemberDaoI memDao = new MemberDao();
		return memDao.getMember(userId);
	}

	
	@Override
	public List<MemberVO> selectAllMember() {
		MemberDaoI memDao = new MemberDao();
		return memDao.selectAllMember();
	}

}
