package ar.com.sac.matrix.manager;

import ar.com.sac.matrix.executor.MatrixExecutor;
import ar.com.sac.matrix.executor.QueryExecutor;
import ar.com.sac.matrix.executor.UpdateExecutor;
import ar.com.sac.matrix.result.QueryResult;

public class MatrixManager {

	int[][][] matrix;
	MatrixExecutor executor;
	
	public MatrixManager(int dimensions) {
		this.matrix = new int[dimensions][dimensions][dimensions];
	}
	
	public QueryResult execute(String query) {
		
		if(query.startsWith("QUERY"))
			executor = new QueryExecutor();
		else if(query.startsWith("UPDATE"))
			executor = new UpdateExecutor();
		//TODO seria mejor tal vez lanzar una exception. Ver.
		else return new QueryResult(QueryResult.ERROR); 		
		
		return executor.execute(query);
	}
}
