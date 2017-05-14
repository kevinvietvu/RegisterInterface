
public class AmExCC extends CreditCard {

	public AmExCC(String cardNumber) {
		super(cardNumber);
		// TODO Auto-generated constructor stub
	}
	
	//  First digit is a 3 and second digit a 4 or 7. Length is 15 digits.
	public static boolean validateCard(CreditCard c)
	{
		if (c.cardNumber.substring(0,1).equals("3") && c.cardNumber.length() == 15)
		{
			String secondDigit = c.cardNumber.substring(1,2);
			if (secondDigit.equals("4") || secondDigit.equals("7"))
			{
				return true;
			}
		}
		return false;
	}
	
	public static void main(String args[])
	{
		System.out.println(AmExCC.validateCard(new CreditCard("341141235678912")));
	}

}
