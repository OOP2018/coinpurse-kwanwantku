package coinpurse;
/**
 * An interface for objects having a monetary value and currency. 
 * @author Kwawnan Tantichartkul
 * @version 1.0
 * @since 26.01.2018
 */
public interface Valuable {
	
	/**
     * Get the monetary value of this object, in its own currency.
     * @return the value of this object
     */
     public double getValue();
     
 	/**
 	 * The currency of each coin
 	 * @return currency of coin
 	 */
 	public String getCurrency();

}
