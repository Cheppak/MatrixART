package ar.com.sac.matrix.executor;

import org.apache.commons.lang3.StringUtils;

import ar.com.sac.matrix.result.Result;

public class UpdateExecutor extends MatrixExecutor{

	public Result doExecute(String[] script, int [][][] matrix) {
		int x = Integer.parseInt(script[1]);
		int y = Integer.parseInt(script[2]);
		int z = Integer.parseInt(script[3]);
		int value = Integer.parseInt(script[4]);
		matrix[x][y][z] = value;
		return new Result(Result.SUCCESS);
	}

	//  1 <= N <= 100 <br>
	//	1 <= x,y,z <= N <br>
	//	-126 <= W <= 126 
	@Override
	boolean doValidate(String[] script, int n) {

		if(script.length != 5)
			return false;
		
		String x = script[1];
		String y = script[2];
		String z = script[3];
		String w = script[4];

		if(!StringUtils.isNumeric(x) || !StringUtils.isNumeric(y) || !StringUtils.isNumeric(z) || !StringUtils.isNumeric(w)) 
			return false;
		
		int xValue = Integer.parseInt(x);
		int yValue = Integer.parseInt(y);
		int zValue = Integer.parseInt(z);
		int updateValue = Integer.parseInt(w);
		
		if( xValue > n || yValue > n || zValue > n)
			return false;
		
		if(updateValue > 127 || updateValue < -127)
			return false;
		
		return true;
	}
	
}
