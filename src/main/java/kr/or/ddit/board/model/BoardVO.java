package kr.or.ddit.board.model;

public class BoardVO {

	private int boardNo;
	private String boardTitle;
	private String content;
	
	
	
	public BoardVO() {

	}
	
	
	public BoardVO(int boardNo, String boardTitle, String content) {
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.content = content;
	}
	
	
	
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "BoardVO [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", content=" + content + "]";
	}
	
}
