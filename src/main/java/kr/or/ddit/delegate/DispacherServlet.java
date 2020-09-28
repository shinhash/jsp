package kr.or.ddit.delegate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/dispacherServlet")
public class DispacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		// 응답을 다른 jsp(servlet)에게 위임하는 방법 두번째 : Dispacher
		// request객체의 getRequestDispacher 메서드를 호출하여 requestDispacher 객체를 확보
		//											(어떤 jsp, servlet 에게 위임할지 인자를 전달)
		// requestDispacher객체의 forward 메서드를 통해 다른 jsp(servlet)에게 응답 생성을 위임
		// 위임 받은 jsp, servlet에게 최종적으로 응답을 생성
		
		// 서블릿에서 요청을 받고 로직을 처리하여 화면에서 필요로 하는 데이터를 request 객체의 속성으로 저장
		// 위임받은 jsp는 같은 요청 scope에 존재하기 때문에 request 객체에서 저장된 속성을 꺼내 사용할수 있다.
		
		// 아래 데이터를 db에서 조회한 데이터라고 생각하자
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("sally");
		rangers.add("cony");
		
		request.setAttribute("rangers", rangers);
		
		
		
		// dispacher로 요청을 위임할시 ContextPath를 별도로 붙여주지 않는다.
		//** 서버 내에서 이루어지는 작업이기 때문이다. **
		RequestDispatcher rb = request.getRequestDispatcher("/delegate/dispacherView.jsp");
		rb.forward(request, response);
	}


}
