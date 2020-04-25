import processing.core.PApplet;

public abstract class GameObject {
	
	protected float posX, posY;
	String name;
	
	public GameObject(float x, float y, String name) {
		posX = x;
		posY = y;
		this.name = name;
	}
	
	
	// every frame
	public abstract void act();
	// act should call this
	public abstract void drawSelf(float x, float y, float tileWidth, float tileHeight, PApplet s);
	// when 2 game objects are touching
	public abstract void onInteract(GameObject obj);
	
	public float getPosX() {
		return posX;
	}
	
	public float getPosY() {
		return posY;
	}
	
}
