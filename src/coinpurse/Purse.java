package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// You will use Collections.sort() to sort the coins

/**
 *  A coin purse contains coins.
 *  You can insert coins, withdraw money, check the balance,
 *  and check if the purse is full.
 *  
 *  @author Kwanwan Tantichartkul
 *  @version 1.0
 *  @since 19.01.2017
 */
public class Purse {
    /** Collection of objects in the purse. */
	private List<Coin> money;
    
    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of coins you can put in purse.
     */
    public Purse( int capacity ) {
    	this.capacity = capacity;
    	this.money = new ArrayList<Coin>();
    }

    /**
     * Count and return the number of coins in the purse.
     * This is the number of coins, not their value.
     * @return the number of coins in the purse
     */
    public int count() {
    	int size = money.size();
    	return size;
    }
    
    /** 
     *  Get the total value of all items in the purse.
     *  @return the total value of items in the purse.
     */
    public double getBalance() {
    	double col = 0;
    	for(Coin coin : money) {
    		col += coin.getValue();
    	}
		return col; 
	}

    
    /**
     * Return the capacity of the coin purse.
     * @return the capacity
     */
    public int getCapacity() { 
		return this.capacity;
	}
    
    /** 
     *  Test whether the purse is full.
     *  The purse is full if number of items in purse equals
     *  or greater than the purse capacity.
     *  @return true if purse is full.
     */
    public boolean isFull() {
    	if(this.getCapacity() == this.money.size()) 
    		return true;
    	else 
    		return false;
    }

    /** 
     * Insert a coin into the purse.
     * The coin is only inserted if the purse has space for it
     * and the coin has positive value.  No worthless coins!
     * @param coin is a Coin object to insert into purse
     * @return true if coin inserted, false if can't insert
     */
    public boolean insert( Coin coin ) {
        // if the purse is already full then can't insert anything.
    	if(!isFull() && coin.getValue() > 0) {
    		money.add(coin);
    		return true;
    	}
    	else 
    		return false;
    }
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of Coins withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of Coin objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Coin[] withdraw( double amount ) {
        
	   /*
		* See lab sheet for outline of a solution, 
		* or devise your own solution.
		* The idea is to be greedy.
		* Try to withdraw the largest coins possible.
		* Each time you choose a coin as a candidate for
		* withdraw, add it to a temporary list and
		* decrease the amount (remainder) to withdraw.
		* 
		* If you reach a point where amountNeededToWithdraw == 0
		* then you found a solution!
		* Now, use the temporary list to remove coins
		* from the money list, and return the temporary
		* list (as an array).
		*/
    	
    	if(this.getBalance() < amount) 
    		return null;
    	
    	List<Coin> templist = new ArrayList<Coin>();
    	Collections.sort(money);
		Collections.reverse(money);
		int i = 0;
		
		// Did we get the full amount?
		// This code assumes you decrease amount each time you remove a coin.
    	// Your code might use some other variable for the remaining amount to withdraw.
		while(amount>0) {
			if(i<money.size()) {
				if(money.get(i).getValue() <= amount) {
					amount -= money.get(i).getValue();
    				templist.add(money.get(i));
    				money.remove(i);
				}
				else
					i++;
			}
			else
				break;
		}
    	
    	if(amount>0) 
    		return null;

		// Success.
		// Remove the coins you want to withdraw from purse,
		// and return them as an array.
		// Use list.toArray( array[] ) to copy a list into an array.
		// toArray returns a reference to the array itself.
		Coin [] array = new Coin[templist.size()];
		templist.toArray(array);
        return array; 
	}
  
    /** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    @Override
    public String toString() {
    	return this.getCapacity()+" coins with value" + this.getBalance();
    }

}
