package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Gugudan extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setContentType("text/html; charset=utf-8");
		
		//test commit
		
		PrintWriter writer = resp.getWriter();
		

		writer.print("<html>");
		writer.print("	<head>");
		writer.print("	</head>");
		writer.print("	<body>");
		writer.print("		<table border='1' align='center'>");
		for(int i=1; i<10; i++) {
			writer.print("			<tr>");
			for(int j=2; j<10; j++) {
				writer.print("				<td> " + " " + j + " * " + i + " = " + (j*i) + "</td>");
			}
			writer.print("			</tr>");
		}
		writer.print("		</table>");
		writer.print("	</body>");
		writer.print("</html>");
		writer.flush();
		writer.close();
		
	}
}
