package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coinpurse.stratergy.GreedyWithdraw;
import coinpurse.stratergy.RecursiveWithdraw;
import coinpurse.stratergy.WithdrawStrategy;

// You will use Collections.sort() to sort the coins

/**
 * A money purse contains coins and banknotes. You can insert moneys withdraw
 * money, check the balance, and check if the purse is full.
 * 
 * @author Kwanwan Tantichartkul
 * @version 1.0
 * @since 19.01.2017
 */
public class Purse {

	/** Collection of objects in the purse. */
	private List<Valuable> money;

	/**
	 * Capacity is maximum number of items the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;

	/** The comparator for moneys **/
	private final Comparator<Valuable> compare = new ValueComparator();
	
	/**Strategy for withdraw you can use recursive or withdraw by create new strategy*/
	WithdrawStrategy withdrawstrategy = new RecursiveWithdraw();

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of moneys you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		this.money = new ArrayList<Valuable>();
	}

	/**
	 * Count and return the number of items in the purse.
	 * 
	 * @return the number of moneys in the purse
	 */
	public int count() {
		int size = money.size();
		return size;
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double col = 0;
		for (Valuable valuable : money) {
			col += valuable.getValue();
		}
		return col;
	}

	/**
	 * Return the capacity of the money purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		if (this.getCapacity() == this.money.size())
			return true;
		else
			return false;
	}

	/**
	 * Insert a money into the purse. The money is only inserted if the purse
	 * has space for it and the money have positive value. No worthless coins!
	 * 
	 * @param valuable
	 *            is a Money object to insert into purse
	 * @return true if money inserted, false if can't insert
	 */
	public boolean insert(Valuable valuable) {
		// if the purse is already full then can't insert anything.
		if (!isFull() && valuable.getValue() > 0) {
			money.add(valuable);
			return true;
		} else
			return false;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Moneys
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested. Withdraw the amount using the default currency ("Baht").
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Money objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {

		return withdraw(new Money(amount, "Baht"));
	}

	/**
	 * Withdraw the requested amount of any kinds of money. Return an array of
	 * Moneys withdrawn from purse, or return null if cannot withdraw the amount
	 * requested. Withdraw the amount for every currency.
	 * Now, It's applied for strategy to withdraw a money.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Money objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(Valuable amount) {

		double amountForWithdraw = amount.getValue();
		
		if (this.getBalance() < amountForWithdraw || amountForWithdraw <= 0)
			return null;
		
		Collections.sort(money, compare);
		Collections.reverse(money);
		
		List<Valuable> templist = withdrawstrategy.withdraw(amount, money);
//
//		String currency = amount.getCurrency();
//		if(currency == null) currency = "";
//
//		for (Valuable v : money) {
//			if (currency.equals(v.getCurrency())) {
//				if (v.getValue() <= amountForWithdraw) {
//					amountForWithdraw -= v.getValue();
//					templist.add(v);
//				} 
//				if (amountForWithdraw <= 0) break;
//			}
//
//		}
//		
//		//success for withdraw
//		if (amountForWithdraw != 0)
//			return null; //failed
//
		if(templist == null)
			return null;
		
		for (Valuable c1 : templist) {
			money.remove(c1);
		}

		Valuable[] array = new Valuable[templist.size()];
		templist.toArray(array);
		return array;

	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 * 
	 * @return the capacity and the balance of money for purse.
	 */
	@Override
	public String toString() {
		return this.getCapacity() + " coins with value" + this.getBalance();
	}

}
