package coinpurse;

/**
 * Coin has a value and a currency.
 * Coin can compare to other coins.
 * @author Kwanwan Tantichartkul
 * @version 1.0
 * @since 19.01.2018
 */
public class Coin implements Comparable<Coin>,Valuable{
	/**a value of the coin*/
	private double value;
	/**a currency of the coin*/
	private String currency;
	
	/**
	 * Initialize a new coin.
	 * Coin have value and currency.
	 * @param value is value of each coin.
	 * @param currency is type of coin reference from each country.
	 */
	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}
	
	/**
	 * The value of each coin
	 * @return value of coin
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * The currency of each coin
	 * @return currency of coin
	 */
	public String getCurrency() {
		return currency;
	}
	
	/**
	 * Two coins are equal if value and currency are same.
	 * @param arg is Coin object that want to check
	 * @return true if same currency and same value
	 * 		   false if not same currency and not same value;
	 */
	@Override
	public boolean equals(Object arg) {
		if(arg == null) 
			return false;
		if(this == arg) 
			return true;
		if(this.getClass() != arg.getClass())
			return false;
		Coin other = (Coin) arg;
		return this.currency.equals(other.currency) && (this.value == other.value);
		
	}
	
	/**
	 * Order Coins value so that the coin with samller come first.
	 * @param coin is coin that want to compare
	 * @return +1 if this coin is more than other coin.
	 * 		   -1 if this coin is less than other coin.
	 * 			0 if this coin is equal other coin.
	 */
	public int compareTo(Coin coin) {
		if(this.value > coin.value) return +1;
		if(this.value < coin.value) return -1;
		return 0;
	}
	
	/**
	 * The detail of each coin
	 * @return detail of each coin
	 */
	@Override
	public String toString() {
		return this.value+ "-" + this.currency;
		
	}

}
