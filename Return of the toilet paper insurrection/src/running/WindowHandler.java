package running;
import java.util.HashMap;

import processing.core.PApplet;
import window.Window;

/**
 * The class that controls and maintains the all of the different windows.
 * Windows are stored, switched, and displayed using this class.
 * @author Kabir Batra
 */
public class WindowHandler {
		
	private HashMap<String, Window> windows;
	
	private String currentWindow;
	private boolean wasPaused;
	
	public WindowHandler() {
		windows = new HashMap<String, Window>();
		currentWindow = "";
		wasPaused = false;

	}
	
	/**
	 * Adds a window to the list of windows.
	 * @param name The name of the window.
	 * @param w The window object being added.
	 */
	public void addWindow(String name, Window w) {
		if(windows.size() == 0)
			currentWindow = name;
		windows.put(name, w);
	}
	
	/**
	 * @return The current window being displayed
	 */
	public Window getCurrentWindow() {
		return windows.get(currentWindow);
	}
	
	/**
	 * Sets the current window to be drawn.
	 * @param name The name of the window added using the addWindow method.
	 */
	public void setCurrentWindow(String name) {
		currentWindow = name;
		if(name.equals("pause"))
			wasPaused = true;
	}
	
	/**
	 * 
	 * @return whether or not the previous screen was the pause screen.
	 * (utility for GameWindow)
	 */
	public boolean wasPaused() {
		boolean temp = wasPaused;
		wasPaused = false;
		return temp;
	}

}
