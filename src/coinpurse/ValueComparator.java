package coinpurse;

import java.util.Comparator;
/**
 * Compare money by check currency first and check value.
 * @author pranger54
 * @version 1.0
 * @since 27.01.2018
 */

public class ValueComparator implements Comparator<Valuable> {
   /**
     * Compare two objects that implement Valuable.
     * First compare them by currency, so that "Baht" < "Dollar".
     * If both objects have the same currency, order them by value.
     */
	@Override
	public int compare(Valuable o1, Valuable o2) {
		if(o1.getCurrency().compareToIgnoreCase(o2.getCurrency()) == 0) {
			return (o1.getValue()>o2.getValue()) ? 1: (o1.getValue()<o2.getValue()) ? -1:0;
		}
		
		return o1.getCurrency().compareToIgnoreCase(o2.getCurrency());
	}

}
