package kr.or.ddit.member.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

@Repository("memberRepository")
public class MemberDao implements MemberDaoI{

	
	private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);

	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	
	
	@Override
	public List<MemberVO> selectAllMember() {
		return sqlSession.selectList("member.selectAllMember");
	}
	
	
	@Override
	public MemberVO getMember(String userid) {
		return sqlSession.selectOne("member.getMember", userid);
	}

	@Override
	public List<MemberVO> selectMemberPage(PageVO pageVO) {
		return sqlSession.selectList("member.selectMemberPage", pageVO);
	}

	@Override
	public int selectMemberTotalCnt() {
		return sqlSession.selectOne("member.selectMemberTotalCnt");
	}

	@Override
	public int insertMember(MemberVO memVO) {
		
		
//		logger.debug("first insert 시작전");
//		sqlSession.insert("member.insertMember", memVO);
//		logger.debug("first insert 종료후");
//
//		logger.debug("seconde insert 시작전");
//		sqlSession.insert("member.insertMember", memVO);
//		logger.debug("seconde insert 종료후");
		
		// 첫번째 쿼리는 정상적으로 실행되지만
		// 두번째 쿼리에서 동일한 데이터를 입력하여 primary key 제약조건에 의해 
		// SQL 실행 실패
		// 첫번쨰 쿼리는 성공했지만 트랜잭션 설정을 service레벨에 설정을 하였기 때문에
		// 서비스 메서드에서 실행된 모든 쿼리를 rollback 처리한다.
		
		
		
		return sqlSession.insert("member.insertMember", memVO);
	}

	@Override
	public int updateMember(MemberVO upMember) {
		return sqlSession.update("member.updateMember", upMember);
	}



}
