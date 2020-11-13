package kr.or.ddit.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;

@Transactional
@Service("memberService")
public class MemberService implements MemberServiceI{
	
	@Resource(name = "memberRepository")
	private MemberDaoI memDao;

	@Override
	public MemberVO getMember(String userid) {
		return memDao.getMember(userid);
	}
	
	@Override
	public Map<String, Object> selectMemberPage(PageVO pageVO) {
		
		// 동일한 SqlSession 정보를 인자로 전달하여 같은 트렌젝션안에서 처리하도록 한다.
		// 같은 공간에서 작업
//		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<MemberVO> memListPage = memDao.selectMemberPage(pageVO);
		int totalCnt = memDao.selectMemberTotalCnt();
		
		Map<String, Object> map = new HashMap<String, Object>();
		int pageCnt = (int) Math.ceil(totalCnt / ((float)pageVO.getPageSize()));
		
		map.put("memListPage", memListPage);
		map.put("pageCnt", pageCnt);
		
//		sqlSession.close();
		
		return map;
	}

	@Override
	public int insertMember(MemberVO memVO) {
		return memDao.insertMember(memVO);
	}

	@Override
	public int updateMember(MemberVO upMember) {
		return memDao.updateMember(upMember);
	}

}
