package kr.or.ddit.job.dao;

import java.util.List;

import kr.or.ddit.job.model.JobVO;


public interface JobDaoI {
	
	
	List<JobVO> getAllJabs();
	
	List<JobVO> getJobsPage(int pageNum);
	
	int selectJobsTotalCnt();
	
}
