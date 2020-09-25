package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿을 생성하는 방법
//1. HttpServlet 클래스를 상속한다.
//2. doXXX 메서드를 구현한다.
//3. servlet은 정적 자료와 다르게 이름이 없다
//		localhost/ServletTest/index.html -> 불가능
//		url - 서블릿 매핑하는 작업
//		url을 직접 이름을 생성해줘야 한다.(web.xml)


public class BasicServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		// writer 객체를 통해 html 문서를 생성
		PrintWriter writer = resp.getWriter();
		
		writer.print("<html>");
		writer.print("	<head>");
		writer.print("	</head>");
		writer.print("	<body>");
		writer.print("		<p>");
		writer.print("			현재시간 : " + new Date());
		writer.print("		</p>");
		writer.print("	</body>");
		writer.print("</html>");
		writer.flush();
		writer.close();
	}
	
	
}
