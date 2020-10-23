package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

public class MemberDao implements MemberDaoI {

	// insert, delete, update는
	// sqlSession.commit()을 한뒤 ==> 변경내용 저장
	// sqlSession.close()를 해야 한다. ==> 자원 반환
	
	@Override
	public MemberVO getMember(String userId) {
		// 원래는 db에서 데이터를 조회하는 로직이 있어야 하나
		// 우리는 controller기능에 집중 => 하드코딩을 통해 dao, service는 간략하게 넘어간다.
		//	Mock(가짜)
		
		
//		MemberVO memberVO = new MemberVO();
//		memberVO.setUserId("brown");
//		memberVO.setPassword("passBrown");
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		// select
		// 한건 : selectOne
		// 여러건 : selectList
		MemberVO memberVO =  sqlSession.selectOne("member.getMember", userId);
		sqlSession.close();
		return memberVO;
	}

	
	
	@Override
	public List<MemberVO> selectAllMember() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<MemberVO> memList = sqlSession.selectList("member.selectAllMember");
		sqlSession.close();
		return memList;
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
	public int deleteMember(String userid) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int deleteCnt = sqlSession.insert("member.deleteMember", userid);
		
		if(deleteCnt == 1) {
			sqlSession.commit();			
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return deleteCnt;
	}



	@Override
	public int updateMember(MemberVO memVO) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int updateCnt = sqlSession.update("member.updateMember", memVO);
		
		if(updateCnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return updateCnt;
	}
	

}
