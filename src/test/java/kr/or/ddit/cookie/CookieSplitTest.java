package kr.or.ddit.cookie;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CookieSplitTest {

	@Test
	public void getCookieValueTest() {
		
		/***Given***/
		CookieSplit cookieSplit = new CookieSplit();

		/***When***/
		String cookievalue = cookieSplit.getCookieValue("USERNM");
		
		/***Then***/
		assertEquals("brown", cookievalue);
	}
	
	
   @Test
   public void getCookieValuesFailTest() {
      
	   /***Given***/
      CookieSplit cookieSplit = new CookieSplit();

      /***When***/
      String cookieValue =  cookieSplit.getCookieValue("");
      
      /***Then***/
      assertEquals("", cookieValue);
   }

}
