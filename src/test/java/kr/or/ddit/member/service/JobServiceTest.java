package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.member.model.JobVO;

public class JobServiceTest {

	@Test
	public void getAllJobsTest() {
		
		/***Given***/
		JobServiceI jobService = new JobService();

		/***When***/
		List<JobVO> jobList = jobService.getAllJobs();

		/***Then***/
		assertEquals(19, jobList.size());
	}

}
