package kr.or.ddit.batch.yogurt.model;

public class CycleVO {

	private int cid;	// 고객번호
	private int pid;	// 제품번호
	private int day;	// 요일(1-일요일, 2-월요일, 3-화요일....., 7-토요일)
	private int cnt;	// 애음수량
	
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
	@Override
	public String toString() {
		return "CycleVO [cid=" + cid + ", pid=" + pid + ", day=" + day + ", cnt=" + cnt + "]";
	}
	
}
