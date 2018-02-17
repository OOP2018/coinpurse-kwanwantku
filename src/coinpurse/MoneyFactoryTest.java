package coinpurse;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The testing Money Factory by using JUnitTest.
 * @author Kwanwan Tantichartkul
 * @version 1.0
 * @since 2018.02.17
 */

public class MoneyFactoryTest {
	/** tolerance for comparing two double values */
	private static final double TOL = 1.0E-6;
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /** Easy test that the MoneyFactory constructor is working. */
    @Test
    public void testConstructor()
    {
       MoneyFactory factory1 = MoneyFactory.getInstance();
       MoneyFactory factory2 = MoneyFactory.getInstance();
       assertEquals(factory1,factory2);
    }
    
    
    
}
