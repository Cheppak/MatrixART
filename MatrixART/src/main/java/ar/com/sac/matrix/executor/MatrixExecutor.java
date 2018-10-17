package ar.com.sac.matrix.executor;

import org.apache.commons.lang3.StringUtils;

import ar.com.sac.matrix.result.QueryResult;

public abstract class MatrixExecutor  {

	abstract QueryResult doExecute(String script);
	abstract boolean doValidate(String[] split);

	public QueryResult execute(String script) {
		if(validStript(script))
			return doExecute(script);
		else
			return new QueryResult(QueryResult.ERROR); 
	}
	
	private boolean validStript(String script) {
		String[] split = StringUtils.split(script, " ");
		return doValidate(split);
	}
	
}
