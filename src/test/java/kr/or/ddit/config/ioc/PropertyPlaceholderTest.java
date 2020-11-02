package kr.or.ddit.config.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ioc.DBProperty;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/ioc/property-placeholder.xml"})
public class PropertyPlaceholderTest {

	
	@Resource(name="dbProperty")
	private DBProperty dbProperty;
	
	
	@Test
	public void propertyPlaceHolderTest() {
		
		/***Given***/
		

		/***When***/

		
		/***Then***/
		assertEquals("SHS", dbProperty.getUser());
		assertEquals("java", dbProperty.getPass());
	}

}
