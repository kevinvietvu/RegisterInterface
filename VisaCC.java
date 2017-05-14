
public class VisaCC extends CreditCard {

	
 	public VisaCC(String cardNumber) {
		super(cardNumber);
		// TODO Auto-generated constructor stub
	}
 	
	//	First digit is a 4. Length is either 13 or 16 digits.
	public static boolean validateCard(CreditCard c)
	{
		if (c.cardNumber.substring(0,1).equals("4"))
		{
			int secondDigit = c.cardNumber.length();
			if (secondDigit == 13 || secondDigit == 16)
			{
				return true;
			}
		}
		return false;
	}
	
	public static void main(String args[])
	{
		System.out.println(VisaCC.validateCard(new CreditCard("4311412356789")));
	}
}
