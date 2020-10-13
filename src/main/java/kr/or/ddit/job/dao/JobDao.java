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

}
