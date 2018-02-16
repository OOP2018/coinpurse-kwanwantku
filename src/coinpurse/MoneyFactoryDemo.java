package coinpurse;

public class MoneyFactoryDemo {
	
	public static void main(String [] args) {
		MoneyFactory factory1 = MoneyFactory.getInstance();
		System.out.println("factory1 is a "+factory1.getClass().getName());
		MoneyFactory factory2 = MoneyFactory.getInstance();
		System.out.println("factory2 is a "+factory2.getClass().getName());
		System.out.println("factory1 is equals to factory2 (same object?)");
		System.out.println(factory1 == factory2);
		String[] values = {"0.25","0.5","1","5","10","20","50","100","50","1000"};
		for(String arg : values) {
			Valuable v = factory1.createMoney(arg);
			System.out.printf("createMoney(%s) = %s%n",arg,v);
			System.out.printf("getValue(%s) = %s%n",arg,v.getValue());
			System.out.printf("getCurrency(%s) = %s%n",arg,v.getCurrency());
			System.out.printf("toString(%s) = %s%n",arg,v.toString());
		}
		
	}
}
