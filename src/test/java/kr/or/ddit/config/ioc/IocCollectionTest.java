package kr.or.ddit.config.ioc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ioc.CollectionBean;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/ioc/collection.xml"})
public class IocCollectionTest {

	// spring collectionBean 주입
	@Resource(name="collectionBean")
	private CollectionBean collectionBean;
	
	
	
	@Test
	public void MapTest() {
	
		/***Given***/
		Map<String, String> map;

		/***When***/
		map = collectionBean.getMap();
		
		/***Then***/
		assertEquals("brown", map.get("name"));
	}
	
	
	
	@Test
	public void ListTest() {
		
		/***Given***/
		List<String> list;

		/***When***/
		list = collectionBean.getList();
		
		/***Then***/
		assertEquals("sally", list.get(1));
	}
	
	
	
	
	@Test
	public void SetTest() {
		
		/***Given***/
		Set<String> set;

		/***When***/
		set = collectionBean.getSet();

		/***Then***/
		assertEquals(3, set.size());
	}
	
	
	
	@Test
	public void propertiesTest() {
		
		/***Given***/
		Properties prop;

		/***When***/
		prop = collectionBean.getProperties();
		
		/***Then***/
		assertEquals("SHS", prop.get("jdbc.user"));
	}
	
	
	

}
