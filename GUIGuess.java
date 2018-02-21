import java.awt.Color;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.util.Random;

@SuppressWarnings("serial")
public class GUIGuess extends JFrame{
	
	public JLabel label1, labelGuess, randomNo, labelRandom, 
	labelCorrect, labelHiLo, labelTries, labelDel;	
	public JTextField textField1;
	public final JButton replay, showAnswer;
	int rand = getRandom();
	
	public GUIGuess(){
		
		super("Guess the number!");
		setLayout(new FlowLayout());
		
		// label for random number
		randomNo = new JLabel("");
		add(randomNo); 
		
		// label for prompt
		label1 = new JLabel("I have a number between 1 and 1000. "
				+ "Can you guess my number? \n");
		add(label1);
		
		// label for first guess
		labelGuess = new JLabel("Please enter your first guess.\n");	
		add(labelGuess);
		
		// text field
		textField1 = new JTextField(5);
		add(textField1);
		
		// button for replay option
		replay = new JButton("Play again");
		add(replay);
		
		// label for color
		labelHiLo = new JLabel();
		add(labelHiLo);
		
		// label for random
		labelRandom = new JLabel("");
		add(labelRandom);
		
		// label for the amount of tries
		labelTries = new JLabel("");
		add(labelTries);
		
		// button for the answers
		showAnswer = new JButton("Answer");
		add(showAnswer);
		
		// handler for the textfield
		GuessHandler handler = new GuessHandler();
		textField1.addActionListener(handler);
		
	}
	
	// getRandom returns a random between 1 and a 1000
	public int getRandom(){
		
		Random rand = new Random(); // rand function
		int n = rand.nextInt(1000 - 1 + 1) + 1;
		
		return n;
	}
	
	// inner GuessHandler class
	private class GuessHandler implements ActionListener{
		
		private int tries = 0; // number of attempts
		
		public void actionPerformed(ActionEvent event){
			
			int num; // user's input
			
			if(event.getSource() == textField1){ // input is compared
				tries++;
			showAnswer.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){					
					randomNo.setText(" **Ans: "+String.valueOf(rand)+"** ");									
				}
			});	
			
			// to make the "Play Again" button work
			replay.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){	
					tries = 0;																	
					rand = getRandom();															   										
					
					textField1.setEditable(true); // textField is made editable												
					
					// use of setText
					textField1.setText("");														
					randomNo.setText("");												
					labelHiLo.setText("");														
					labelRandom.setText("");													
					labelTries.setText("");														
					
	                // background back to normal    	
					getContentPane().setBackground(null);										 
				}
			}); 
			
			// num is inputted
			num = Integer.parseInt(textField1.getText());										
			
			if(num == rand){ // if the guess is correct																	
				labelHiLo.setText("Correct!");														
				labelRandom.setText("The number was "+String.valueOf(rand)+".\n");					
				labelTries.setText("It took "+tries+" attempts.");									
				textField1.setEditable(false); // textfield is made uneditable														
			}else if(num > rand){																
				labelHiLo.setText("Too High");														
				getContentPane().setBackground(Color.RED); // background becomes red if guess is too high											
			}else if(num < rand){																
				labelHiLo.setText("Too Low");													
				getContentPane().setBackground(Color.BLUE); // background becomes blue if guess is too low
			}
		} // end event
	}// end actionPerformed()
}// end GuessHandler		
	
} // GUIGuess

