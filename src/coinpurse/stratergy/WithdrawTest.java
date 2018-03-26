package coinpurse.stratergy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import coinpurse.BankNote;
import coinpurse.Coin;
import coinpurse.Money;
import coinpurse.Valuable;
/**
 * The withdraw test for testing strategy withdraw.
 * @author Kwanwan Tantichartkul
 * @version 1.0
 * @since 2018.03.25
 */
public class WithdrawTest {
	
	private static final double TOL = 1.0E-6;
	private WithdrawStrategy stratergy;
	private List<Valuable> listmoney = new ArrayList<Valuable>();
	private List<Valuable> listmoney2 = new ArrayList<Valuable>();
	
	/**
	 * Set up the strategy.
	 */
	@Before
	public void setUp() {
		stratergy = new GreedyWithdraw();
		//stratergy = new RecursiveWithdraw();
	}
    
	/**
	 * Test the normal withdraw
	 */
    @Test
    public void testNormalWithdraw() {
		Valuable coin1 = new Coin(5, "Baht");
		Valuable coin2 = new Coin(10, "Baht");
		Valuable coin3 = new Coin(1, "Baht");
		Valuable banknote1 = new BankNote(100, "Baht");
		Valuable banknote2 = new BankNote(20, "Baht");
		listmoney.add(coin1);
		listmoney.add(coin2);
		listmoney.add(coin3);
		listmoney.add(banknote1);
		listmoney.add(banknote2);
		listmoney2.add(coin1);
		listmoney2.add(coin2);
		listmoney2.add(coin3);
		listmoney2.add(banknote1);
		listmoney2.add(banknote2);	
		assertEquals(stratergy.withdraw(coin1, listmoney),stratergy.withdraw(coin1, listmoney2));
    }
    
    /**
     * Test the impossible withdraw
     */
    @Test
    public void testImpossibleWithdraw() {
		Valuable coin1 = new Coin(10, "Baht");
		assertNull(stratergy.withdraw(coin1, listmoney));
		Valuable banknote2 = new BankNote(1, "USD");
		listmoney.add(coin1);
		assertNull(stratergy.withdraw(banknote2, listmoney));
		assertNull(stratergy.withdraw(new BankNote(10, "Ringgit"), listmoney2));
    }
    
    /**
     * Test the withdraw another money that not in the list.
     */
    @Test(expected = NullPointerException.class)
    public void testWithdrawAnotherMoneyThatNotInTheList() {
    		BankNote banknote = new BankNote(10000, "Yen");
    		BankNote banknote2 = new BankNote(10000, "Yen");
    		listmoney.add(banknote);
    		listmoney.add(banknote2);
    		listmoney.add(null);
    		listmoney = stratergy.withdraw(new Coin(10, "Baht"), listmoney);
    }
    
    /**
     * Test the compare money.
     */
    @Test(timeout=1000)
    public void testWithdrawCompareMoney() {
    		BankNote banknote = new BankNote(10000, "Yen");
    		listmoney.add(banknote);
    		listmoney2.add(banknote);
    		assertEquals(stratergy.withdraw(banknote, listmoney), listmoney2);
    		listmoney2.remove(banknote);
    		BankNote banknote2 = new BankNote(5000, "Yen");
    		listmoney.add(banknote2);
    		listmoney2.add(banknote2);
    		assertEquals(stratergy.withdraw(banknote2, listmoney), listmoney2);
    		listmoney2.remove(banknote2);
    }
    
    /**
     * Test the multi withdraw money.
     */
    @Test(timeout=2000)
    public void testMultiWithdraw() {
		Valuable coin1 = new Coin(5, "Baht");
		Valuable coin2 = new Coin(10, "Baht");
		Valuable coin3 = new Coin(1, "Baht");
		Valuable coin4 = new Coin(5, "Baht");
		listmoney.add(coin1);
		listmoney.add(coin2);
		listmoney.add(coin3);
		listmoney.add(coin4);
		List<Valuable> testing = stratergy.withdraw(new Coin(21, "Baht"), listmoney);
		assertEquals(21,sumList(testing),TOL);
		
		listmoney.clear();
		Valuable coin5 = new Coin(5, "Baht");
		Valuable coin6 = new Coin(10, "Baht");
		Valuable banknote3 = new BankNote(100, "Baht");
		Valuable banknote4 = new BankNote(500, "Baht");
		Valuable banknote5 = new BankNote(1000, "Baht");
		listmoney.add(coin5);
		listmoney.add(coin6);
		listmoney.add(banknote3);
		listmoney.add(banknote4);
		listmoney.add(banknote5);
		testing = stratergy.withdraw(new Money(1615, "Baht"), listmoney);
		assertEquals(1615,sumList(testing),TOL);
		testing = stratergy.withdraw(new Money(20, "Baht"), listmoney);
		assertNull(testing);
    }
    
    /**
     * Test the impossible withdraw.
     */
    @Test
    public void testWithdrawEmptyList() {
    		assertNull(stratergy.withdraw(new Coin(10, "Ringgit"), listmoney));
    }
    
    /**
     * The sum method for sum list of money
     * @param money is the list of money.
     * @return the sum solution.
     */
    private double sumList(List<Valuable> money) {
    		double sum = 0.0;
    		for(Valuable v: money) {
    			sum += v.getValue();
    		}
    		return sum;
    }
    
    

}
