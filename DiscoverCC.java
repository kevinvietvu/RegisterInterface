
public class DiscoverCC extends CreditCard {

	public DiscoverCC(String cardNumber) {
		super(cardNumber);
		// TODO Auto-generated constructor stub
	}
	
	// 	First four digits are 6011. Length is 16 digits.
	public static boolean validateCard(CreditCard c)
	{
		if (c.cardNumber.substring(0,4).equals("6011") && c.cardNumber.length() == 16)
		{
			return true;
		}
		return false;
	}
	
	public static void main(String args[])
	{
		
		System.out.println(DiscoverCC.validateCard(new CreditCard("6011412356789123")));
	}

}
