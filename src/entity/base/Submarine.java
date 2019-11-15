package entity.base;

public abstract class Submarine extends Entity implements Shootable{
	
	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	private boolean isAlive;
	
	public Submarine() {
		super();
		this.isAlive = true;
		
	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		
		
	}
	
	


	
	
	
}
