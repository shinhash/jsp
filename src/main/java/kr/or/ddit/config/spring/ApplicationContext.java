package kr.or.ddit.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import kr.or.ddit.mvc.download.ProfileImgDownload;
import kr.or.ddit.mvc.view.ExcelDownloadView;
import kr.or.ddit.mvc.view.ProfileImgView;


/*
 	<!-- kr.or.ddit 패키지 하위의 클래스중 @Controller 어노테이션이 붙은
		 클래스를 스캔하여 스프링 빈으로 생성 -->
	<context:component-scan base-package="kr.or.ddit" use-default-filters="false">
		<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
		<context:include-filter type="annotation" expression="org.springframework.web.bind.annotation.ControllerAdvice"/>
	</context:component-scan>
*/
@ComponentScan(basePackages = {"kr.or.ddit"}, useDefaultFilters = false, 
			   includeFilters = {@Filter(type = FilterType.ANNOTATION, 
			   							 classes = {Controller.class, ControllerAdvice.class})})
/*
<!-- @Contoller, @RequestMapping,
	 HandlerMapping, HandlerAdapter,
	 formatting conversion service등 
	 spring mvc 패턴에 필요한 어노테이션, 엘리먼트 치리 -->
<mvc:annotation-driven />
*/
@EnableWebMvc
@Configuration
public class ApplicationContext extends WebMvcConfigurerAdapter{


	/*
	 <!-- spring container가 처리하지 못하는 요청에 대해 
		 server에 등록된 default servlet에게 위임 -->
	<mvc:default-servlet-handler/> ==> extends 구현(WebMvcConfigurerAdapter)
	*/
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	
	
	
	
	
	/*
	 view
	 	<bean id="excelView" class="kr.or.ddit.mvc.view.ExcelDownloadView"></bean>
		<bean id="profileImgDownload" class="kr.or.ddit.mvc.download.ProfileImgDownload"></bean>
		<bean id="profileImgView" class="kr.or.ddit.mvc.view.ProfileImgView"></bean>
		<bean id="jsonView" class="org.springframework.web.servlet.view.json.MappingJackson2JsonView"></bean>
	*/
	@Bean
	public ExcelDownloadView excelView() {
		return new ExcelDownloadView();
	}
	@Bean
	public ProfileImgDownload profileImgDownload() {
		return new ProfileImgDownload();
	}
	@Bean
	public ProfileImgView profileImgView() {
		return new ProfileImgView();
	}
	@Bean
	public MappingJackson2JsonView jsonView() {
		return new MappingJackson2JsonView();
	}
	
	
	/*
	 <bean class="org.springframework.web.servlet.view.BeanNameViewResolver">
		<property name="order" value="1" />
	 </bean>
	*/
	@Bean
	public BeanNameViewResolver beanNameViewResolver() {
		BeanNameViewResolver beanNameViewResolver = new BeanNameViewResolver();
		beanNameViewResolver.setOrder(1);
		return beanNameViewResolver;
	}
	
	
	
	
	
	
	
	
	
	/*
	 	<!-- tiles view resolver 추가
			 1. tiles 설정 작업 ==> TilesConfigurer를 통해 설정
			 2. tils view resolver 등록 -->
		<bean id="tileConfigurer" class="org.springframework.web.servlet.view.tiles3.TilesConfigurer">
			<property name="definitions">
				<list>
					<value>classpath:kr/or/ddit/config/tiles/tiles-definition.xml</value>
				</list>
			</property>
		</bean>
	 */
	@Bean
	public TilesConfigurer tilesConfigurer() {
		
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("classpath:kr/or/ddit/config/tiles/tiles-definition.xml");
		
		return tilesConfigurer;
	}
	
	/*
	 	<bean class="org.springframework.web.servlet.view.tiles3.TilesViewResolver">
			<property name="order" value="0" />
			<property name="viewClass" value="org.springframework.web.servlet.view.tiles3.TilesView"></property>
		</bean>
	 */
	@Bean
	public TilesViewResolver tilesViewResolver() {
		TilesViewResolver tilesViewResolver = new TilesViewResolver();
		
		tilesViewResolver.setOrder(0);
		tilesViewResolver.setViewClass(TilesView.class);
		
		return tilesViewResolver;
	}
	
	
	
	
	
	
	
	
	
	
	/*
	 	<!-- ViewResolver역할을 수행하는 bean 객체 -->
		<!-- controller로 부터 return받은 String 문자열의 앞부분(prefix)과 뒷부분(suffix)에 
				 문자열을 추가하여 해당 경로의 파일(view ==> 여기서는 jsp)을 실행하는 bean 객체 -->
		<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
			<!-- prefix : 접두어, sufffix : 접미어
				 Controller가 리턴하는 문자열에 prefix, suffix를 적용하여 해당 경로의 파일로 응답을 생성
				 LoginController.getView() ==> "login/view"
				 
				 		prefix	   + 	viewName  + suffix
				 "/WEB-INF/views/" + "login/view" + ".jsp"
				  -->
				  
			<property name="order" value="2"></property>
			<property name="prefix" value="/WEB-INF/views/" />
			<property name="suffix" value=".jsp" />
		</bean>
	*/
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		
		internalResourceViewResolver.setOrder(2);
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		
		return internalResourceViewResolver;
	}
	
	
	
	
	
	
	/*
		 <!-- 파일 업로드 처리를 위한 multipartResolver 설정 -->
		 <!-- multipartResolver는 정해진 약속(이름)이다. 변경 불가능 -->
		 <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
		 </bean>
	*/
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();

		return multipartResolver;
	}
	
	
	
	
	
	
	
	
	
	/*
	 	<!-- localeResolver -->
		<bean id="localeResolver" class="org.springframework.web.servlet.i18n.SessionLocaleResolver" />
	*/
	@Bean
	public SessionLocaleResolver localeResolver() {
		return new SessionLocaleResolver();
	}
	
	
	/*
	    <!-- locale 변경 감지 interceptor -->
		<mvc:interceptors>
			<mvc:interceptor>
				<mvc:mapping path="/**"/>
				<bean class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor">
					<property name="paramName" value="lang" />
				</bean>
			</mvc:interceptor>
		</mvc:interceptors>
	*/
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		
		localeChangeInterceptor.setParamName("lang");
		
		
		registry.addInterceptor(localeChangeInterceptor).addPathPatterns("/**");
	}
	
	
	
	
	
	
	
	/*
	 	<!-- 정적자원 매핑 처리
		 1. url 단축을 목적
		 2. WEB-INF : 외부에서 접근불가능한 공간에 저장된 자원들 접근 매핑 -->
		<!-- mapping ==> localhost/resources/style.css -->
		<mvc:resources mapping="/resources/**" location="/WEB-INF/views/error/"></mvc:resources>
	*/
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/views/error");
	}
	
	
	
	
	
	
	
	
}
