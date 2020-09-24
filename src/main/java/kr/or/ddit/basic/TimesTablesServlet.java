package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimesTablesServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset=utf-8");
		
		
		PrintWriter out = resp.getWriter();
		
		out.print("<html>");
		out.print("	<head>");
		out.print("	<style>td{ text-align : center; width : 100px; }</style>");
		
		out.print("	</head>");
		out.print("	<body>");
		out.print("		<table border='1' align='center'>");
		for(int i=1; i<10; i++) {
			out.print("			<tr>");
			for(int j=2; j<10; j++) {
				out.print("				<td> " + " " + j + " * " + i + " = " + (j*i) + "</td>");
			}
			out.print("			</tr>");
		}
		out.print("		</table>");
		out.print("	</body>");
		out.print("</html>");
		out.flush();
		out.close();
		
		
		
		
	}
}
