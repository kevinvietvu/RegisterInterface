
public class MenuItem implements Item {
	private String item;
	private double price;
	public MenuItem(String item, double price)
	{
		this.item = item;
		this.price = price;
	}
	
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return item;
	}
	
	@Override
	public double price() {
		// TODO Auto-generated method stub
		return price;
	}
	
	@Override
	public void print()
	{
		System.out.println(this.name() + " | " + this.price());
	}
	
}
