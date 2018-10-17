package ar.com.sac.matrix.result;

public class UpdateQueryResult extends QueryResult {

	private int value;

	public UpdateQueryResult(String Status, int value) {
		super(Status);
		this.value = value;
	}
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
