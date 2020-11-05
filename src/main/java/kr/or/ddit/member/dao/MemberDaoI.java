package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;

public interface MemberDaoI {

	MemberVO getMember(String userid);
	
	List<MemberVO> selectMemberPage(PageVO pageVO, SqlSession sqlSession);

	int selectMemberTotalCnt(SqlSession sqlSession);

	int insertMember(MemberVO memVO);
	
	int updateMember(MemberVO upMember);
	
}
