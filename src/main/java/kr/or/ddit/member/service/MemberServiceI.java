package kr.or.ddit.member.service;

import java.util.Map;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;

public interface MemberServiceI {

	MemberVO getMember(String userid);

	Map<String, Object> selectMemberPage(PageVO pageVO);

	int insertMember(MemberVO memVO);

	int updateMember(MemberVO upMember);
	
}
