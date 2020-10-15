package kr.or.ddit.job.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.job.dao.JobDao;
import kr.or.ddit.job.dao.JobDaoI;
import kr.or.ddit.job.model.JobVO;


public class JobService implements JobServiceI {
	
	private JobDaoI jobDao;
	
	public JobService() {
		jobDao = new JobDao();
	}

	@Override
	public List<JobVO> getAllJobs() {
		List<JobVO> jobList = jobDao.getAllJabs();
		return jobList;
	}

	
	
	@Override
	public Map<String, Object> getJobsPage(int pageNum) {
		
		
		Map<String, Object> jobMap = new HashMap<String, Object>();
		List<JobVO> jobListPage = jobDao.getJobsPage(pageNum);
		int totalCnt = jobDao.selectJobsTotalCnt();
		
		int pageCnt = (int) Math.ceil(totalCnt / 7f);
		
		jobMap.put("jobListPage", jobListPage);
		jobMap.put("pageCnt", pageCnt);
		
		
		return jobMap;
	}

}







