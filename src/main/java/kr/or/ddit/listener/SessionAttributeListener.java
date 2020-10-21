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
			
			// map이 아닌 map의 주소를 참조하여 해당 map을 setAttribute한 것
			// 값이 아니라 주소를 갖는 attribute
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
			
			// userMap의 주소에 있는 memVO.getUserid() 와 일치하는 key값의 정보를 삭제하기 때문에
			// userMap 주소의 데이터를 참조하는 application단의 데이터가 수정된다.
			// map 주소에 있는 데이터를 삭제했기 때문에 해당 map을 참조하는 곳에까지 영향이 미침
			
			
//			ServletContext sc = event.getSession().getServletContext();
//			sc.setAttribute("userMap", userMap);
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		
	}

}
