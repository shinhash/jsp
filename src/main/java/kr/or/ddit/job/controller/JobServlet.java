package kr.or.ddit.job.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.job.model.JobVO;
import kr.or.ddit.job.service.JobService;
import kr.or.ddit.job.service.JobServiceI;



@WebServlet("/JobServlet")
public class JobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(JobServlet.class);


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pageNum = 1;
		try {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}catch(NumberFormatException e) {}
		
		
		
		request.setCharacterEncoding("UTF-8");
		JobServiceI jobService = new JobService();
		
		
		logger.debug("page number = {}", pageNum);
		
		
//		List<JobVO> jobList = jobService.getAllJobs();
		
		Map<String, Object> jobMap = (Map<String, Object>) jobService.getJobsPage(pageNum);
		List<JobVO> jobListPage = (List<JobVO>) jobMap.get("jobListPage");
		int pageCnt = (int) jobMap.get("pageCnt");
		
		logger.debug("pageCnt = {}", pageCnt);

		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("jobList", jobListPage);
		request.getRequestDispatcher("/jsp/getAllJobs.jsp").forward(request, response);
	}
}
