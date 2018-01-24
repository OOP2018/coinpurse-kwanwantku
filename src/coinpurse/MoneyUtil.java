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
		List<Coin> coins = new ArrayList<Coin>();
		Coin coin = new Coin(5,"Baht");
		Coin coin2 = new Coin(10,"Baht");
		Coin coin3 = new Coin(1, "Baht");
		coins.add(coin);
		coins.add(coin2);
		coins.add(coin3);
		coins.add(new Coin(5, "Rupee"));
		printCoins(coins);
		sortCoins(coins);
		printCoins(coins);
		filterByCurrency(coins,"Rupee");
		printCoins(coins);
		
	}
	/**
	 * This method is filter money by currency.
	 * @param coins are list of coin to compare with currency.
	 * @param currency that you want to filter.
	 * @return list of money in the currency that you want.
	 */
	public static List<Coin> filterByCurrency(List<Coin> coins,String currency) {
		List<Coin> tempcoin = new ArrayList<Coin>();
		for(Coin coin:coins) {
			if(coin.getCurrency() == currency) {
				tempcoin.add(coin);
			}
		}
		return tempcoin;
	}
	
	/**
	 * This method is sort coins in list.
	 * @param coins are list of coins.
	 */
	public static void sortCoins(List<Coin> coins) {
		Collections.sort(coins);
	}
	
	/**
	 * Print list of coins.
	 * @param coins are list of coins.
	 */
	public static void printCoins(List<Coin> coins) {
		System.out.println(coins);
	}
	

	
	
}
