import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Card {
	String suit;
	String face;
	int png_num;
	int value;			
	
	// Constructor for card must read in two strings one for the face and one for the suit
	public Card(String suit, String face, int value, int png_num){
		this.suit = suit;
		this.face = face;
		this.value = value;
		this.png_num = png_num;
	}
	
	public void showCard(int png_num){
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("pics/" + png_num + ".png"));
		} catch (IOException e) {
		}
		System.out.println("The " + face + " of " + suit);
	}
}
