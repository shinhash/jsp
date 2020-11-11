package kr.or.ddit.member;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// repository + service ==> scan : root-context.xml
// sqlSessionTemplate : datasource-context.xml
// transaction : transaction-context.xml
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/root-context.xml",
								   "classpath:kr/or/ddit/config/spring/datasource-context_dev.xml",
								   "classpath:kr/or/ddit/config/spring/transaction-context.xml"})
public class ModelTestConfig {

	
	@Resource(name = "dataSource")
	private DataSource dataSource;
	
	
	
	@Ignore
	@Test
	public void dummy() {
		
	}
	
	
	@Before
	public void setup() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		
//		new ClassPathResource("/kr/or/ddit/config/db/initData.sql"); // 리소스에 대한 경로를 가져오는 클래스
		// 해당 리소스 경로에 있는 스크립트를 가져오는 메서드 ==> addScript()
		// 가져오는 리소스가 복수개일 경우도 있다.
		populator.addScripts(new ClassPathResource("/kr/or/ddit/config/db/initData.sql"));
		
		// 에러발생시 멈출것인지 계속진행할 것인지에 대한 옵션
		populator.setContinueOnError(false);
		
		// 쿼리를 실행하는 메서드 execute()
		DatabasePopulatorUtils.execute(populator, dataSource);
	}
	
	
	
	
	
	
}
















