package coinpurse;

/**
 * Banknote has a value and a currency.
 * Banknote has serial number for each banknote.
 * Banknote can compare to others banknote.
 * @author Kwanwan Tantichartkul
 * @version 1.1
 * @since 6.02.2018
 */
public class BankNote extends Money {
	/**a serial number for banknote*/
	private long serialNumber;

	/**
	 * Initialize a new banknote.
	 * Banknote have value and currency.
	 * It also has own serial number for each banknote already.
	 * @param value is value of each banknote.
	 * @param currency is type of banknote reference from each country.
	 * @param serialNumber is the serial of the Banknote.
	 */
	public BankNote(double value,String currency,long serialNumber) {
		super(value, currency);
		this.serialNumber = serialNumber;
	}

	
	/**
	 * The serial number for banknote
	 * @return serial number of each banknote
	 */
	public long getSerial() {
		return this.serialNumber;
	}
	
	/**
	 * The detail of each banknote
	 * @return detail of each banknote
	 */
	@Override
	public String toString() {
		return this.getValue()+"-"+this.getCurrency()+" note "+ "["+this.serialNumber+"]";
	}
}
