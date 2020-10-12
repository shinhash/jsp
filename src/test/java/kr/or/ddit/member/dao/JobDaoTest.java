package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.member.model.JobVO;

public class JobDaoTest {

	@Test
	public void getAllJobs() {
		/***Given***/
		JobDaoI jobsDao = new JobDao();

		/***When***/
		List<JobVO> jobList = jobsDao.getAllJabs();

		/***Then***/
		assertEquals(19, jobList.size());
	}

}
