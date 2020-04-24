import java.util.LinkedList;

import processing.core.PApplet;

public class WindowHandler {
	
	public static final int GAME_WINDOW = 0;
	
	private PApplet s;
	private LinkedList<Window> windows;
	
	private int currentWindow;


	public WindowHandler(PApplet surface) {
		s = surface;
		windows = new LinkedList<Window>();
		currentWindow = 0;

	}
	
	// windows stuff
	public void addWindow(Window w) {
		windows.add(w);
	}
	
	public Window getCurrentWindow() {
		return windows.get(currentWindow);
	}
	
	public void switchWindow(int windowIndex) {
		currentWindow = windowIndex;
	}

}