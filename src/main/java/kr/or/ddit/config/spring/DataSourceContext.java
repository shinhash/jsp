package kr.or.ddit.config.spring;


import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

// <context:property-placeholder location="classpath:kr/or/ddit/config/db/DB.properties"/>
// xml : ${key} || java : key
@PropertySource("classpath:kr/or/ddit/config/db/DB.properties")
@Configuration
public class DataSourceContext {
	
	
	// 환경정보를 관리하는 객체
	@Autowired
	private Environment env;
	
	
	
	
	
	// property === setter
	// 환경정보를 setting하는 bean
	/*
	 <!-- 1. datasource : connection pool 
		 2. SqlSessionFactoryBean : datasource를 이용하여 mybatis 설정을 담당
		 3. SqlSessionTemplate : sqlSessionFactory객체로 부터 생성하며 mybatis를 통해 sql을 실행할 수 있는 객체(sqlSession) -->
		 
	 <bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource">
		<property name="url" value="${jdbc.url}"/>
		<property name="driverClassName" value="${jdbc.driver}"/>
		<property name="username" value="${jdbc.username}"/>
		<property name="password" value="${jdbc.password}"/>
	</bean>
	*/
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
		dataSource.setUsername(env.getProperty("jdbc.username"));;
		dataSource.setPassword(env.getProperty("jdbc.password"));
		return dataSource;
	}
	
	
	
	
	
	/*
	 <!-- mybatis util 역할을 수행하는 기능 bean -->
	 <!-- SqlSessionFactoryBean객체는 객체를 생성하는 역할을 담당하는 객체
		 스프링 프레임워크는 스프링 빈을 생성시 객체가 FactoryBean 인터페이스를 구현한 경우
		 인터페이스에 정의되어 있는 getObject() 메서드가 리턴하는 객체를 스프링 빈으로 등록한다. -->
	<bean id="sqlSessionFactoryBean" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="configLocation" value="classpath:kr/or/ddit/config/db/mybatis-config.xml" />
		<property name="dataSource" ref="dataSource" />
	</bean>
	*/
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("kr/or/ddit/config/db/mybatis-config.xml"));
		sqlSessionFactoryBean.setDataSource(dataSource());
		
		// 위와 같이 직접 new 연산자를 통해 생성한 객체는 스프링 빈이 아니다
		// @Bean 어노테이션이 붙은 메서드를 호출해야 스프링 컨테이너에서 관리되는 스프링 빈을 얻을 수 있다.
		// sqlSessionFactoryBean.setDataSource(dataSource());
		return sqlSessionFactoryBean.getObject();
	}
	
	
	
	
	/*
	<!-- sqlSession 역할을 수행하는 bean -->
	<bean id="sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate">
		<constructor-arg ref="sqlSessionFactoryBean"/>
	</bean>
	*/
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactoryBean());
		
		return sqlSessionTemplate;
	}
	
	
}
