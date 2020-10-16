package kr.or.ddit.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
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
	public Map<String, Object> selectMemberPage(PageVO pageVO) {
		
		
		// 동일한 SqlSession 정보를 인자로 전달하여 같은 트렌젝션안에서 처리하도록 한다.
		// 같은 공간에서 작업
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<MemberVO> memListPage = memDao.selectMemberPage(pageVO, sqlSession);
		int totalCnt = memDao.selectMemberTotalCnt(sqlSession);
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memListPage", memListPage);
		int pageCnt = (int) Math.ceil(totalCnt / ((float)pageVO.getPageSize()));
		map.put("pageCnt", pageCnt);
		
		sqlSession.close();
		
		return map;
	}


}
