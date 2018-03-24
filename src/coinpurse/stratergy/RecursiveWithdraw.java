package coinpurse.stratergy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Money;
import coinpurse.Valuable;

public class RecursiveWithdraw implements WithdrawStratergy {

	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		if(money.isEmpty() && amount.getValue() != 0) 
			return null;
		if(amount.getValue() == 0)
			return new ArrayList<Valuable>();
	
		//select the first item in the list, for possible withdraw.
		Valuable first = money.get(0);
		double amountTowithdraw = amount.getValue()-first.getValue();
		Valuable remaining = new Money(amountTowithdraw,amount.getCurrency());
		List<Valuable> result;
		if(amount.getCurrency().equals(first.getCurrency())) {
			result= withdraw(remaining, money.subList(1, money.size()));
			if(result != null) {
				result.add(first);
				return result;
			}
			result = withdraw(amount, money.subList(1, money.size()));
			if(result != null) {
				return result;
			}
		}
		

		return null;
	}
	

}
