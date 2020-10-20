package kr.or.ddit.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.model.MemberVO;

public class SessionAttributeListener implements HttpSessionAttributeListener{

	private static final Logger logger = LoggerFactory.getLogger(SessionAttributeListener.class);
	
	// key == userId, value == MemberVO
	private Map<String, MemberVO> userMap = new HashMap<String, MemberVO>();
	
	
	
	// session 추가 액션
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		
		logger.debug("attributeAdded");
		
		
		// 추가한 세션의 정보
		if("S_MEMBER".equals(event.getName())) {
//			HttpSession session = event.getSession();
//			MemberVO memVO = (MemberVO)session.getAttribute("S_MEMBER");
			
			MemberVO memVO = (MemberVO)event.getValue();
			logger.debug("사용자 로그인 : {}", memVO.getUserid());
			userMap.put(memVO.getUserid(), memVO); 
			ServletContext sc = event.getSession().getServletContext();
			sc.setAttribute("userMap", userMap);
		}
	}

	
	
	// session 삭제 액션
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		
		// 삭제한 세션의 정보를 임시로 저장한 세션
//		HttpSession session = event.getSession();
//		MemberVO memVO = (MemberVO)session.getAttribute("logoutMember");
//		userMap.remove(memVO.getUserid());
		
		
		// 삭제한 세션의 정보
		if("S_MEMBER".equals(event.getName())) {
			MemberVO memVO = (MemberVO) event.getValue();
			userMap.remove(memVO.getUserid());
			ServletContext sc = event.getSession().getServletContext();
			sc.setAttribute("userMap", userMap);
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		
	}

}
