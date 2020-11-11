package kr.or.ddit.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Aspect
public class ProfilingAdvice {

	private static final Logger logger = LoggerFactory.getLogger(ProfilingAdvice.class);

	
	
	// pointCut 설정을 위한 의미 없는 메서드
	@Pointcut("execution(* kr.or.ddit..service.*.*(..))")
	public void dummy() {
		
	}
	
	
	
	@Before("dummy()")
	public void beforeMethod(JoinPoint joinPoint) {
		logger.debug("beforMethod : {}", joinPoint.getSignature().getName());
	}
	
	
	
	@Around("dummy()")
	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// 메서드 실행 전 공통 관심사항
		long start = System.currentTimeMillis();
		
		// 메서드 실행
		Object ret = joinPoint.proceed(joinPoint.getArgs());
		
		// 메서드 실행 후 공통 관심사항
		long end = System.currentTimeMillis();
		logger.debug("profiling : {} {} - {}", joinPoint.getSignature().getDeclaringTypeName(), // 패키지.클래스 이름
											   joinPoint.getSignature().getName(),				// 메서드 이름
											   (end - start) + " ms");							// 걸린 시간
		
		return ret;
	}
	
	
	
}
