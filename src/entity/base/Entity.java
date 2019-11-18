package entity.base;

public abstract class Entity {
	
	public Entity() {
		setGc();
		setPosition();
	}
	
	
	public abstract void setGc();
	
	public abstract void setPosition();
	
	
	
}