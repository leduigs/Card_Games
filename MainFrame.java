import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class MainFrame extends JFrame implements ActionListener{
	Deck test_deck = new Deck();
	Card next_card = test_deck.drawCard();
	JPanel front_screen = new JPanel();
	JButton high_low = new JButton("Play Higher or Lower");
	JButton poker = new JButton("Play Poker");
	//Create and set up the window.
    MainFrame(){
    	super("Main Menu");
    	setBounds(250, 150, 600, 300);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Container con = this.getContentPane();
    	con.add(front_screen);
    	high_low.setMnemonic('D');		//This assigns a hotkey to use with alt
    	high_low.addActionListener(this);
    	front_screen.add(high_low); 
    	high_low.requestFocusInWindow();	//This makes the button highlighted by default
    	poker.addActionListener(this);
    	front_screen.add(poker); 
    	
    	setVisible(true);	
    }
    public void actionPerformed(ActionEvent event)
    {
      Object source = event.getSource();
      if (source == high_low){
    	  dispose();
    	  new HigherLower();
      }
      if (source == poker){
    	  dispose();
    	  new Poker();
      }

    }
        
    	public static void main(String[] args) {   
    		new MainFrame();
        //Create a button and add it to the Frame
        
       // deal.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("Test");
//				
//			}
//		});
//        front_screen.add(deal);
//        
//        
//        //Create a new Deck, then shuffle it
//        Deck test_deck = new Deck();
//        test_deck.shuffle();
//        
//        //Draw the top card of the deck
//        Card next_card = test_deck.drawCard();
//              
//        //Create the Image -> Then pass this to an ImageIcon type and add it to a JLabel
//        BufferedImage card = test_deck.showCard(next_card.png_num);	//Pass the PNG number of the top card to display it               
//        ImageIcon im = new ImageIcon(card);
//        
//        JLabel card_pic = new JLabel();
//        card_pic.setIcon(im);
//        front_screen.add(card_pic, BorderLayout.NORTH);
//
//        frame.getContentPane().add(front_screen);
//        //Display the window.
//        frame.pack();
//        frame.
	}

}
