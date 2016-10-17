
public class RoombaBot extends Robot {
	
	private boolean bagFull;
	private int maxCap;
	private int dirt;
	
	public RoombaBot(String name, int positionX, int positionY, int speed, int orientation, int maxCap)
	{
		
		super(name, positionX, positionY, speed, orientation);
		this.bagFull = false;
		this.maxCap = maxCap;
		this.dirt = 0;
	
	}
	
	public int getMaxCap()
	{
		return this.maxCap;
	}
	
	public int getDirt()
	{
		return this.dirt;
	}
	
	public boolean isBagFull()
	{
		return this.bagFull;
	}
	
	public void vacuum(int amount)
	{
		if (bagFull == false)
		{
			this.dirt += amount;
			if (this.dirt >= this.maxCap)
			{
				this.bagFull = true;
			}
		}
		
		
	}
	
	public void emptyBag()
	{
		this.bagFull = false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
