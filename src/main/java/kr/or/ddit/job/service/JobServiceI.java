package kr.or.ddit.job.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.job.model.JobVO;


public interface JobServiceI {

	
	List<JobVO> getAllJobs();
	
	
	Map<String, Object> getJobsPage(int pageNum);
}
