package CONTEXT_PATH;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LoggerFactory.getLogger(sumCalculation.class);


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/calculationTest.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int start = 0;
		int end = 0;
		
		try {
			start = Integer.parseInt(request.getParameter("start"));
			end = Integer.parseInt(request.getParameter("end"));
			
		}catch(NumberFormatException e) {
			request.getSession().setAttribute("sumResult", "문자를 입력하셨습니다.");
			request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);
			return;
		}
		
		int resultNum = 0;
		if(start < end) {
			for(int i=start+1; i<end; i++) {
				resultNum += i;
			}
		}
		
		logger.debug("sumResult : {}",resultNum);

		request.getSession().setAttribute("sumResult", resultNum);
		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);
//		response.sendRedirect("/jsp/sumResult.jsp");
	}

}
