
public class cardChecker {
	CreditCard cardToCheck;
	CreditCard cardToReturn;
	String cardType;
	public cardChecker(CreditCard c)
	{
		cardToCheck = c;
	}
	
	public CreditCard validate()
	{
		cardToReturn = null;
		if (MasterCC.validateCard(cardToCheck))
		{
			cardType = "Master Card";
			cardToReturn = new MasterCC(cardToCheck.cardNumber);
		}
		else if (AmExCC.validateCard(cardToCheck))
		{
			cardType = "American Express Card";
			cardToReturn = new AmExCC(cardToCheck.cardNumber);
		}
		else if (DiscoverCC.validateCard(cardToCheck))
		{
			cardType = "Discover Card";
			cardToReturn = new DiscoverCC(cardToCheck.cardNumber);
		}
		else if (VisaCC.validateCard(cardToCheck))
		{
			cardType = "Visa Card";
			cardToReturn = new VisaCC(cardToCheck.cardNumber);
		}
		return cardToReturn;
	}
	
	public String getCreditCardName()
	{
		return cardType;
	}
	
}
