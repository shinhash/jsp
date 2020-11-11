package kr.or.ddit.config.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.repository.BoardRepositoryI;
import kr.or.ddit.board.service.BoardServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/root-context.xml",
//								   "classpath:kr/or/ddit/config/spring/datasource-context_dev.xml",
//								   "classpath:kr/or/ddit/config/spring/transaction-context.xml"})
@ContextConfiguration(classes = {JavaSpringScanConfig.class})
public class JavaSpringConfigTest {

	
	
	@Resource(name="boardRepository")
	private BoardRepositoryI boardRepository;
	
	
	@Resource(name="boardService")
	private BoardServiceI boardService;
	
	
	
	// boardRepository, boardService 스프링 빈이 정상적으로 등록 되었는지 확인
	@Test
	public void JavaBeanTest() {
		/***Given***/
		

		/***When***/
		BoardVO boardVO = boardService.getBoard(1);
		
		/***Then***/
		assertNotNull(boardRepository);
		assertNotNull(boardService);
		assertEquals("내용", boardVO.getContent());
	}

}
