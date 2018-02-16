package coinpurse;

import java.util.ResourceBundle;

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
	private static MoneyFactory instance = null;
	
	/**
	 * To get the instance of money. 
	 * By setting the default which currency that you want to create it.
	 * You can switch the currency in coinpurse.properties files.
	 * @throws When it's not type of money factory. It will get ClassCastException.
	 * 		   Another Exception that can make the error to creating money.
	 */
	public static MoneyFactory getInstance() {
//		if (instance == null) 
//			instance = new ThaiMoneyFactory();
//        return instance;
		
		//create a ResourceBundle from file "purse.properties" on the classpath
		//the ".properties" extension is automatically append to the name
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		
		//get value of "moneyfactory" property
		String factoryclass = bundle.getString("moneyfactory");
		//for testing, try this:
		System.out.println("Factory class name is "+factoryclass);
		try {
			instance = (MoneyFactory)Class.forName(factoryclass).newInstance();
		}
		catch(ClassCastException cce) {
			//the object could not be cast to type MoneyFactory
			System.out.println(factoryclass+" is not type MoneyFactory.");
		}
		catch(Exception ex) {
			//any another exception means we could not create an object
			System.out.println("Error creating MoneyFactory "+ ex.getMessage());
		}
		//if no factory the quit
		if(instance == null)
			System.exit(1);
		return instance;
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
    		throw new IllegalArgumentException(e.getMessage());
    	}
       // parse the String as a double and call the other createMoney method
   }
    
    /**
     * It's setting money factory for using money.
     * @param factory is import factory that create money
     */
    public static void setFactory(MoneyFactory factory) {
		MoneyFactory.instance = factory;
	}

}
