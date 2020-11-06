package kr.or.ddit.member.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MemberVOValidator implements Validator{

	
	
	
	// 검증하려고 하는 객체가 MemberVOValidator에서 검증이 가능한
	// 객체인지 boolean으로 리턴하는 메서드
	// vo객체.class.isAssignableFrom(clazz); ==> 해당 vo클래스와 관련이 있는지에 대한 여부
	@Override
	public boolean supports(Class<?> clazz) {
		return MemberVO.class.isAssignableFrom(clazz);
	}

	// 검증 로직을 작성하는 메서드
	// Object target : command 객체
	@Override
	public void validate(Object target, Errors errors) {
		MemberVO memVO = (MemberVO)target;
		
		
		// usernm 값이 null이거나 empty 문자열이면 안됨
		if(memVO.getUsernm() == null || memVO.getUsernm().equals("")) {
			errors.rejectValue("usernm", "required");
		}
	}
	

}
