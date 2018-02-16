package coinpurse;

public class ThaiMoneyFactory extends MoneyFactory{
	
	/**next serial number for generate banknote*/
	private static long nextSerialNumber = 1000000;
	
	@Override
	public Valuable createMoney(double value) {
		if(value == 0.25) 
			return new Coin(0.25,"Baht");
		else if (value == 0.5) 
			return new Coin(0.5,"Baht");
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
