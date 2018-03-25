package coinpurse.stratergy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.*;

import coinpurse.Purse;

public class WithdrawTest {

	private WithdrawStrategy stratergy;
	
	@Before
	public void setUp() {
		stratergy = new RecursiveWithdraw();
	}
	
	/** A test method annotated by @Test */
    @Test
    public void testNewPurseIsEmpty() {
		Purse purse = new Purse(100);
		assertEquals(0, purse.count());
    }
	
	
}
