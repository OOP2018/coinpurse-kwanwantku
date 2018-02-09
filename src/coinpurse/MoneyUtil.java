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
		Money coin = new Coin(5,"Baht");
		Money coin2 = new Coin(10,"Baht");
		Money coin3 = new Coin(1, "Baht");
		BankNote banknote1 = new BankNote(20, "Baht");
		BankNote banknote2 = new BankNote(100, "Baht");
		values.add(coin);
		values.add(coin2);
		values.add(coin3);
		values.add(banknote1);
		values.add(banknote2);
		values.add(new Coin(5, "Rupee"));
		System.out.println(coin3.equals(new Coin(1, "Baht")));
		System.out.println(banknote1.equals(banknote2));
		System.out.println(banknote1.compareTo(coin3));
		System.out.println(banknote2.compareTo(coin3));
		System.out.println(banknote2.compareTo(new Coin(1000, "Rupee")));
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
