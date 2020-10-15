package kr.or.ddit.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


	@Override
	public Map<String, Object> selectMemberPage(int pageNum) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		List<MemberVO> memListPage = memDao.selectMemberPage(pageNum);
		map.put("memListPage", memListPage);
		
		
		int totalCnt = memDao.selectMemberTotalCnt();
		int pageCnt = (int) Math.ceil(totalCnt / 7f);
		map.put("pageCnt", pageCnt);
		
		return map;
	}


}
