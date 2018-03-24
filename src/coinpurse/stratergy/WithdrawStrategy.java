package coinpurse.stratergy;

import java.util.List;

import coinpurse.Valuable;
/**
 * The withdraw stratergy interface for implements the withdraw algorithm to withdraw money.
 * @author Kwanwan Tantichartkul
 * @version 1.0
 * @since 2018.03.23
 */
public interface WithdrawStrategy {
	
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
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money);

}
