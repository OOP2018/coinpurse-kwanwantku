package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
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
//		List<Valuable> values = new ArrayList<Valuable>();
//		Money coin = new Coin(5,"Baht");
//		Money coin2 = new Coin(10,"Baht");
//		Money coin3 = new Coin(1, "Baht");
//		Money coin4 = new Coin(0.00001, "BTC");
//		BankNote banknote1 = new BankNote(20, "Baht", 100);
//		BankNote banknote2 = new BankNote(100, "Baht", 101);
//		Purse purse = new Purse(10);
//		purse.insert(banknote2);
//		purse.insert(coin3);
//		purse.insert(coin4);
//		purse.withdraw(coin4);
//		purse.withdraw(coin3);
//		System.out.println(purse.toString());
//		values.add(coin);
//		values.add(coin2);
//		values.add(coin3);
//		values.add(banknote1);
//		values.add(banknote2);
//		values.add(new Coin(5, "Rupee"));
//		
//		System.out.println(coin3.equals(new Coin(1, "Baht")));
//		System.out.println(banknote1.equals(banknote2));
//		System.out.println(banknote1.compareTo(coin3));
//		System.out.println(banknote2.compareTo(coin3));
//		System.out.println(banknote2.compareTo(new Coin(1000, "Rupee")));
//		printCoins(values);
//		sortCoins(values);
//		printCoins(values);
//		printCoins(filterByCurrency(values,"Rupee"));
		
		List<BankNote> listmoney = new ArrayList<BankNote>();
		listmoney.add(new BankNote(10.0, "USD", 100));
		listmoney.add(new BankNote(500.0, "Baht", 101));
		listmoney.add(new BankNote(100.0, "Baht", 102));
		listmoney.add(new BankNote(1000.0, "Yen", 103));
		sortMoney(listmoney);
		printMoneys(listmoney);

		Money m1 = new BankNote(100.0, "Baht", 100);
		Money m2 = new BankNote(500.0, "Baht", 101);
		Money m3 = new Coin(10, "Baht");
		Money m4 = new Coin(1, "Baht");
		
		Money max = max(m1, m2, m3, m4);
		String maxanimal = max("dog", "zebra", "cat", "giraff");
		System.out.println(max);
		System.out.println(maxanimal);
		

		List<Coin> coins = Arrays.asList(new Coin(5, "Baht"), new Coin(0.1, "Ringgit"), new Coin(5, "Cent"));
		List<Coin> result = MoneyUtil.filterByCurrency(coins, "Baht");
		printMoneys(result);
		
		Double maxnumber = max(2.0, 3.0 ,10000000000.0, 55.345435, 534635.3453435);
		System.out.println(maxnumber);
	}
	/**
	 * This method is filter money by currency.
	 * @param moneys are list of money to compare with currency.
	 * @param currency that you want to filter.
	 * @return list of money in the currency that you want.
	 */
	public static <E extends Valuable>List<E> filterByCurrency(List<E> moneys,String currency) {
		List<E> tempvaluable = new ArrayList<E>();
		for(E money : moneys) {
			if(money.getCurrency() == currency) {
				tempvaluable.add(money);
			}
		}
		return tempvaluable;
	}
	
	/**
	 * This method is sort moneys in list.
	 * @param moneys are list of moneys.
	 */
	public static void sortMoney(List<? extends Valuable> moneys) {
		Collections.sort(moneys, new ValueComparator());
	}
	
	/**
	 * Print list of moneys.
	 * @param coins are list of moneys.
	 */
	public static void printMoneys(List<? extends Valuable> values) {
		System.out.println(values);
	}
	
	/**
	 * Return the larger argument, based on sort order, using the objects' own
	 * compareTo method for comparing.
	 * @param args one or more Comparable objects to compare.
	 * @return the argument that would be last if sorted the elements.
	 * @throws IllegalArgumentException if no arguments given.
	 */
	public static <E extends Comparable<? super E>> E max(E... args) {
		E max = args[0];
		try {
			for(int i =0; i< args.length; i++) {
				max = (args[i].compareTo(max) > 0) ? args[i] : max;
			}
		}
		catch(NullPointerException ex) {
			throw new IllegalArgumentException();
		}
		return max;
		
	}
	

	
	
}
