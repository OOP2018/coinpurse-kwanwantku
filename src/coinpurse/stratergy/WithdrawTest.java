package coinpurse.stratergy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import coinpurse.BankNote;
import coinpurse.Coin;
import coinpurse.Purse;
import coinpurse.Valuable;

public class WithdrawTest {
	
	// a "test fixture" - object to test
	private Purse purse;
	// tolerance for comparison
	private static final double TOL = 1.0E-6;
	private WithdrawStrategy stratergy;
	private List<Valuable> listmoney = new ArrayList<Valuable>();
	private List<Valuable> listmoney2 = new ArrayList<Valuable>();
	
	@Before
	public void setUp() {
		stratergy = new GreedyWithdraw();
	}
    
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
		stratergy.withdraw(coin1, listmoney);
		stratergy.withdraw(coin1, listmoney2);
		assertEquals(listmoney,listmoney2);
    }
    
    @Test
    public void textImpossibleWithdraw() {
		Valuable coin1 = new Coin(10, "Baht");
		assertNull(stratergy.withdraw(coin1, listmoney));
		Valuable banknote2 = new BankNote(1, "USD");
		listmoney.add(coin1);
		assertNull(stratergy.withdraw(banknote2, listmoney));
		assertNull(stratergy.withdraw(new BankNote(10, "Ringgit"), listmoney2));
    }
    
    
    
    
    
    
    
	
	
}
