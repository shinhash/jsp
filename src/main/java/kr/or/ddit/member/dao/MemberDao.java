package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

@Repository("memberRepository")
public class MemberDao implements MemberDaoI{

	
	@Override
	public MemberVO getMember(String userid) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		MemberVO memVO = sqlSession.selectOne("member.getMember", userid);
		sqlSession.close();
		return memVO;
	}

	@Override
	public List<MemberVO> selectMemberPage(PageVO pageVO, SqlSession sqlSession) {
		return sqlSession.selectList("member.selectMemberPage", pageVO);
	}

	@Override
	public int selectMemberTotalCnt(SqlSession sqlSession) {
		return sqlSession.selectOne("member.selectMemberTotalCnt");
	}

	@Override
	public int insertMember(MemberVO memVO) {
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int insertCnt =  0;
		try {
			insertCnt = sqlSession.insert("member.insertMember", memVO);
		}catch(Exception e) { }
		
		if(insertCnt == 1) {
			sqlSession.commit();			
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return insertCnt;
	}

	@Override
	public int updateMember(MemberVO upMember) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int updateCnt = sqlSession.update("member.updateMember", upMember);
		
		if(updateCnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return updateCnt;
	}

}
