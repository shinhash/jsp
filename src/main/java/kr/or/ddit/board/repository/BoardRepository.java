package kr.or.ddit.board.repository;

import kr.or.ddit.board.model.BoardVO;

public class BoardRepository implements BoardRepositoryI {

	@Override
	public BoardVO getBoard(int boardNo) {
		
		
		// db에서 조회를 해야하나, 지금은 설정이 갖춰지지 않았으므로
		// 가짜 객체(MOCK)를 반환한다.
		
		if(boardNo == 1) {
			return new BoardVO(1, "첫번째 글", "내용");
		}else {
			return null;
		}
	}
}