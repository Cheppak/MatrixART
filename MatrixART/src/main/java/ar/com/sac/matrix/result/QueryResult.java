package ar.com.sac.matrix.result;

public class QueryResult {

	public static final String SUCCESS = "SUCCESS";
	public static final String ERROR = "ERROR";
	
	private String status;

	public QueryResult(String Status) {
		this.status = Status;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
