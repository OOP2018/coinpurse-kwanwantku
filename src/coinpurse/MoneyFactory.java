package coinpurse;

/**
 * The factory can create money to using with purse.
 * Their can control to create each currency.
 * By using the Singleton pattern for produce the money.
 * @author Kwanwan Tantichartkul
 * @version 1.0
 * @since 2018.02.14
 */
public abstract class MoneyFactory {
	/**The factory that create money*/
	private static MoneyFactory factory;
	
	/**
	 * To get the instance of money. 
	 * By setting the default which currency that you want to create it.
	 * You can switch the currency in coinpurse.properties files.
	 * @throws When it's not type of money factory. It will get ClassCastException.
	 * 		   Another Exception that can make the error to creating money.
	 */
	public static MoneyFactory getInstance() {
		return factory;
	}
	
	/**
	 * It's the abstract to control to create each currency.
	 * It's the main that selecting currency to produce.
	 * @param the value of each money from each currency.
	 * @throws IllegalArgumentException if value is not a valid currency amount.
	 */
	public abstract Valuable createMoney(double value) throws IllegalArgumentException;
	
	/**
	 * It's the function that create money from the factory.
	 * It's convert from string to double for their collect money in String version.
	 * @param the value of each money from each currency in the String.
	 */	
    public Valuable createMoney(String value) {
    	try {
    		return createMoney(Double.parseDouble(value));
    	}catch(Exception e) {
    		throw new IllegalArgumentException();
    	}
       // parse the String as a double and call the other createMoney method
   }
    
    /**
     * The set factory when factory doesn't create money.
     * @param factory is the factory that want to create new one.
     */
    public static void setFactory(MoneyFactory factory) {
		MoneyFactory.factory = factory;
	}

}
