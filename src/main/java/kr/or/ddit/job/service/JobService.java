package kr.or.ddit.job.service;

import java.util.List;

import kr.or.ddit.job.dao.JobDao;
import kr.or.ddit.job.dao.JobDaoI;
import kr.or.ddit.job.model.JobVO;


public class JobService implements JobServiceI {

	@Override
	public List<JobVO> getAllJobs() {
		JobDaoI jobDao = new JobDao();
		List<JobVO> jobList = jobDao.getAllJabs();
		return jobList;
	}

}
