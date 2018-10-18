package ar.com.sac.manager;

import ar.com.sac.matrix.manager.MatrixManager;
import ar.com.sac.matrix.result.Result;
import ar.com.sac.matrix.result.QueryResult;
import junit.framework.TestCase;

public class MatrixManagerTestCase extends TestCase {

	/**
	 * 1) UPDATE 2 2 2 4     -> SUCCESS<br>
	 * 2) QUERY 1 1 1 3 3 3  -> SUCCESS / 4<br>
	 * 3) UPDATE 1 1 1 23    -> SUCCESS<br> 
	 * 4) QUERY 2 2 2 4 4 4  -> SUCCESS / 4<br>
	 * 5) QUERY 1 1 1 3 3 3  -> SUCCESS / 4<br>
	 * 6) UPDATE 2 2 2 1     -> SUCCESS<br>
	 * 7) QUERY 1 1 1 1 1 1  -> SUCCESS / 23<br>
	 * 8) QUERY 1 1 1 2 2 2  -> SUCCESS / 24<br>
	 * 9) QUERY 2 2 2 2 2 2  -> SUCCESS / 1<br>
	 */
	public void testExamplesArt() {
		
		MatrixManager manager = new MatrixManager(10);
		Result updateResult = manager.execute("UPDATE 2 2 2 4");
		assertEquals(Result.SUCCESS, updateResult.getStatus());
		
		// TODO seria muy feliz si elimino este cast. Prox iteracion!
		QueryResult queryResult = (QueryResult) manager.execute("QUERY 1 1 1 3 3 3");
		assertEquals(Result.SUCCESS, queryResult.getStatus());
		assertEquals(4, queryResult.getValue());
		
		updateResult = manager.execute("UPDATE 1 1 1 23");
		assertEquals(Result.SUCCESS, updateResult.getStatus());

		queryResult = (QueryResult) manager.execute("QUERY 2 2 2 4 4 4");
		assertEquals(Result.SUCCESS, queryResult.getStatus());
		assertEquals(4, queryResult.getValue());

		queryResult = (QueryResult) manager.execute("QUERY 1 1 1 3 3 3");
		assertEquals(Result.SUCCESS, queryResult.getStatus());
		assertEquals(27, queryResult.getValue());
		
		updateResult = manager.execute("UPDATE 2 2 2 1");
		assertEquals(Result.SUCCESS, updateResult.getStatus());
		
		queryResult = (QueryResult) manager.execute("QUERY 1 1 1 1 1 1");
		assertEquals(Result.SUCCESS, queryResult.getStatus());
		assertEquals(23, queryResult.getValue());

		queryResult = (QueryResult) manager.execute("QUERY 1 1 1 2 2 2");
		assertEquals(Result.SUCCESS, queryResult.getStatus());
		assertEquals(24, queryResult.getValue());

		queryResult = (QueryResult) manager.execute("QUERY 2 2 2 2 2 2");
		assertEquals(Result.SUCCESS, queryResult.getStatus());
		assertEquals(1, queryResult.getValue());
	}
	
	/**
	 * Todas deben devolver ERROR status
	 * 
	 * 1) cantidad de argumentos invalidos 
	 * 2) argumento 2 > n 
	 * 3) argumento 3 > n
	 * 4) argumento 1 > n
	 * 5) argumento w > 128
	 * 6) argumaneto alfanumerico
	 */
	public void invalidUpdate() {
		MatrixManager manager = new MatrixManager(10);
		Result updateResult = manager.execute("UPDATE 2 2 2 2 4");
		assertEquals(Result.ERROR, updateResult.getStatus());
		
		manager = new MatrixManager(10);
		updateResult = manager.execute("UPDATE 2 70 2 4");
		assertEquals(Result.ERROR, updateResult.getStatus());

		manager = new MatrixManager(10);
		updateResult = manager.execute("UPDATE 2 2 70 4");
		assertEquals(Result.ERROR, updateResult.getStatus());

		manager = new MatrixManager(10);
		updateResult = manager.execute("UPDATE 70 2 2 4");
		assertEquals(Result.ERROR, updateResult.getStatus());

		manager = new MatrixManager(10);
		updateResult = manager.execute("UPDATE 2 2 2 200");
		assertEquals(Result.ERROR, updateResult.getStatus());

		manager = new MatrixManager(10);
		updateResult = manager.execute("UPDATE 2 2 A1 4");
		assertEquals(Result.ERROR, updateResult.getStatus());
		
	}
	
	/**
	 * Todas deben devolver ERROR status
	 * 
	 * 1) cantidad de argumentos invalidos 
	 * 2) argumento y1 > n 
	 * 3) argumento x1 > n
	 * 4) argumento z1 > n
	 * 4) argumento x2 > n
	 * 4) argumento y2 > n
	 * 4) argumento z2 > n
	 * 6) argumaneto alfanumerico
	 * 7) argumento x1 > x2
	 * 8) argumento y1 > y2
	 * 9) argumento z1 > z2
	 */
	public void invalidQuery() {
		MatrixManager manager = new MatrixManager(10);
		Result queryResult = manager.execute("QUERY 1 1 1 3 3 3 3");
		assertEquals(Result.ERROR, queryResult.getStatus());

		queryResult = manager.execute("QUERY 1 70 1 3 3 3");
		assertEquals(Result.ERROR, queryResult.getStatus());

		queryResult = manager.execute("QUERY 70 1 1 3 3 3");
		assertEquals(Result.ERROR, queryResult.getStatus());

		queryResult = manager.execute("QUERY 70 1 1 3 3 3");
		assertEquals(Result.ERROR, queryResult.getStatus());

		queryResult = manager.execute("QUERY 1 1 1 70 3 3");
		assertEquals(Result.ERROR, queryResult.getStatus());

		queryResult = manager.execute("QUERY 1 1 1 3 70 3");
		assertEquals(Result.ERROR, queryResult.getStatus());

		queryResult = manager.execute("QUERY 1 1 1 3 3 70");
		assertEquals(Result.ERROR, queryResult.getStatus());

		queryResult = manager.execute("QUERY 1 A 1 3 3 3");
		assertEquals(Result.ERROR, queryResult.getStatus());

		queryResult = manager.execute("QUERY 3 1 1 1 3 3");
		assertEquals(Result.ERROR, queryResult.getStatus());

		queryResult = manager.execute("QUERY 1 3 1 3 1 3");
		assertEquals(Result.ERROR, queryResult.getStatus());

		queryResult = manager.execute("QUERY 1 1 3 3 3 1");
		assertEquals(Result.ERROR, queryResult.getStatus());
	}
	

	public void invalidDimension() {
		try {
			new MatrixManager(1000);
			fail();
		}catch(RuntimeException e) {
			assertEquals(MatrixManager.DIMENSION_ERROR_MSJ, e.getMessage());
		}
	}

	public void invalidQueryType() {
		try {
			MatrixManager manager = new MatrixManager(10);
			manager.execute("PERRO 1 1 1 1 1 1");
			fail();
		}catch(RuntimeException e) {
			assertTrue(e.getMessage().contains(MatrixManager.INVALID_QUERY_ERROR_MSJ));
		}
	}
	
	
	
	
}
