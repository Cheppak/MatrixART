package ar.com.sac.matrix.result;

public class QueryResult extends Result {

	private int value;

	public QueryResult(String Status, int value) {
		super(Status);
		this.value = value;
	}

	public QueryResult(String status) {
		super(status);
		this.value = 0;;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
