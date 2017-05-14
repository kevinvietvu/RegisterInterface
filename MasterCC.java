
public class MasterCC extends CreditCard {

	public MasterCC(String cardNumber) {
		super(cardNumber);
		// TODO Auto-generated constructor stub
	}
	
	// 	First digit is a 5, second digit is in range 1 through 5 inclusive. Only valid lenght of number is 16 digits.
	public static boolean validateCard(CreditCard c)
	{
		if (c.cardNumber.substring(0,1).equals("5") && c.cardNumber.length() == 16)
		{
			int secondDigit = Integer.parseInt(c.cardNumber.substring(1,2));
			if (secondDigit <= 5 && secondDigit >= 1)
			{
				return true;
			}
		}
		return false;
	}
	
	public static void main(String args[])
	{
		
		System.out.println(MasterCC.validateCard(new CreditCard("5211412356789123")));
	}

}
