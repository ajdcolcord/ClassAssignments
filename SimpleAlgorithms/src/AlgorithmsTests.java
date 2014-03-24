import junit.framework.TestCase;

/** represents the tests for the simple algorithms
 * 
 * @author Austin Colcord - ajdcolcord
 *
 */
public class AlgorithmsTests extends TestCase {

	/** test the carMove function in Algorithms */
	public void testCarMove() {
		assertEquals(Algorithms.carMove(20, 5, 50), 270); 
		assertEquals(Algorithms.carMove(10, 3, 60), 190);
	}

	/** test the method nextRocket in Algorithms */
	public void testNextRocket() {
		assertEquals(Algorithms.nextRocket(100, 5), 95); 
		assertEquals(Algorithms.nextRocket(0, 5), 0); 
		assertEquals(Algorithms.nextRocket(20, 20), 0); 
		assertEquals(Algorithms.nextRocket(15, 20), 0); 
	}
	
	/** test the method circleArea in Algorithms */
    public void testCircleArea() {
    	assertEquals(Algorithms.circleArea(0), 0.0);
    	assertEquals(Algorithms.circleArea(1), 3.141592653589793);
    	assertEquals(Algorithms.circleArea(10), 314.1592653589793);
    }
    
    /** test the method circlePerimeter in Algorithms */
    public void testCirclePerimeter() {
    	assertEquals(Algorithms.circlePerimeter(0), 0.0);
    	assertEquals(Algorithms.circlePerimeter(1), 6.283185307179586);
    	assertEquals(Algorithms.circlePerimeter(10), 62.83185307179586);
    }
}
