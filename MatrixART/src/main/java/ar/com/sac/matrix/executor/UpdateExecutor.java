package ar.com.sac.matrix.executor;

import ar.com.sac.matrix.result.QueryResult;

public class UpdateExecutor extends MatrixExecutor{

	public QueryResult doExecute(String script) {
		return new QueryResult(QueryResult.SUCCESS);
	}

	//  1 <= N <= 100 <br>
	//	1 <= x,y,z <= N <br>
	//	-126 <= W <= 126 
	@Override
	boolean doValidate(String[] Script) {
		// TODO Auto-generated method stub
		return true;
	}

	
	
}
