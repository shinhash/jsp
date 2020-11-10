package kr.or.ddit.board.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.repository.BoardRepositoryI;

// <bean id="" />
@Service("boardService")
public class BoardService implements BoardServiceI{

	
	@Resource(name="boardRepository")
	private BoardRepositoryI boardRepository;
	
	
	// 생성자
	public BoardService() {
	}
	public BoardService(BoardRepositoryI boardRepository) {
		this.boardRepository = boardRepository;
	}
	
	

	
	// getter, setter
	public BoardRepositoryI getBoardRepository() {
		return boardRepository;
	}
	public void setBoardRepository(BoardRepositoryI boardRepository) {
		this.boardRepository = boardRepository;
	}

	
	

	@Override
	public BoardVO getBoard(int boardNo) {
		return boardRepository.getBoard(boardNo);
	}
}