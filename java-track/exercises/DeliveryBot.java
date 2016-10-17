
public class DeliveryBot extends Robot {
	
	private String currentPackage;
	private boolean hasOrder;
	
	public DeliveryBot(String name, int positionX, int positionY, int speed, int orientation)
	{
		
		super(name, positionX, positionY, speed, orientation);
		this.hasOrder = false;
		this.currentPackage = "";
	
	}
	
	public String getCurrentPackage() 
	{
		return this.currentPackage;
	}
	
	public boolean doesHaveOrder()
	{
		return this.hasOrder;
	}
	
	public void getOrder(String item)
	{
		
		if(this.hasOrder == false)
		{
			this.currentPackage = item;
			this.hasOrder = true;
		}
		
	}
	
	public void deliverPackage(int x, int y)
	{
		this.positionX = x;
		this.positionY = y;
		this.currentPackage = "";
		this.hasOrder = false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
