package kr.or.ddit.config.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.board.repository.BoardRepository;
import kr.or.ddit.board.repository.BoardRepositoryI;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@Configuration
//@ComponentScan("kr.or.ddit")
public class JavaSpringConfig {

	// boardRepository, boardService
	// 메서드 이름 ==> 스프링 이름
	// xml : <bean id="boardRepository(메서드이름)" class="BoardRepository" />
	@Bean
	public BoardRepositoryI boardRepository() {
		return new BoardRepository();
	}
	
	
	// xml : <bean id="boardService(메서드이름)" class="BoardService" >
	//			<constructor-arg ref="boardDao" />
	//		 </bean>
	@Bean
	public BoardService boardService() {
		BoardService boardService = new BoardService();
		boardService.setBoardRepository(boardRepository());
		
		// 아래와 같이 직접 new 연산자를 통해 생성한 객체는 스프링 빈이 아니다
		// @Bean 어노테이션이 붙은 메서드를 호출해야 스프링 컨테이너에서 관리되는 스프링 빈을 얻을 수 있다.
		//boardService.setBoardRepository(boardRepository());
		return boardService;
	}
	
	
	
}
