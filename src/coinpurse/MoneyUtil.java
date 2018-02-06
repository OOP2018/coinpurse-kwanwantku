package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * MoneyUtil are sort and compare money.
 * @author Kwanwan Tantichartkul 
 * @version 1.0
 * @since 20.1.2018
 */
public class MoneyUtil {
	
	/*Test coin and purse */
	public static void main(String [] args) {
		List<Valuable> values = new ArrayList<Valuable>();
		Coin coin = new Coin(5,"Baht");
		Coin coin2 = new Coin(10,"Baht");
		Coin coin3 = new Coin(1, "Baht");
		values.add(coin);
		values.add(coin2);
		values.add(coin3);
		values.add(new Coin(5, "Rupee"));
		printCoins(values);
		sortCoins(values);
		printCoins(values);
		printCoins(filterByCurrency(values,"Rupee"));
		
	}
	/**
	 * This method is filter money by currency.
	 * @param moneys are list of money to compare with currency.
	 * @param currency that you want to filter.
	 * @return list of money in the currency that you want.
	 */
	public static List<Valuable> filterByCurrency(List<Valuable> valuables,String currency) {
		List<Valuable> tempvaluable = new ArrayList<Valuable>();
		for(Valuable valuable : valuables) {
			if(valuable.getCurrency() == currency) {
				tempvaluable.add(valuable);
			}
		}
		return tempvaluable;
	}
	
	/**
	 * This method is sort moneys in list.
	 * @param moneys are list of moneys.
	 */
	public static void sortCoins(List<Valuable> valuables) {
		Collections.sort(valuables, new ValueComparator());
	}
	
	/**
	 * Print list of moneys.
	 * @param coins are list of moneys.
	 */
	public static void printCoins(List<Valuable> values) {
		System.out.println(values);
	}
	

	
	
}
