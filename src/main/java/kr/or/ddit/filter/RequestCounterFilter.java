package kr.or.ddit.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestCounterFilter implements Filter{

	private static final Logger logger = LoggerFactory.getLogger(RequestCounterFilter.class);
	Map<String, Integer> requestCounterMap;

	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.debug("RequestCounterFilter.init()");
		requestCounterMap = new HashMap<String, Integer>();
		// request, session, application
		
		ServletContext sc = filterConfig.getServletContext();
		sc.setAttribute("requestCounterMap", requestCounterMap);
	}

	
	
	// 실제 필터링 되는 메서드
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.debug("RequestCounterFilter.doFilter()");

		
		HttpServletRequest req = (HttpServletRequest)request;
		logger.debug("url : {}", req.getRequestURI());
		// url 별 요청 횟수
		// /memberList => 12
		// /jstl/jstl_fmt_date.jsp => 20
		// 어떤 자료구조를 쓰면 좋을까?
		// List, Set, Map
		
		
		// map 객체에서 uri에 해당하는 요청이 있었는지 확인
		// 없으면
		// 		값을 1로 해서 새로운 key로 추가
		// 있으면
		//		기존 값에서 1을 더해 값을 추가
		
		Integer testTemp = requestCounterMap.get(req.getRequestURI());
		if(testTemp == null) {
			requestCounterMap.put(req.getRequestURI(), 1);
		}else {
			int cnt = requestCounterMap.get(req.getRequestURI()) + 1;
			requestCounterMap.put(req.getRequestURI(), cnt);			
		}
		logger.debug("testTemp = {}", testTemp);
//		requestCounterMap.put(key, value)
		
		
		// 등록된 다른 필터로 요청을 위임
		// 만약 더이상 등록된 Filter가 없을경우 요청을 처리할 서블릿 / jsp로 요청을 위임
		
		
		
		// 전처리
		chain.doFilter(request, response); // servlet || filter 처리
		// 후처리
		
	}

	@Override
	public void destroy() {
		
	}

}
