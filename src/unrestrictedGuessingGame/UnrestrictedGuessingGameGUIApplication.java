package unrestrictedGuessingGame;

import javax.swing.JFrame;

/**
 * UnrestrictedGuessingGameGUIApplication is the class to test out the unrestricted guessing game.
 * 
 * @author Xueying Xu (Shirley)
 * @version Final Project
 */
public class UnrestrictedGuessingGameGUIApplication {

	   /**
		* Creates a JFrame that holds the UnrestrictedGuessingGameGUIController.
		* 
		* @param args
		**/
	    public static void main(String[] args) {
				
		    JFrame guiFrame = new JFrame( "Unrestricted Guessing Game" );
						
			guiFrame.setSize( 1200, 800 );

		    guiFrame.add( new UnrestrictedGuessingGameGUIController() );
						
			// Exit normally on closing the window
			guiFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

			// Show frame
			guiFrame.setVisible( true );
						
	    }

}


