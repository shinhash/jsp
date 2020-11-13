package kr.or.ddit.config.spring;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//<context:component-scan base-package="kr.or.ddit" use-default-filters="false">
//	<context:include-filter type="annotation" expression="org.springframework.stereotype.Service"/>
//	<context:include-filter type="annotation" expression="org.springframework.stereotype.Repository"/>		
//</context:component-scan>

// xml to java 
// 장점 : xml은 expression에 문자열을 작성할때 오타를 작성시 컴파일 전까지는 오류원인을 알 수 없지만
// 		 java에서 설정하면 문자열이 아닌 클래스정보를 작성하기 때문에 즉각적으로 오류원인을 파악할 수 있다.

//@ImportResource({"classpath:classpath:kr/or/ddit/config/spring/aop-context.xml", "classpath:classpath:kr/or/ddit/config/spring/datasource-context.xml"})
@Configuration
@ComponentScan(basePackages = {"kr.or.ddit"}, useDefaultFilters = false, 
			   includeFilters = {@Filter(type = FilterType.ANNOTATION, 
			   							 classes = {Service.class, Repository.class})})
public class RootContext {

	
	
//	<bean id="messageSource" class="org.springframework.context.support.ReloadableResourceBundleMessageSource">
//		<property name="basenames">
//			<list>
//				<value>classpath:kr/or/ddit/message/error</value>
//				<value>classpath:kr/or/ddit/message/msg</value>
//			</list>
//		</property>
//	</bean>	
	
	
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		
		messageSource.setBasenames("classpath:kr/or/ddit/message/msg", 
								   "classpath:kr/or/ddit/message/error");
		
		
		return messageSource;
	}
	
}
