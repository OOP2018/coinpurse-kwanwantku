package coinpurse;

/**
 * The Thai Factory is create Malaysia Money.
 * @author Kwanwan Tantichartkul
 * @version 1.0
 * @since 2018.02.16
 */
public class ThaiMoneyFactory extends MoneyFactory{
	
	/**next serial number for generate banknote*/
	private static long nextSerialNumber = 1000000;
	
	/*
	 * Create Thailand money with currency and value.
	 * The BankNote can generate serial number for each BankNote.
	 * @param value is the value of money.
	 * @throw IllegalArgumentException for creating wrong money values.
	 */
	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException{
		if(value == 0.25) 
			return new Coin(25,"Stang");
		else if (value == 0.5) 
			return new Coin(50,"Stang");
		else if(value == 1) 
			return new Coin(1,"Baht");
		else if (value == 2) 
			return new Coin(2,"Baht");
		else if(value == 5) 
			return new Coin(5,"Baht");
		else if (value == 10) 
			return new Coin(10,"Baht");
		else if(value == 20) 
			return new BankNote(20,"Baht",nextSerialNumber++);
		else if (value == 50) 
			return new BankNote(50,"Baht",nextSerialNumber++);
		else if(value == 100) 
			return new BankNote(100,"Baht",nextSerialNumber++);
		else if (value == 500) 
			return new BankNote(500,"Baht",nextSerialNumber++);
		else if (value == 1000) 
			return new BankNote(1000,"Baht",nextSerialNumber++);
		else 
			return null;
	}
	
}
