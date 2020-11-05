package kr.or.ddit.common.model;

public class PageVO {

	private int pageNum;
	private int pageSize;
	
	
	// 인자있는 생성자를 선언하게 되면 default 생성자(인자가 없는 생성자)가 생성이 안됨
	// 대다수의 framework에서는 인자가 없는 생성자를 요구하는 경우가 있음
	// framework에서 해당 클래스의 인스턴스를 생성해야 하는데 인자가 있으면 어떻게 만들어야 하는지 알수가 없는 경우가 대부분
	// spring, mybatis를 사용할 경우, 기본 생성자가 생성되게끔 코드를 추가 작성
	// 인자가 있는 생성자를 만들경우, 기본 생성자를 개발자가 작성(생성)
	
	
	public PageVO() {}
	public PageVO(int pageNum, int pageSize) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}
	
	
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
	@Override
	public String toString() {
		return "PageVO [pageNum=" + pageNum + ", pageSize=" + pageSize + "]";
	}
}
