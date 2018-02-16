package coinpurse;

public class MalayMoneyFactory extends MoneyFactory{
	
	private long serialnumber;
	
	public MalayMoneyFactory() {
		
	}

	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException {
		if(value == 0.05) 
			return new Coin(5,"Sen");
		else if (value == 0.1) 
			return new Coin(10,"Sen");
		else if(value == 0.2) 
			return new Coin(20,"Sen");
		else if (value == 0.5) 
			return new Coin(50,"Sen");
		else if(value == 1) 
			return new BankNote(1,"Ringgit");
		else if (value == 2) 
			return new BankNote(2,"Ringgit");
		else if(value == 5) 
			return new BankNote(5,"Ringgit");
		else if (value == 10) 
			return new BankNote(10,"Ringgit");
		else if(value == 20) 
			return new BankNote(20,"Ringgit");
		else if (value == 50) 
			return new BankNote(50,"Ringgit");
		else if(value == 100) 
			return new BankNote(100,"Ringgit");
		else 
			return null;
	}

}
