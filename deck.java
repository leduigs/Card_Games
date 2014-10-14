import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Deck {
	Card[] deck = new Card[52];
	int position_in_deck = 0;
	
	public Deck(){
		String[] face_values = {"Ace","King","Queen","Jack","Ten","Nine","Eight","Seven","Six","Five","Four","Three","Two"};
		String[] suits = {"Clubs","Spades","Hearts","Diamonds"};
		int[] score_values = {11,10,10,10,10,9,8,7,6,5,4,3,2,1};
		
		for(int x=0,y=0; x<13; x++){
			deck[x] = new Card(suits[y], face_values[x], score_values[x], x+1);
			deck[x+13] = new Card(suits[y+1], face_values[x], score_values[x], x+14);
			deck[x+26] = new Card(suits[y+2], face_values[x], score_values[x], x+27);
			deck[x+39] = new Card(suits[y+3], face_values[x], score_values[x], x+40);
		}
	}
	
	public Card drawCard(){
		// Return the top card 
				if(position_in_deck==51){
					System.out.println("All cards dealt");
					return null;
				}
		return deck[position_in_deck++];
	}
	
	public void shuffle(){
		int counter=0;
		while(counter<50000){
			// Create 2 random ints from 0 to 52
			int shuffler1 = (int) (Math.random()*52);
			int shuffler2 = (int) (Math.random()*52);
			// Create two cards to hold the cards at the two random positions
			Card holder1 = deck[shuffler1];
			Card holder2 = deck[shuffler2];			
			// Swap the two cards positions
			deck[shuffler1] = holder2;
			deck[shuffler2] = holder1;
			
			// Count the shuffles to allow while to break
			counter++;
		}
	}
	
	public BufferedImage showCard(int png_num){
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("pics/" + png_num + ".png"));
		} catch (IOException e) {
		}
		return img;
		//System.out.println("The " + Card.face + " of " + suit);
	}

}
