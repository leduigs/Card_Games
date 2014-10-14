import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class HigherLower extends JFrame implements ActionListener{
	JPanel front_screen = new JPanel();
	JButton draw = new JButton("Start New Game");
	JButton higher = new JButton("Higher");
	JButton lower = new JButton("Lower");
	JLabel card_pic = new JLabel();
	JLabel outcome = new JLabel();
	JLabel score = new JLabel();
	ImageIcon card = new ImageIcon();	
	
	Deck test_deck = new Deck();
	Card next_card = null;
	int current_score = 0;
	
	HigherLower() {
		super("Higher or Lower");
		setBounds(250, 150, 600, 300);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Container con = this.getContentPane();
    	con.add(front_screen);
    	draw.addActionListener(this);
    	front_screen.add(draw);
    	higher.addActionListener(this);
    	front_screen.add(higher);
    	lower.addActionListener(this);
    	front_screen.add(lower);
    	front_screen.add(card_pic);
    	front_screen.add(outcome);
    	front_screen.add(score);
    	setVisible(true);	
	}
	
	
	public void actionPerformed(ActionEvent event){		
		test_deck.shuffle();
		Card previous_card = next_card;
		next_card = test_deck.drawCard();
		
		Object source = event.getSource();
		if (source == draw){
			current_score = 0;
			BufferedImage card = test_deck.showCard(next_card.png_num);	//Pass the PNG number of the top card to display it               
			ImageIcon im = new ImageIcon(card);
			card_pic.setIcon(im);
			outcome.setText("Higher or Lower");
			System.out.println("First Card is the " + next_card.face + " of " + next_card.suit);
			score.setText(null);
		}
		
		if (source == higher){
			BufferedImage card = test_deck.showCard(next_card.png_num);	//Pass the PNG number of the top card to display it               
			ImageIcon im = new ImageIcon(card);
			card_pic.setIcon(im);
			System.out.println("The " + next_card.face + " of " + next_card.suit);
			
			if(previous_card.value > next_card.value){
				outcome.setText("Hard Luck, please start again");
				score.setText("Final Score:" + current_score);
			}else{
				outcome.setText("Well Done!");
				current_score+=5;
				score.setText("Current Score:" + current_score);
			}
			
		}
		
		if (source == lower){
			BufferedImage card = test_deck.showCard(next_card.png_num);	//Pass the PNG number of the top card to display it               
			ImageIcon im = new ImageIcon(card);
			card_pic.setIcon(im);
			System.out.println("The " + next_card.face + " of " + next_card.suit);
			
			if(previous_card.value < next_card.value){
				outcome.setText("Hard Luck, please start again");
				score.setText("Final Score:" + current_score);
			}else{
				outcome.setText("Well Done!");
				current_score+=5;
				score.setText("Current Score:" + current_score);
			}
		}
		
	}
    }
    

