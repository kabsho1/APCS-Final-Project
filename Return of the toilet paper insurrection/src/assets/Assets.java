package assets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import assets.map.EasiestLevel;
import assets.map.EnemyRoom;
import assets.map.Level0;
import assets.map.Level1;
import assets.map.Level2;
import assets.map.Level3;
import assets.map.Map;
import assets.map.Maze1;
import assets.map.Room1;
import assets.map.Room2;
import running.GameHandler;
/**
 * This singleton class contains all of the assets 
 * of the project including images, SpriteSheets, and maps
 * @author Kabir Batra & Kaie Chen
 *
 */
public class Assets {
	
	GameHandler handler;
	public static HashMap<String, BufferedImage> images;
	public static HashMap<String, Map> maps;
	
	public static HashMap<String, SpriteSheet> spriteSheets;


	/**
	 * Initializes all of the assets by grabbing them from the assets folder
	 * @param handler is used for creating new maps
	 */
	public Assets(GameHandler handler) {
		images = new HashMap<String, BufferedImage>();
		maps = new HashMap<String, Map>();
		spriteSheets = new HashMap<String, SpriteSheet>();
		

		// images
		images.put("bigTestRoom", loadImage("bigroom.png"));
		images.put("littleTestRoom", loadImage("room.png"));
		images.put("mazeTest", loadImage("mediumMaze.png"));
		images.put("enemyRoomTest", loadImage("basicMap.png"));
		images.put("player", loadImage("playerSheet.png"));
		images.put("slime", loadImage("slimeSheet.png"));
		images.put("tiles", loadImage("tileSheet.png"));
		images.put("roll", loadImage("roll.png"));
		images.put("normalBullet", loadImage("spinningRoll.png"));
		images.put("Level1", loadImage("Level1.png"));
		images.put("Level0", loadImage("Level0.png"));
		images.put("easylevel", loadImage("EasiestLevel.png"));
		images.put("Level2", loadImage("Level2.png"));
		images.put("Level3", loadImage("Level3.png"));
		images.put("EnemyBoss", loadImage("EnemyBoss.png"));
		
		spriteSheets.put("playerSheet", new SpriteSheet(images.get("player")));
		spriteSheets.put("slimeSheet", new SpriteSheet(images.get("slime")));
		spriteSheets.put("tileSheet", new SpriteSheet(images.get("tiles")));
		spriteSheets.put("normalBulletSheet", new SpriteSheet(images.get("normalBullet")));
		spriteSheets.put("BossSheet", new SpriteSheet(images.get("EnemyBoss")));
		
		// maps
		//maps.put("testRoom", new Map(getBufferedImage("bigTestRoom"), new SpriteSheet("testRoomSpriteSheet"), handler));
		maps.put("testRoom", new Room1(handler, spriteSheets.get("tileSheet")));
		maps.put("testRoom2", new Room2(handler, spriteSheets.get("tileSheet")));
		maps.put("testRoom3", new Maze1(handler, spriteSheets.get("tileSheet")));
		maps.put("testRoom4", new EnemyRoom(handler, spriteSheets.get("tileSheet")));
		maps.put("Level1", new Level1(handler, spriteSheets.get("tileSheet")));
		maps.put("Level0", new Level0(handler, spriteSheets.get("tileSheet")));
		maps.put("easylevel", new EasiestLevel(handler, spriteSheets.get("tileSheet")));
		maps.put("Level2", new Level2(handler, spriteSheets.get("tileSheet")));
		maps.put("Level3", new Level3(handler, spriteSheets.get("tileSheet")));
		
		
	}
	
	private BufferedImage loadImage(String path) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getClassLoader().getResource(path));
		} catch (IOException e) {
			System.out.println("image load unsuccessful");
			e.printStackTrace();
		}
		return image;
	}
	
	/**
	 * @param name A string representing the name of an image defined in the Assets constructor
	 * @return BufferedImage The image with that name; returns null if the image does not exist
	 */
	public static BufferedImage getBufferedImage(String name) {
		return images.get(name);
	}
	/**
	 * @param name A string representing the name of a map defined in the Assets constructor
	 * @return Map The map with that name; returns null if the map does not exist
	 */
	public static Map getMap(String name) {
		return maps.get(name);
	}
	/**
	 * @param name A string representing the name of a SpriteSheet defined in the Assets constructor
	 * @return SpriteSheet The SpriteSheet with that name; returns null if the SpriteSheet does not exist
	 */
	public static SpriteSheet getSpriteSheet(String name) {
		return spriteSheets.get(name);
	}
}

