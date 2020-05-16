package window;

import processing.core.PApplet;
import processing.core.PFont;

/*
 * The Main Menu of the game
 * @author Kaie Chen
 */
public class MenuWindow extends Window {

	public MenuWindow(PApplet surface) {
		super(surface);
	}

	PFont zigBlack;

	public void setup() {

		s.background(0);
		s.fill(0, 255, 180);
		s.noStroke();

		zigBlack = s.createFont("Ziggurat-Black", 32);
		s.textFont(zigBlack);

	}

	float rectX, rectY, rectX2, rectY2, width, height;
	boolean overButton1 = false, overButton2 = false;

	public void draw() {

		width = s.width;
		height = s.height;

		// System.out.println(width + " " + height);

		// this is the toliet paper
		s.fill(255);

		s.stroke(0);
		s.ellipse(width / 2, height / 2 + 80, width / 6, height / 12);

		s.noStroke();
		s.rect(width / 2 - 50, height / 2, width / 6, height / 7.5f);

		s.stroke(0);
		s.ellipse(width / 2, height / 2, width / 6, height / 12);

		s.stroke(128, 108, 81);
		s.fill(173, 135, 98);
		s.ellipse(width / 2, height / 2, width / 24, height / 50);

		s.fill(173, 0, 0);
		s.textAlign(s.CENTER);
		s.textSize(50);

		// This is the text
		s.text("THE REVENGE \n OF THE \n TOLIET PAPER!", width / 2, height / 10);

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
		s.text("Let's Do This", rectX + width / 8, rectY + height / 20);
		s.text("Nah I am good", rectX2 + width / 8, rectY2 + height / 20);
	
		
		
		// I tried to use the void ousePresed() as in processing, but it didn't work so this is probably going to
		// be the solution
		if (s.mousePressed && s.mouseButton == s.LEFT && overButton1) {
			System.out.println("LETS A GOOOO");

			// START GAME

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
