import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Poker extends JFrame implements ActionListener{
	JPanel main_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JPanel card_panel = new JPanel();
	JPanel option_panel = new JPanel();
	JButton draw = new JButton("Start New Game");
	JButton finish = new JButton("Finish");
	JButton change1 = new JButton("Change");
	JButton change2 = new JButton("Change");
	JButton change3 = new JButton("Change");
	JButton change4 = new JButton("Change");
	JButton change5 = new JButton("Change");
	
	JLabel card1 = new JLabel();		//Stores the image of the card the user has
	JLabel card2 = new JLabel();
	JLabel card3 = new JLabel();
	JLabel card4 = new JLabel();
	JLabel card5 = new JLabel();
	JLabel message = new JLabel();
	
	Card hand1 = new Card(null, null, 0, 0);	//Stores the actual Card object the user has
	Card hand2 = new Card(null, null, 0, 0);
	Card hand3 = new Card(null, null, 0, 0);
	Card hand4 = new Card(null, null, 0, 0);
	Card hand5 = new Card(null, null, 0, 0);
	
	Deck new_deck = null;
	
	int changes_count = 0;
	int max_changes = 3; 
	
	JLabel outcome = new JLabel();
	JLabel score = new JLabel();
	ImageIcon card = new ImageIcon();	
	
	Poker(){
		super("Poker");
		setBounds(250, 150, 800, 450);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Container con = this.getContentPane();

    	//Add the buttons
    	change1.addActionListener(this);
    	button_panel.add(change1);
    	change2.addActionListener(this);
    	button_panel.add(change2);
    	change3.addActionListener(this);
    	button_panel.add(change3);
    	change4.addActionListener(this);
    	button_panel.add(change4);
    	change5.addActionListener(this);
    	button_panel.add(change5);
    	
    	//Add the labels
    	card_panel.add(card1);
    	card_panel.add(card2);
    	card_panel.add(card3);
    	card_panel.add(card4);
    	card_panel.add(card5);
    	
		card_panel.setLocation(0,0);
		card_panel.setSize(800,225);
		main_panel.add(card_panel);

		button_panel.setLocation(400,200);
		button_panel.setSize(800, 175);
		main_panel.add(button_panel);
		
		option_panel.setLocation(600,200);
		button_panel.setSize(800, 40);
    	
    	draw.addActionListener(this);
    	option_panel.add(draw);
    	
    	finish.addActionListener(this);
    	option_panel.add(finish);
    	option_panel.add(message);
    	main_panel.add(option_panel);
    	con.add(main_panel);
    	setVisible(true);	
	}
	
	public static Deck newGame(){
		Deck new_deck = new Deck();
		new_deck.shuffle();
		return new_deck;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		
		if (source == draw){
			new_deck = new Deck();
			new_deck.shuffle();
			hand1 = new_deck.drawCard();
			hand2 = new_deck.drawCard();
			hand3 = new_deck.drawCard();
			hand4 = new_deck.drawCard();
			hand5 = new_deck.drawCard();
			
			changes_count = 0;
			message.setText("Change up to three cards");
			//current_score = 0;
			BufferedImage card = new_deck.showCard(hand1.png_num);	//Pass the PNG number of the top card to display it               
			ImageIcon im = new ImageIcon(card);
			card1.setIcon(im);

		
			card = new_deck.showCard(hand2.png_num);	//Pass the PNG number of the top card to display it               
			im = new ImageIcon(card);
			card2.setIcon(im);
			
			card = new_deck.showCard(hand3.png_num);	//Pass the PNG number of the top card to display it               
			im = new ImageIcon(card);
			card3.setIcon(im);
			
			card = new_deck.showCard(hand4.png_num);	//Pass the PNG number of the top card to display it               
			im = new ImageIcon(card);
			card4.setIcon(im);
			
			card = new_deck.showCard(hand5.png_num);	//Pass the PNG number of the top card to display it               
			im = new ImageIcon(card);
			card5.setIcon(im);
		}
		
		if(source == change1){
			hand1 = new_deck.drawCard();
			changes_count++;
			if(changes_count == max_changes){
				message.setText("You can only make 3 changes");
			}
			BufferedImage card = new_deck.showCard(hand1.png_num);	//Pass the PNG number of the top card to display it               
			ImageIcon im = new ImageIcon(card);
			card1.setIcon(im);	
		}
		
		if(source == change2){
			hand2 = new_deck.drawCard();
			changes_count++;
			if(changes_count == max_changes){
				message.setText("You can only make 3 changes");
			}
			BufferedImage card = new_deck.showCard(hand2.png_num);	//Pass the PNG number of the top card to display it               
			ImageIcon im = new ImageIcon(card);
			card2.setIcon(im);
		}
		
		if(source == change3){
			hand3 = new_deck.drawCard();
			changes_count++;
			if(changes_count == max_changes){
				message.setText("You can only make 3 changes");
			}
			BufferedImage card = new_deck.showCard(hand3.png_num);	//Pass the PNG number of the top card to display it               
			ImageIcon im = new ImageIcon(card);
			card3.setIcon(im);	
		}
		
		if(source == change4){
			hand4 = new_deck.drawCard();
			changes_count++;
			if(changes_count == max_changes){
				message.setText("You can only make 3 changes");
			}
			BufferedImage card = new_deck.showCard(hand4.png_num);	//Pass the PNG number of the top card to display it               
			ImageIcon im = new ImageIcon(card);
			card4.setIcon(im);	
		}
		
		if(source == change5){
			hand5 = new_deck.drawCard();
			changes_count++;
			if(changes_count == max_changes){
				message.setText("You can only make 3 changes");
			}
			BufferedImage card = new_deck.showCard(hand5.png_num);	//Pass the PNG number of the top card to display it               
			ImageIcon im = new ImageIcon(card);
			card5.setIcon(im);	
		}
		
		if(source == finish){
			new_deck = new Deck();
			String[] face_values = {hand1.face,hand2.face,hand3.face,hand4.face,hand5.face};
			String[] suit_values = {hand1.suit,hand2.suit,hand3.suit,hand4.suit,hand5.suit};
			int[] numeric_values = new int[5];
			
			// Loop to assign the numeric values.
			for(int x=0; x<5; x++){
				String value = face_values[x];
				switch(value){
				case "Ace": numeric_values[x] = 14;
				break;
				case "King": numeric_values[x] = 13;
				break;
				case "Queen": numeric_values[x] = 12;
				break;
				case "Jack": numeric_values[x] = 11;
				break;
				case "Ten": numeric_values[x] = 10;
				break;
				case "Nine": numeric_values[x] = 9;
				break;
				case "Eight": numeric_values[x] = 8;
				break;
				case "Seven": numeric_values[x] = 7;
				break;
				case "Six": numeric_values[x] = 6;
				break;
				case "Five": numeric_values[x] = 5;
				break;
				case "Four": numeric_values[x] = 4;
				break;
				case "Three": numeric_values[x] = 3;
				break;
				case "Two": numeric_values[x] = 2;
				break;
				}
			}
			
			//Loop to order the players hand in numerically, Suit has to be changed also
			int value_holder;
			String suit_holder;			

			for(int i=0; i<5; i++){
				for(int j=i+1; j<5; j++){
					// If the card up one position is lower then switch them
					if (numeric_values[i]>numeric_values[j]){
						value_holder = numeric_values[i];
						suit_holder = suit_values[i]
;						numeric_values[i] = numeric_values[j];
						numeric_values[j] = value_holder;
						suit_values[i] = suit_values[j];
						suit_values[j] = suit_holder;						
						}
				}
			}
				
			// Check for a flush and a straight
			boolean flush = true;			//Taken as true until one case will switch if to false if found
			boolean straight = true;		//Taken as true until one case will switch if to false if found
			
			//Flush Check
			for(int x=0; x<4; x++){
				if(!suit_values[x].equals(suit_values[x+1])){
					flush = false;
				}
			}
			
			//Straight check
			for(int x=4; x>0; x--){
				//Check for two and Ace appearing opposite sides of the hand as the ace can then be used as 1
				if(numeric_values[4] == 14 && numeric_values[0]== 2){
					x--; // If ace is there ignore this card so it will only check the remaining 4 cards as the two and Ace are matched
				}
				if((numeric_values[x]-numeric_values[x-1]) != 1){
					straight = false;
				}
			}		
			
			boolean pair = false;
			int count_matches = 0;
			
			for(int x=0; x<5; x++){
				for(int y=x+1; y<5; y++){
					if(face_values[x].equals(face_values[y])){
						pair = true;
						count_matches++;
					}
				}

			}	
			
			if(flush && straight && numeric_values[4]==14){
				message.setText("Royal Flush");
			}else if(flush && straight){
				message.setText("Stright Flush");
			}else if(count_matches>4){
				message.setText("Poker (4 of a kind)");
			}//need to add full house
			else if(flush){
				message.setText("Flush");
			}else if(straight){
				message.setText("Straight");
			}else if(count_matches>3){
				message.setText("Three of a Kind");
			}else if(pair){
				message.setText("Pair");
			}

			//check for flush
			if(hand1.suit.equals(hand2.suit) && hand1.suit.equals(hand3.suit) && hand1.suit.equals(hand4.suit) && hand1.suit.equals(hand5.suit)){
					
			}	
		}	
	}
}
