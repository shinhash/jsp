package kr.or.ddit.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class PerformanceCheckInterceptor extends HandlerInterceptorAdapter{

	private static final Logger logger = LoggerFactory.getLogger(PerformanceCheckInterceptor.class);

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		
		// 1ms = 1/1000 초
		// 1ns = 1/1000000000 초
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		
		// true : 다음 interceptor 호출, 다음interceptor가 없을 경우 handler(controller)
		// false : 요청 처리를 멈춘다.
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		long endTime = System.currentTimeMillis();
		logger.debug("endTime : {}", endTime);
		logger.debug("startTime : {}", (long)request.getAttribute("startTime"));
		logger.debug("메서드 : {} || 걸린 시간 time : {}", handler, (endTime - (long)request.getAttribute("startTime")));
	}
	 
}












