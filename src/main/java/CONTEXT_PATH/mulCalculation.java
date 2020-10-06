package CONTEXT_PATH;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet("/mulCalculation")
public class mulCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LoggerFactory.getLogger(mulCalculation.class);

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/mulCalculationTest.jsp").forward(request, response);
	}


	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int firstNum = 0;
		int secondNum = 0;
		
		try {
			firstNum = Integer.parseInt(request.getParameter("firstNum"));
			secondNum = Integer.parseInt(request.getParameter("secondNum"));
		}catch(NumberFormatException e) {
			// 문자입력 처리
			
			request.getSession().setAttribute("mulResult", "문자를 입력하셨습니다.");
			request.getRequestDispatcher("/jsp/mulResult.jsp").forward(request, response);
			return;
		}
		
		
		long mulResult = firstNum * secondNum;
		logger.debug("mulResult = {}", mulResult);
		
		request.getSession().setAttribute("mulResult", mulResult);
		request.getRequestDispatcher("/jsp/mulResult.jsp").forward(request, response);
	}

}
