package coinpurse;

/**
 * Coin has a value and a currency.
 * Coin can compare to other coins.
 * @author Kwanwan Tantichartkul
 * @version 1.0
 * @since 19.01.2018
 */
public class Coin extends Money {
	/**
	 * Initialize a new coin.
	 * Coin have value and currency.
	 * @param value is value of each coin.
	 * @param currency is type of coin reference from each country.
	 */
	public Coin(double value, String currency) {
		super(value,currency);
	}

	
	/**
	 * The detail of each coin
	 * @return detail of each coin
	 */
	@Override
	public String toString() {
		return this.getValue()+ "-" + this.getCurrency();
		
	}

}
