package ar.com.sac.matrix.executor;

import org.apache.commons.lang3.StringUtils;

import ar.com.sac.matrix.result.Result;

public abstract class MatrixExecutor  {

	abstract Result doExecute(String[] script, int[][][] matrix);
	abstract boolean doValidate(String[] split, int n);

	public Result execute(String script, int matrix[][][]) {
		String[] split = getArguments(script);
		if(validScript(split,  matrix))
			return doExecute(split, matrix);
		else
			return new Result(Result.ERROR); 
	}
	private String[] getArguments(String script) {
		return StringUtils.split(script, " ");
	}
	
	private boolean validScript(String[] script, int[][][] matrix) {
		return doValidate(script, matrix.length);
	}
	
}
