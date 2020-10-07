package kr.or.ddit.cookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieSplit {
	
	private static final Logger logger = LoggerFactory.getLogger(CookieSplit.class);

	
	// cookieString 문자열 변수에 담긴 값은
	// 쿠키이름1=쿠키값1; 쿠키이름2=쿠키값2;.......형태로 구성됨
	// 구성된 쿠키 이름과 값은 상황에 따라 변결될수 있음
	private String cookieString = "USERNM=brown; REMEMBERME=Y; TEST=T";
	
	public static void main(String[] args) {
		CookieSplit cookieSplit = new CookieSplit();
		
		logger.debug(cookieSplit.getCookieValue("USERNM")); // 기대되는 값 = brown
		logger.debug(cookieSplit.getCookieValue("TEST"));
		logger.debug(cookieSplit.getCookieValue("XXXX"));
		
	}
	
	
	
	public String getCookieValue(String cookieName) {
		
		String cookies[] = cookieString.split("; ");
		for(String cookie : cookies) {
			String coockieInfo[] = cookie.split("=");
			if(coockieInfo[0].equals(cookieName)) {
				return coockieInfo[1];
			}
		}
		return "";
	}
}
