package kr.or.ddit.config.spring;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// 스프링 빈 중에 PlatformTransactionManager 타입의 빈이 있으면 해당 빈을
// 트랜잭션 메니저로 등록
//@Import({DataSourceContext.class})
@EnableTransactionManagement
@Configuration
public class TransactionContext {
	
	/*
	 <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource" />
	 </bean>
	*/
	
	// 외부 클래스의 객체가 필요시에는 주입을 하면 사용 가능하다.
	@Resource(name = "dataSource")
	private DataSource dataSource;
	
	
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		
		transactionManager.setDataSource(dataSource);
		
		return transactionManager;
	}
	
	
	
	
	/*
	 	<tx:advice id="txAdvisor">
	 	<aop:config>
	 	위 두부분에 해당하는 java설정은 없음
	 	@Transaction 어노테이션을 트랜색젼으로 삼을 메서드나, 클래스 단위로 붙여준다.
	 	스프링 빈을 <bean> 엘레멘트를 통해 일일이 등록 ==> @Controller, @Service
	*/
	
	
	
	
	
	
}
