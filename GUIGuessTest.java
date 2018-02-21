// Frame is declared outside the class
import javax.swing.JFrame;

public class GUIGuessTest { // class is declared
	public static void main(String[] args){
	
		GUIGuess test = new GUIGuess(); // object is created
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setSize(500, 150);
		test.setVisible(true);
	}
	
} // end class