package window;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import running.WindowHandler;

/*
 * The Pause Menu of the game
 * @author Kaie Chen
 */
public class PauseWindow extends Window {

	private static PImage toiletPaper;
	
	public PauseWindow(WindowHandler wh, PApplet surface) {
		super(wh, surface);
	}

	PFont zigBlack;

	public void setup() {
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(getClass().getClassLoader().getResource("toiletPaper.png"));
		} catch (IOException e) {
			System.out.println("image load unsuccessful");
			e.printStackTrace();
		}
		toiletPaper = new PImage((java.awt.Image)img);

		s.background(0);
		s.fill(0);
		s.noStroke();

		zigBlack = s.createFont("Ziggurat-Black", 32);
		s.textFont(zigBlack);

	}

	float rectX, rectY, rectX2, rectY2, width, height;
	boolean overButton1 = false, overButton2 = false;

	public void draw() {
		width = s.width;
		height = s.height;

		s.fill(173, 0, 0);
		s.textAlign(s.CENTER);
		s.textSize(50);

		// This is the text
		s.text("Game is Paused", width / 2, height / 2);

		overButton1 = overButton(rectX, rectY, s.mouseX, s.mouseY, width / 4, height / 4);
		overButton2 = overButton(rectX2, rectY2, s.mouseX, s.mouseY, width / 4, height / 4);
		// this changes the color

		s.stroke(173, 0, 0);

		// Button 1
		s.fill(180);
		if (overButton1) {

			s.fill(90);

		}

		rectX = width / 8f;
		rectY = height * (8f / 10);
		s.rect(rectX, rectY, width / 4, height / 10);

		/////////////

		// Button 2

		s.fill(180);
		if (overButton2) {

			s.fill(90);

		}

		rectX2 = width * 5 / 8f;
		rectY2 = height * (8f / 10);
		s.rect(rectX2, rectY2, width / 4, height / 10);

		s.fill(173, 0, 0);
		s.textSize(20);
		s.text("Continue", rectX + width / 8, rectY + height / 20);
		s.text("Quit", rectX2 + width / 8, rectY2 + height / 20);
	
		
		
		// I tried to use the void ousePresed() as in processing, but it didn't work so this is probably going to
		// be the solution
		if (s.mousePressed && s.mouseButton == s.LEFT && overButton1) {
			System.out.println("LETS A GOOOO");
			
			// Resume game
			wh.setCurrentWindow("game");

		}
		if (s.mousePressed && s.mouseButton == s.LEFT && overButton2) {
			System.out.println("Weak");
			System.exit(0);
		}

	}

	boolean overButton(float rectX3, float rectY3, float mouseX, float mouseY, float f, float g) {
		if (mouseX >= rectX3 && mouseX <= rectX3 + f && mouseY >= rectY3 && mouseY <= rectY3 + g) {
			return true;
		} else {
			return false;
		}
	}

}
