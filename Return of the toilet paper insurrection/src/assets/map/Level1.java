package assets.map;
import assets.Assets;
import assets.SpriteSheet;
import gameobject.Player;
import running.GameHandler;
/**
 * This is Level 1 of the game!
 * @author kaiechen
 *
 */
public class Level1 extends Map {
	/**
	 *  This generates the map with the given sprite
	 * and it adds the different creatures that needed to be added
	 * to the handler
	 * 
	 * 
	 * 
	 * @param handler The list of in-game objects
 	 * @param ss The sprite image associated with Level1
	 */
	public Level1(GameHandler handler, SpriteSheet ss) {
		super(handler);
		create(Assets.getBufferedImage("Level1"), ss);
		setPlayerStartPos();
	}

	public void populateGameObjects(Player p) {
		super.populateGameObjects(p);
	}
	
	

}
