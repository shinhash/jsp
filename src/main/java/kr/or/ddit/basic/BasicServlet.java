package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ������ �����ϴ� ���
// 1. HttpServlet Ŭ������ ����Ѵ�.
// 2. doXXX �޼��带 �����Ѵ�.
// 3. servlet�� ���� �ڷ�� �ٸ��� �̸��� ����
// 		localhost/ServletTest/index.html -> �Ұ���
// 		url - ���� �����ϴ� �۾�
//		url�� ���� �̸��� ��������� �Ѵ�.(web.xml)


public class BasicServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		// writer ��ü�� ���� html ������ ����
		PrintWriter writer = resp.getWriter();
		
		writer.print("<html>");
		writer.print("	<head>");
		writer.print("	</head>");
		writer.print("	<body>");
		writer.print("		<p>");
		writer.print("			����ð� : " + new Date());
		writer.print("		</p>");
		writer.print("	</body>");
		writer.print("</html>");
		writer.flush();
		writer.close();
	}
	
	
}
