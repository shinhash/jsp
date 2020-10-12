package kr.or.ddit.member.model;

public class JobVO {
	
	private String JOB_ID;
	private String JOB_TITLE;
	private int MIN_SALARY;
	private int MAX_SALARY;
	private String CREATE_DATE;
	private String UPDATE_DATE;
	
	
	
	
	
	public String getJOB_ID() {
		return JOB_ID;
	}
	public void setJOB_ID(String jOB_ID) {
		JOB_ID = jOB_ID;
	}
	public String getJOB_TITLE() {
		return JOB_TITLE;
	}
	public void setJOB_TITLE(String jOB_TITLE) {
		JOB_TITLE = jOB_TITLE;
	}
	public int getMIN_SALARY() {
		return MIN_SALARY;
	}
	public void setMIN_SALARY(int mIN_SALARY) {
		MIN_SALARY = mIN_SALARY;
	}
	public int getMAX_SALARY() {
		return MAX_SALARY;
	}
	public void setMAX_SALARY(int mAX_SALARY) {
		MAX_SALARY = mAX_SALARY;
	}
	public String getCREATE_DATE() {
		return CREATE_DATE;
	}
	public void setCREATE_DATE(String cREATE_DATE) {
		CREATE_DATE = cREATE_DATE;
	}
	public String getUPDATE_DATE() {
		return UPDATE_DATE;
	}
	public void setUPDATE_DATE(String uPDATE_DATE) {
		UPDATE_DATE = uPDATE_DATE;
	}
	
	
	
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CREATE_DATE == null) ? 0 : CREATE_DATE.hashCode());
		result = prime * result + ((JOB_ID == null) ? 0 : JOB_ID.hashCode());
		result = prime * result + ((JOB_TITLE == null) ? 0 : JOB_TITLE.hashCode());
		result = prime * result + MAX_SALARY;
		result = prime * result + MIN_SALARY;
		result = prime * result + ((UPDATE_DATE == null) ? 0 : UPDATE_DATE.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobVO other = (JobVO) obj;
		if (CREATE_DATE == null) {
			if (other.CREATE_DATE != null)
				return false;
		} else if (!CREATE_DATE.equals(other.CREATE_DATE))
			return false;
		if (JOB_ID == null) {
			if (other.JOB_ID != null)
				return false;
		} else if (!JOB_ID.equals(other.JOB_ID))
			return false;
		if (JOB_TITLE == null) {
			if (other.JOB_TITLE != null)
				return false;
		} else if (!JOB_TITLE.equals(other.JOB_TITLE))
			return false;
		if (MAX_SALARY != other.MAX_SALARY)
			return false;
		if (MIN_SALARY != other.MIN_SALARY)
			return false;
		if (UPDATE_DATE == null) {
			if (other.UPDATE_DATE != null)
				return false;
		} else if (!UPDATE_DATE.equals(other.UPDATE_DATE))
			return false;
		return true;
	}
	
	
	
	
	
}
