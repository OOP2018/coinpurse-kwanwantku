package coinpurse.stratergy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coinpurse.Valuable;
import coinpurse.ValueComparator;
/**
 * 
 * @author pranger54
 *
 */
public class GreedyWithdraw implements WithdrawStratergy{
	/** The comparator for moneys **/
	private final Comparator<Valuable> compare = new ValueComparator();
	
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		List<Valuable> templist = new ArrayList<Valuable>();
		Collections.sort(money, compare);
		Collections.reverse(money);
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
			
		}
		
		if (amountWithdraw != 0) 
			return templist;
			
		return null;

	}


}
