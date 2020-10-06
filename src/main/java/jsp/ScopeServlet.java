package jsp;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ScopeServlet")
public class ScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/ScopeView.jsp").forward(request, response);
	}

	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// reqeust, session, application 객체에 각각 속성을 저장
		
		String param = request.getParameter("param");
		
		
		
		request.setAttribute("requestAttr", param);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("sessionAttr", param);
		
		ServletContext sc = getServletContext();
		sc.setAttribute("applicationAttr", param);
		
		request.getRequestDispatcher("/jsp/ScopeView.jsp").forward(request, response);

	}


}
