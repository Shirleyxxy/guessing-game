package guessingGame;
import javax.swing.JFrame;

/**
 * GuessingGameGUIApplication is the class to test out the guessing game.
 * 
 * @author Xueying Xu (Shirley)
 * @version Final Project
 */

public class GuessingGameGUIApplication {

   /**
	* Creates a JFrame that holds the GuessingGameGUIController.
	* 
	* @param args
	**/
    public static void main(String[] args) {
			
	    JFrame guiFrame = new JFrame( "Guessing Game" );
					
		guiFrame.setSize( 1200, 800 );

	    guiFrame.add( new GuessingGameGUIController() );
					
		// Exit normally on closing the window
		guiFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		// Show frame
		guiFrame.setVisible( true );
					
    }

}

	
	
	
	

