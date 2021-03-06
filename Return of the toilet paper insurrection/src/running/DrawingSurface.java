package running;

import processing.core.PApplet;
import window.*;

/**
 * This is the main method of the project that inherits Processing's PApplet
 * 
 * @author Kabir Batra
 */
public class DrawingSurface extends PApplet {

	private WindowHandler wh;

	/**
	 * Starts running the Processing Applet
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		System.out.println("hello world");
		PApplet.main("running.DrawingSurface");
	}

	/**
	 * Creates a WindowHandler and adds all the windows to it
	 */
	public DrawingSurface() {
		reset();
	}

	/**
	 * Settings of the Processing PApplet
	 */
	public void settings() {
		size(64 * 11, 64 * 11);
	}

	/**
	 * Calls the setup method of the current window in the WindowHandler
	 */
	public void setup() {
		surface.setResizable(true);
		surface.setTitle("Return of the the Toilet Paper Insurrection!");
		surface.setLocation(0, 0);
		wh.getCurrentWindow().setup();
	}

	/**
	 * Draws the current window of the WindowHandler
	 */
	public void draw() {

		wh.getCurrentWindow().draw();

	}

	/**
	 * Calls the keyPressed method of the current window
	 */
	public void keyPressed() {
		wh.getCurrentWindow().keyPressed();
	}

	/**
	 * Calls the keyReleased method of the current window
	 */
	public void keyReleased() {
		wh.getCurrentWindow().keyReleased();
	}

	/**
	 * 
	 * @return returns the current window handler
	 */
	public WindowHandler getWindowHandler() {
		return wh;
	}
	
	/**
	 * 
	 */
	public void reset() {
		wh = new WindowHandler();
		wh.addWindow("game", new GameWindow(wh, this));
		wh.addWindow("menu", new MenuWindow(wh, this));
		wh.addWindow("pause", new PauseWindow(wh, this));
		wh.addWindow("gameOver", new GameOverWindow(wh, this));
		wh.addWindow("instructions", new InstructionWindow(wh, this));

		wh.setCurrentWindow("menu");
	}
}
