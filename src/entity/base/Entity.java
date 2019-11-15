package entity.base;

public abstract class Entity {
	public Entity() {
		
	}
	
	public abstract void setGc();
	
	public abstract void setSpawnPosition();
	
	public abstract void move();
}
