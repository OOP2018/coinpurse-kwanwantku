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
	/** set of Thai money String*/
	private static final String[] thaiMoney= {"0.5","1","5", "20", "50", "100", "1000"};
	/** set of Malay money String*/
	private static final String[] malayMoney= {"0.05", "0.2","1", "2", "10", "20", "100"};

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
    public void testConstructor() {
       MoneyFactory factory1 = MoneyFactory.getInstance();
       MoneyFactory factory2 = MoneyFactory.getInstance();
       assertEquals(factory1,factory2);
    }
    /** test for create set of Thai money*/
    @Test
    public void testCreateSetOfThaiMoney() {
    	MoneyFactory.setFactory(new ThaiMoneyFactory());
    	MoneyFactory factorytest = MoneyFactory.getInstance();
    	for(String arg : thaiMoney) {
			Valuable v = factorytest.createMoney(arg);
			assertEquals(v,MoneyFactory.getInstance().createMoney(arg));
			
    	}
    }
    
    /** test for create set of Malay money*/
    @Test
    public void testCreateSetOfMalayMoney() {
    	MoneyFactory.setFactory(new MalayMoneyFactory());
    	MoneyFactory factorytest = MoneyFactory.getInstance();
    	for(String arg : malayMoney) {
			Valuable v = factorytest.createMoney(arg);
			assertEquals(v,MoneyFactory.getInstance().createMoney(arg));
    	}
    }
    
    /** test for create Thai money*/
    @Test
    public void testCreateThaiMoney() {
    	MoneyFactory.setFactory(new ThaiMoneyFactory());
    	MoneyFactory factorytest = MoneyFactory.getInstance();
    	Valuable coin1 = new Coin(25,"Stang");
    	Valuable coin2 = new Coin(50,"Stang");
    	Valuable coin3 = new Coin(1,"Baht");
    	Valuable coin4 = new Coin(5,"Baht");
    	Valuable coin5 = new Coin(10,"Baht");
    	Valuable banknote1 = new BankNote(20,"Baht");
    	Valuable banknote2 = new BankNote(50,"Baht");
    	Valuable banknote3 = new BankNote(100,"Baht");
    	Valuable banknote4 = new BankNote(500,"Baht");
    	Valuable banknote5 = new BankNote(1000,"Baht");
    	assertEquals(coin1,factorytest.createMoney(0.25));
    	assertEquals(coin2,factorytest.createMoney(0.5));
    	assertEquals(coin3,factorytest.createMoney(1));
    	assertEquals(coin4,factorytest.createMoney(5));
    	assertEquals(coin5,factorytest.createMoney(10));
    	assertEquals(banknote1,factorytest.createMoney(20));
    	assertEquals(banknote2,factorytest.createMoney(50));
    	assertEquals(banknote3,factorytest.createMoney(100));
    	assertEquals(banknote4,factorytest.createMoney(500));
    	assertEquals(banknote5,factorytest.createMoney(1000));
    }
    
    /** test for create Malaysia money*/
    @Test
    public void testCreateMalayMoney() {
    	MoneyFactory.setFactory(new MalayMoneyFactory());
    	MoneyFactory factorytest = MoneyFactory.getInstance();
    	Valuable coin1 = new Coin(5,"Sen");
    	Valuable coin2 = new Coin(10,"Sen");
    	Valuable coin3 = new Coin(20,"Sen");
    	Valuable coin4 = new Coin(50,"Sen");
    	Valuable banknote1 = new BankNote(1,"Ringgit");
    	Valuable banknote2 = new BankNote(2,"Ringgit");
    	Valuable banknote3 = new BankNote(5,"Ringgit");
    	Valuable banknote4 = new BankNote(10,"Ringgit");
    	Valuable banknote5 = new BankNote(20,"Ringgit");
    	Valuable banknote6 = new BankNote(50,"Ringgit");
    	Valuable banknote7 = new BankNote(100,"Ringgit");
    	assertEquals(coin1,factorytest.createMoney(0.05));
    	assertEquals(coin2,factorytest.createMoney(0.1));
    	assertEquals(coin3,factorytest.createMoney(0.2));
    	assertEquals(coin4,factorytest.createMoney(0.5));
    	assertEquals(banknote1,factorytest.createMoney(1));
    	assertEquals(banknote2,factorytest.createMoney(2));
    	assertEquals(banknote3,factorytest.createMoney(5));
    	assertEquals(banknote4,factorytest.createMoney(10));
    	assertEquals(banknote5,factorytest.createMoney(20));
    	assertEquals(banknote6,factorytest.createMoney(50));
    	assertEquals(banknote7,factorytest.createMoney(100));
    }
    
    /** test for get currency*/
    @Test
   public void testGetCollectCurrency() {
    	MoneyFactory.setFactory(new MalayMoneyFactory());
        MoneyFactory factory = MoneyFactory.getInstance();
        Coin no1 = (Coin) factory.createMoney(0.5);
        assertEquals("Sen",no1.getCurrency());
        Coin no2 = (Coin) factory.createMoney(0.1);
        assertEquals("Sen",no2.getCurrency());
        BankNote bank1 = (BankNote) factory.createMoney(20);
        assertEquals("Ringgit",bank1.getCurrency());
        BankNote bank2 = (BankNote) factory.createMoney(100);
        assertEquals("Ringgit",bank2.getCurrency());
    	MoneyFactory.setFactory(new ThaiMoneyFactory());
        MoneyFactory factory2 = MoneyFactory.getInstance();
        Coin no3 = (Coin) factory2.createMoney(0.5);
        assertEquals("Stang",no3.getCurrency());
        Coin no4 = (Coin) factory2.createMoney(1);
        assertEquals("Baht",no4.getCurrency());
        BankNote bank3 = (BankNote) factory2.createMoney(20);
        assertEquals("Baht",bank3.getCurrency());
        BankNote bank4 = (BankNote) factory2.createMoney(500);
        assertEquals("Baht",bank4.getCurrency());
   }
    
    /** test for get information*/
    @Test
    public void testGetCollectInformation() {
     	MoneyFactory.setFactory(new MalayMoneyFactory());
         MoneyFactory factory = MoneyFactory.getInstance();
         Coin no1 = (Coin) factory.createMoney(0.5);
         assertEquals("50.0-Sen",no1.toString());
         Coin no2 = (Coin) factory.createMoney(0.1);
         assertEquals("10.0-Sen",no2.toString());
     	 MoneyFactory.setFactory(new ThaiMoneyFactory());
         MoneyFactory factory2 = MoneyFactory.getInstance();
         Coin no3 = (Coin) factory2.createMoney(0.5);
         assertEquals("50.0-Stang",no3.toString());
         Coin no4 = (Coin) factory2.createMoney(1);
         assertEquals("1.0-Baht",no4.toString());
    }

    
}
