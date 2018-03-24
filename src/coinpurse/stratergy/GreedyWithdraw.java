package coinpurse.stratergy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coinpurse.Valuable;
import coinpurse.ValueComparator;
/**
 * The greedy strategy withdraw to withdraw the money that you want withdraw
 * @author Kwanwan Tantihchartkul 
 * @version 1.0
 * @since 2018.03.24
 */
public class GreedyWithdraw implements WithdrawStrategy {
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
		List<Valuable> templist = new ArrayList<Valuable>();
		double amountWithdraw = amount.getValue();
		String currencyWithdraw = amount.getCurrency();
		if(currencyWithdraw == null) 
			currencyWithdraw = "";
		double colamount = 0;
		for(int i=0;i<money.size();i++) {
			String currency = money.get(i).getCurrency();
			double value = money.get(i).getValue();
			if(currency.equals(currencyWithdraw)) {
				if(colamount+value<= amountWithdraw) {
					colamount+=value;
					templist.add(money.get(i));
				}
				
				else if(colamount+value > amountWithdraw) 
					continue;
			}
			if(colamount == amountWithdraw)
				return templist;
		}	
		return null;
	}

}
