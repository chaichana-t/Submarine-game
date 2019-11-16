package entity.base;

public abstract class Entity {
	
	public Entity() {
		setGc();
		setSpawnPosition();
	}
	
	
	public abstract void setGc();
	
	public abstract void setSpawnPosition();
	
	
}
