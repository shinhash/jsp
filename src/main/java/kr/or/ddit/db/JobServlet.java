package kr.or.ddit.db;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.model.JobVO;
import kr.or.ddit.member.service.JobService;
import kr.or.ddit.member.service.JobServiceI;


@WebServlet("/JobServlet")
public class JobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		JobServiceI jobService = new JobService();
		List<JobVO> jobList = jobService.getAllJobs();
		
		request.setAttribute("jobList", jobList);
		request.getRequestDispatcher("/jsp/getAllJobs.jsp").forward(request, response);
	}
}
