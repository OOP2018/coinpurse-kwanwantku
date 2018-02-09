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
     * Compare two moneys that implement Valuable.
     * First compare them by currency, so items with same currency are grouped together
     * If both two moneys have the same currency, then order by value.
     */
	@Override
	public int compareTo(Valuable o) {
		int comp = this.getCurrency().compareToIgnoreCase(o.getCurrency());
		if (comp != 0) return comp;
		return Double.compare(this.getValue(), o.getValue());

	}



}