package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.JobDao;
import kr.or.ddit.member.dao.JobDaoI;
import kr.or.ddit.member.model.JobVO;

public class JobService implements JobServiceI {

	@Override
	public List<JobVO> getAllJobs() {
		JobDaoI jobDao = new JobDao();
		List<JobVO> jobList = jobDao.getAllJabs();
		return jobList;
	}

}
