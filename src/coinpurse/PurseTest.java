package coinpurse;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the Purse using JUnit.
 * This is a JUnit 4 test suite.  
 * 
 * IDEs (Eclipse, Netbeans, IntelliJ, BlueJ) include JUnit 4,
 * but you have to tell the IDE to add it to your project as a "Library".
 * To run these tests, right click on this file (in Project panel)
 * and choose Run As -> JUnit test
 * 
 * @author  Resident Evil
 * @version 2018.01.19
 */
public class PurseTest {
	/** tolerance for comparing two double values */
	private static final double TOL = 1.0E-6;
	private static final String CURRENCY = "Baht";
	private static long nextSerialNumber = 1000000;
	
    /**
     * Sets up the test fixture.
     * Called before every test method.
     */
    @Before
    public void setUp() {
    	// nothing to initialize
    }
    
    /** Make a coin and a banknote with the default currency. */
    private Valuable makeValuable(double value) {
    	if(value < 20 )
    		return new Coin(value,CURRENCY);
    	else 
    		return new BankNote(value,CURRENCY,nextSerialNumber++);
	}	
    

    /** Easy test that the Purse constructor is working. */
    @Test
    public void testConstructor()
    {
        Purse purse = new Purse(3);
        assertEquals(3, purse.getCapacity());
        assertEquals(false, purse.isFull());
        assertEquals(0, purse.count());
    }

    

    /** Insert some coins. Easy test. */
    @Test
    public void testInsert()
    {
        Purse purse = new Purse(5);
        Valuable coin1 = makeValuable(5);
        Valuable coin2 = makeValuable(10);
        Valuable coin3 = makeValuable(1);
        Valuable banknote1 = makeValuable(100);
        Valuable banknote2 = makeValuable(20);
        assertTrue( purse.insert(coin1));
        assertTrue( purse.insert(coin3));
        assertTrue( purse.insert(coin2));
        assertTrue(purse.insert(banknote1));
        assertTrue(purse.insert(banknote2));
        assertEquals( 5, purse.count() );
        // purse is full so insert should fail
        assertFalse( purse.insert(makeValuable(1)) );
    }


	/** Insert should reject coin with no value. */
    @Test
    public void testInsertNoValue()
    {
        Purse purse = new Purse(3);
        Valuable fakeCoin = new Coin(0, CURRENCY);
        assertFalse( purse.insert(fakeCoin) );
    }


    @Test(timeout=1000)
    public void testIsFull()
    {   // borderline case (capacity 1)
        Purse purse = new Purse(1);
        assertFalse( purse.isFull() );
        purse.insert( makeValuable(1) );
        assertTrue( purse.isFull() );
        // real test
        int capacity = 4;
        purse = new Purse(capacity);
        for(int k=1; k<=capacity; k++) {
            assertFalse(purse.isFull());
            purse.insert( makeValuable(k) );
        }
        // should be full now
        assertTrue( purse.isFull() );
        assertFalse( purse.insert( makeValuable(5) ) );
    }

	/** Should be able to insert same coin many times,
	 *  since spec doesn't say anything about this.
	 */
	@Test(timeout=1000)
	public void testInsertSameCoin()
	{
		int capacity = 8;
		double value = 10.0;
		Purse purse = new Purse(capacity);
		Valuable coin = new Coin(value, "THB");
		Valuable banknote = new BankNote(value,"Dollar",nextSerialNumber++);
		assertTrue( purse.insert(coin) );
		assertTrue( purse.insert(coin) ); // should be allowed
		assertTrue( purse.insert(coin) ); // should be allowed
		assertTrue( purse.insert(coin) ); // should be allowed
		assertTrue( purse.insert(coin) ); // should be allowed
		assertTrue( purse.insert(banknote) ); // should be allowed
		assertTrue( purse.insert(banknote) ); // should be allowed
		assertTrue( purse.insert(banknote) ); // should be allowed
		assertEquals( purse.getBalance(), 8*value, TOL);
	}

	/** Add one coin and remove it. */
	@Test(timeout=1000)
	public void testEasyWithdraw() {
		Purse purse = new Purse(10);
		double [] values = {1, 20, 0.5, 10}; // values of coins we will insert
		
		for(double value : values) {
			Valuable coin = makeValuable(value);
			assertTrue(purse.insert(coin));
			assertEquals(value,  purse.getBalance(), TOL);
			Valuable [] result = purse.withdraw(value);
			assertTrue( result != null );
			assertEquals( 1, result.length );
			assertSame(  coin, result[0] ); // should be same object
			assertEquals( 0, purse.getBalance(), TOL );
		}
	}
	

	/** Add 4 coins and then withdraw in pairs, but not in same order. */
	@Test(timeout=1000)
	public void testMultiWithdraw() {
		Purse purse = new Purse(10);
		Valuable[] coins = { makeValuable(5.0), makeValuable(10.0), makeValuable(1.0), makeValuable(5.0) };
		// insert them all
		for(Valuable coin: coins) assertTrue( purse.insert(coin) );
		
		double amount1 = coins[1].getValue() + coins[3].getValue();
		double amount2 = coins[0].getValue() + coins[2].getValue();
		assertEquals(amount1+amount2, purse.getBalance(), TOL );
		
		Valuable [] wd1 = purse.withdraw(amount1);
		assertEquals(amount1, sum(wd1), TOL );
		
		assertEquals(amount2, purse.getBalance(), TOL );
		Valuable [] wd2 = purse.withdraw(amount2);
		
		// should be empty now
		assertEquals(0, purse.getBalance(), TOL );
	}
	

	/** Withdraw full amount in purse, using varying numbers of objects. */
	@Test(timeout=1000)
	public void testWithdrawEverything() {
		Purse purse = new Purse(10);
		// Coins we want to insert and then withdraw.
		// Use values such that greedy will succeed, but not monotonic
		List<Valuable> moneys = Arrays.asList(
				makeValuable(1.0), makeValuable(0.5), makeValuable(10.0), makeValuable(0.25), makeValuable(5.0)
				);
		// num = number of coins to insert and then withdraw
		for(int num=1; num <= moneys.size(); num++) {
			double amount = 0.0;
			List<Valuable> subList = moneys.subList(0, num);
			for(Valuable v: subList) {
				purse.insert(v);
				amount += v.getValue();
			}
			// balance should be exactly what we just inserted
			assertEquals( amount, purse.getBalance(), TOL);
			// can we withdraw it all?
			Valuable[] result = purse.withdraw(amount);
			String errmsg = String.format("couldn't withdraw %.2f but purse has %s",
					amount, Arrays.toString(subList.toArray()) );
			assertNotNull( errmsg, result );
			// is the amount correct?
			assertEquals("Withdraw wrong amount", amount, sum(result), TOL);
			// should not be anything left in the purse
			assertEquals( 0.0, purse.getBalance(), TOL);
		}
	}


	@Test(timeout=1000)
	public void testImpossibleWithdraw() {
		Purse purse = new Purse(10);
		assertNull( purse.withdraw(1) );
		purse.insert( makeValuable(20) );
		assertNull( purse.withdraw(1) );
		assertNull( purse.withdraw(19) );
		assertNull( purse.withdraw(21) );
		purse.insert( makeValuable(20) ); // now it has 20 + 20
		assertNull( purse.withdraw(30) );
	}
	
	/**
	 * Sum the value of some coins.
	 * @param wd1 array of coins
	 * @return sum of values of the coins
	 */
	private double sum(Valuable[] wd1)  {
		if (wd1 == null) return 0.0;
		double sum = 0;
		for(Valuable v: wd1) if (v != null) sum += v.getValue();
		return sum;
	}
}


