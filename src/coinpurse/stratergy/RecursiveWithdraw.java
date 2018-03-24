package coinpurse.stratergy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coinpurse.Money;
import coinpurse.Valuable;
import coinpurse.ValueComparator;
/**
 * The recursive strategy withdraw to withdraw the money that you want withdraw
 * @author Kwanwan Tantichartkul
 * @version 1.0
 * @since 2018.03.24
 */
public class RecursiveWithdraw implements WithdrawStrategy {
	/**
	 * Find and return items from a collection whose total value equals
	 * the requested amount.
	 * @param amount is the amount of money to withdraw, with currency.
	 * @param money the contents that are available for possible withdraw.
	 * 		  Must not be null, but may be an empty list.
	 * 		  This list is not modified.
	 * @return If a solution is found, return a List containing references.
	 * 		  form the money parameter (List) whose sum equals the amount.
	 * 		  IF a solution is not found, returns cannot withdraw.
	 */
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		return withdrawHelper(amount.getValue(), amount.getCurrency(), money);
	}
	/**
	 * The withdraw helper for withdraw the money by using recursive strategy.
	 * @param amount is the amount of money to withdraw
	 * @param currency is the currency of money to withdraw
	 * @param money is the contents that are available to withdraw the money.
	 * @return
	 */
	public List<Valuable> withdrawHelper(double amount, String currency, List<Valuable> money) {
		if(money == null || (money.isEmpty() && amount != 0) ) 
			return null;
		if(amount == 0)
			return new ArrayList<Valuable>();
		if(currency == null) 
			currency = "";
		//select the first item in the list, for possible withdraw.
		Valuable first = money.get(0);
		double amountTowithdraw = amount-first.getValue();
		String getcurrency = first.getCurrency();
		List<Valuable> result = withdrawHelper(amountTowithdraw, getcurrency, money.subList(1, money.size()));
		List<Valuable> resultamount = withdrawHelper(amount, getcurrency, money.subList(1, money.size()));
		if(currency.equals(first.getCurrency())) {
			if(result != null) {
				result.add(first);
				return result;
			}
			if(resultamount != null) {
				return resultamount;
			}
		}
		return null;
	}
	
	
	

}
