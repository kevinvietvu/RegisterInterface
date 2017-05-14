
public class CreditCard {
	protected String cardNumber;
	private final static int maxLength = 19;
	
	public CreditCard(String cardNumber)
	{
		this.cardNumber = cardNumber;
	}
	
	private static boolean validateCard(CreditCard c)
	{
		if (c.cardNumber.length() <= maxLength)
		{
			return true;
		}
		return false;
	}
	
	public static void main(String args[])
	{
		
		System.out.println(validateCard(new CreditCard("6011412356789123")));
	}
	
	
}
