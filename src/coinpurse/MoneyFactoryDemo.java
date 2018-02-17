package coinpurse;
/**
 * The moneyfactory test methods.
 * For checking Factory is Singleton.
 * It also check about value, currency and create money from the factory.
 * @author Kwanwan Tantichartkul
 * @version 1.0
 * @since 2018.02.17
 */
public class MoneyFactoryDemo {
	/*
	 * The main class for MoneyFactory
	 */
	public static void main(String [] args) {
		
		System.out.println("Thai Money Factory");
		testCreateThaiMoney();
		System.out.println("--------------------------");
		System.out.println("Malay Money Factory");
		testCreateMalayMoney();
		System.out.println("--------------------------");
		System.out.println("Can't create Money Factory");
		testCantCreateMoney();
		System.out.println("--------------------------");
		System.out.println("test aspect result");
		testAspectResult();
	}
	
	/*
	 * The control for changing factory.
	 * @param factory is the factory that you want to change it.
	 */
    public static void setFactory(MoneyFactory factory) {
		MoneyFactory.setFactory(factory);
	}
    
    /**
     * Testing create Thailand money.
     * It can get values, currency and information.
     */
	public static void testCreateThaiMoney() {
		setFactory(new ThaiMoneyFactory());
		MoneyFactory factory1 = MoneyFactory.getInstance();
		System.out.println("factory1 is a "+factory1.getClass().getName());
		MoneyFactory factory2 = MoneyFactory.getInstance();
		System.out.println("factory2 is a "+factory2.getClass().getName());
		System.out.println("factory1 is equals to factory2 (same object?)");
		System.out.println(factory1 == factory2);
		String[] values = {"0.25","0.5","1","5","10","20","50","100","50","1000"};
		for(String arg : values) {
			Valuable v = factory1.createMoney(arg);
			System.out.println("Moneys" +arg);
			System.out.printf("createMoney(%s) = %s%n",arg,v);
			//try to getting information of coin
			System.out.printf("getCurrency(%s) = %s%n",arg,v.getCurrency());
			System.out.printf("getValue(%s) = %s%n",arg,v.getValue());
			System.out.printf("toString(%s) = %s%n",arg,v.toString());
			System.out.println("--------------------------");
		}
	}
	
    /**
     * Testing create Malaysia money.
     * It can get values, currency and information.
     */
	public static void testCreateMalayMoney() {
		setFactory(new MalayMoneyFactory());
		MoneyFactory factory3 = MoneyFactory.getInstance();
		System.out.println("factory3 is a "+factory3.getClass().getName());
		MoneyFactory factory4 = MoneyFactory.getInstance();
		System.out.println("factory4 is a "+factory4.getClass().getName());
		System.out.println("factory1 is equals to factory2 (same object?)");
		System.out.println(factory3 == factory4);
		String[] values = {"0.05","0.1","0.2","0.5","1","2","5","10","20","50","100"};
		for(String arg : values) {
			Valuable v = factory3.createMoney(arg);
			System.out.println("Moneys" +arg);
			System.out.printf("createMoney(%s) = %s%n",arg,v);
			//try to getting information of coin
			System.out.printf("getCurrency(%s) = %s%n",arg,v.getCurrency());
			System.out.printf("getValue(%s) = %s%n",arg,v.getValue());
			System.out.printf("toString(%s) = %s%n",arg,v.toString());
			System.out.println("--------------------------");
		}
	}
	
    /**
     * Testing create invalid money can't create.
     */
	public static void testCantCreateMoney() {
		setFactory(new MalayMoneyFactory());
		String[] values = {"0.8","0.7","1.2","80","300"};
		MoneyFactory factory5 = MoneyFactory.getInstance();
		for(String arg: values) {
			System.out.printf("createMoney(%s) is",arg);
			try {
				Valuable v = factory5.createMoney(arg);
				//try to getting information of coin
				System.out.printf("toString(%s) getValue(%s) getCurrency(%s)",v.toString(), v.getCurrency(), v.getValue());
				System.out.println();
			}
			catch(IllegalArgumentException ex) {
				System.out.println(ex.getMessage());
			}
			catch(NullPointerException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	
    /**
     * Testing aspect values for create money.
     * There are test equals and compareTo.
     */
	public static void testAspectResult() {
		setFactory(new ThaiMoneyFactory());
		MoneyFactory factoryequal = MoneyFactory.getInstance();
		double value = 5;
		double valuesame = 5;
		double valuenotsame = 10;
		Valuable v = factoryequal.createMoney(value);
		Valuable w = factoryequal.createMoney(valuesame);
		Valuable x = factoryequal.createMoney(valuenotsame);
		System.out.println("v = 5");
		System.out.println("w = 5");
		System.out.println("x = 10");
		System.out.println("v == w? aspect: true");
		System.out.println("Result"+v.equals(w));
		System.out.println("v == x? aspect: false");
		System.out.println("Result"+v.equals(x));
		System.out.println("v before w? aspect: same value (0)");
		System.out.println("Result"+v.compareTo(w));
		System.out.println("v before x? aspect: yes value (1)");
		System.out.println("Result"+v.equals(x));
		System.out.println("We aspect v must have same currency with x");
		System.out.println("Result: "+v.getCurrency().equals(x.getCurrency()));
		System.out.println("We aspect v must not have same currency with x");
		System.out.println("Result: "+(v.getValue()==x.getValue()));
	}
	
	

}
