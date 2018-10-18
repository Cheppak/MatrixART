package ar.com.sac.matrix.manager;

import ar.com.sac.matrix.executor.MatrixExecutor;
import ar.com.sac.matrix.executor.QueryExecutor;
import ar.com.sac.matrix.executor.UpdateExecutor;
import ar.com.sac.matrix.result.Result;

public class MatrixManager {

	public static final String INVALID_QUERY_ERROR_MSJ = "No es una instruccion valida: ";
	public static final String DIMENSION_ERROR_MSJ = "la dimension no puede superar los 100 elementos";
	private int[][][] matrix;
	private MatrixExecutor executor;
	
	public MatrixManager(int dimensions) {
		if(dimensions > 100) {
			throw new RuntimeException(DIMENSION_ERROR_MSJ);
		}
		this.matrix = new int[dimensions][dimensions][dimensions];
	}
	
	public Result execute(String query) {
		
		if(query.startsWith("QUERY"))
			executor = new QueryExecutor();
		else if(query.startsWith("UPDATE"))
			executor = new UpdateExecutor();
		else throw new RuntimeException(INVALID_QUERY_ERROR_MSJ + query ); 		
		
		return executor.execute(query, this.matrix);
	}
}
