package ar.com.sac.matrix.executor;

import org.apache.commons.lang3.StringUtils;

import ar.com.sac.matrix.result.Result;
import ar.com.sac.matrix.result.QueryResult;

public class QueryExecutor extends MatrixExecutor{

	public Result doExecute(String[] script, int[][][] matrix) {
		
		int result = 0;
		int x1 = Integer.parseInt(script[1]);
		int y1 = Integer.parseInt(script[2]);
		int z1 = Integer.parseInt(script[3]);
		int x2 = Integer.parseInt(script[4]);
		int y2 = Integer.parseInt(script[5]);
		int z2 = Integer.parseInt(script[6]);

		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				for (int k = z1; k <= z2; k++) {
					result = result + matrix[i][j][k];
				}
			}
		}

		return new QueryResult(Result.SUCCESS,result);
	}

	//	 ● 1 <= N <= 100 <br>
	//	 ● 1 <= x1 <= x2 <= N <br>
	//	 ● 1 <= y1 <= y2 <= N <br>
	//	 ● 1 <= z1 <= z2 <= N <br>
	@Override
	boolean doValidate(String[] script, int n) {
		if(script.length != 7)
			return false;
		
		String x1 = script[1];
		String y1 = script[2];
		String z1 = script[3];
		String x2 = script[4];
		String y2 = script[5];
		String z2 = script[6];

		if(!StringUtils.isNumeric(x1) || !StringUtils.isNumeric(y1) || !StringUtils.isNumeric(z1) || !StringUtils.isNumeric(x2) || 
				!StringUtils.isNumeric(y2)||!StringUtils.isNumeric(z2)) 
			return false;
		
		int x1Value = Integer.parseInt(x1);
		int y1Value = Integer.parseInt(y1);
		int z1Value = Integer.parseInt(z1);
		int x2Value = Integer.parseInt(x2);
		int y2Value = Integer.parseInt(y2);
		int z2Value = Integer.parseInt(z2);
		
		if( x1Value > n || y1Value > n || z1Value > n || x2Value > n || y2Value > n || z2Value > n)
			return false;
		
		if(x1Value > x2Value || y1Value > y2Value || z1Value > z2Value)
			return false;
		
		return true;
	}

}
