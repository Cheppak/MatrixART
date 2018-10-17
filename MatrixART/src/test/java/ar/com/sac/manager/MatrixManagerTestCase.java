package ar.com.sac.manager;

import ar.com.sac.matrix.manager.MatrixManager;
import ar.com.sac.matrix.result.QueryResult;
import junit.framework.TestCase;

public class MatrixManagerTestCase extends TestCase {

	
	/**
	 * UPDATE 2 2 2 4     -> SUCCESS<br>
	 * QUERY 1 1 1 3 3 3  -> SUCCESS / 4<br>
	 * UPDATE 1 1 1 23    -> SUCCESS<br> 
	 * QUERY 2 2 2 4 4 4  -> SUCCESS / 4<br>
	 * QUERY 1 1 1 3 3 3  -> SUCCESS / 4<br>
	 * UPDATE 2 2 2 1     -> SUCCESS<br>
	 * QUERY 1 1 1 1 1 1  -> SUCCESS / 23<br>
	 * QUERY 1 1 1 2 2 2  -> SUCCESS / 24<br>
	 * QUERY 2 2 2 2 2 2  -> SUCCESS / 1<br>
	 */
	public void testExamplesArt() {
		MatrixManager manager = new MatrixManager(10);
		QueryResult execute = manager.execute("UPDATE 2 2 2 4");
		assertEquals(QueryResult.SUCCESS, execute.getStatus());
	}
	
}
