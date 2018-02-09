package coinpurse;

public class Money implements Valuable{

	/**a value of the money*/
	protected double value;
	/**a currency of the money*/
	protected String currency;

	public Money(double value, String currency) {
		if(value < 0) throw new IllegalArgumentException("Money must more than zero.");
		this.value = value;
		this.currency = currency;
	}

	/**
	 * The value of each moneys
	 * @return value of money
	 */
	public double getValue() {
		return value;
	}

	/**
	 * The currency of each moneys
	 * @return currency of money
	 */
	public String getCurrency() {
		return currency;
	}
	

	/**
	 * Two moneys are equal if value and currency are same.
	 * @param obj is moneys object that want to check
	 * @return true if same currency and same value
	 * 		   false if not same currency and not same value;
	 */
	@Override
	public boolean equals(Object other) {
		if(other == null) 
			return false;
		if(this == other) 
			return true;
		if(this.getClass() != other.getClass())
			return false;
		Money money = (Money) other; //cast to valuable also work
		return this.getCurrency().equalsIgnoreCase(money.getCurrency()) && (this.getValue() == money.getValue());
	}

	/**
	 * Order Moneys value so that the money with smaller value come first.
	 * @param money is money that want to compare
	 * @return +1 if this money is more than other money.
	 * 		   -1 if this money is less than other money.
	 * 			0 if this money is equal other money.
	 */
	public int compareTo(Valuable valueable) {
		if(this.value > valueable.getValue()) return +1;
		if(this.value < valueable.getValue()) return -1;
		return 0;
	}



}