package coinpurse;

public class BankNote implements Valuable{
	/**a value of the banknote*/
	private double value;
	/**a currency of the bankoten*/
	private String currency;
	/**a serial number for banknote*/
	private long serialNumber;
	/**next serial number for generate banknote*/
	private static long nextSerialNumber = 1000000;
	
	/**
	 * Characteristics of banknote.
	 * @param value is value of each banknote.
	 * 		  currency is type of banknote reference from each country.
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber++;
		
	}
	
	/**
	 * The value of each banknote
	 * @return value of banknote
	 */
	@Override
	public double getValue() {
		return this.value;
	}
	
	/**
	 * The currency of each currency
	 * @return currency of currency
	 */
	@Override
	public String getCurrency() {
		return this.currency;
	}
	
	/**
	 * The serial number for banknote
	 * @return serial number of each banknote
	 */
	public long getSerial() {
		return this.serialNumber;
	}
	
	/**
	 * Two banknotes are equal if value and currency are same.
	 * @param obj is Banknote object that want to check
	 * @return true if same currency and same value
	 * 		   false if not same currency and not same value;
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null) 
			return false;
		if(this == obj) 
			return true;
		if(this.getClass() != obj.getClass())
			return false;
		BankNote other = (BankNote) obj;
		return this.currency.equals(other.currency) && (this.value == other.value);
	}
	
	/**
	 * The detail of each coin
	 * @return detail of each coin
	 */
	@Override
	public String toString() {
		return this.value+"-"+this.currency+" note "+ "["+this.serialNumber+"]";
	}
}
