package kr.or.ddit.job.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.job.model.JobVO;

public class JobDao implements JobDaoI {
	

	@Override
	public List<JobVO> getAllJabs() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<JobVO> jobList = sqlSession.selectList("job.getAllJobs");
		sqlSession.close();
		return jobList;
	}

	@Override
	public List<JobVO> getJobsPage(int pageNum) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<JobVO> jobListPage = sqlSession.selectList("job.selectJobsPage", pageNum);
		sqlSession.close();
		return jobListPage;
	}

	@Override
	public int selectJobsTotalCnt() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int totalCnt = sqlSession.selectOne("job.selectJobsTotalCnt");
		sqlSession.close();
		return totalCnt;
	}

}
