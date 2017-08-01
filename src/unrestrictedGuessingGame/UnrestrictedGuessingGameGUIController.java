package unrestrictedGuessingGame;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import fileReader.CharactersFileReader;
import binaryTree.*;

/**
 * UnrestrictedGuessingGameGUIController is a class that interacts with users by guessing which item they selected.
 * 
 * @author Xueying Xu (Shirley)
 * @version Final Project
 */
public class UnrestrictedGuessingGameGUIController extends JPanel implements ActionListener {
		
    private CharactersFileReader reader;
	
	// The decision tree
	private BinaryTree<String> gameTree;
	
	private BinaryTreeNode<String> node;
	
	// The content can be a question or a message
	private String content = "";
	
	private JLabel contentLabel;
	
	private JButton yesButton;
	
	private JButton noButton;
	
	private JButton startButton;
	
	// the new character that is not one of the pre-specified characters
	private String newCharacter;
	
	// a question to determine the new character
	private String userQuestion;
	
	// yes/no to the question
	private String userAnswer;
	
	// a JPanel for displaying new characters
	private JPanel newCharacters;
	
	private JPanel charactersPanel;
	

	/**
	 * Constructor.
	 */
	public UnrestrictedGuessingGameGUIController() {
				
		super( new BorderLayout() );
		
		// Initialize GUI
		this.add(createImagePanel(), BorderLayout.NORTH);
		
		this.add(createCharactersPanel(), BorderLayout.CENTER);
		
		this.add(createGamePanel(), BorderLayout.SOUTH);
		
		// Build the decision tree
		reader = new CharactersFileReader();
		
		gameTree = reader.buildTree();
				
	}
	
	/**
	 * Create a JPanel for displaying the image.
	 * 
	 * @return ImagePanel
	 */
    public JPanel createImagePanel() {
    	
    	JPanel imagePanel = new JPanel();
    	
    	try {
    	    
    		// Read in the image
    		BufferedImage image = ImageIO.read( new File("Hogwarts.jpg") );
    		
    		// Create a new BufferedImage object to resize the image
    		BufferedImage newImage = new BufferedImage(1200, 300, BufferedImage.TYPE_INT_RGB);
    		
    		Graphics g = newImage.createGraphics();
    		
    		g.drawImage(image, 0, 0, 1200, 300, null);
    		
    		g.dispose();
    		
    		// Create a JLabel to contain the resized image
    		JLabel imageLabel = new JLabel( new ImageIcon(newImage) );
    		
    		// Add the JLabel to the panel
    		imagePanel.add(imageLabel);
    		
	
    	} catch (IOException ex) {
    		
    		System.out.println("There is an IO exception.");
    		
    	}
    	
    	return imagePanel;
    	
    }
	
    /**
     * Create a JPanel for displaying the pre-specified 16 characters.
     * 
     * @return charactersPanel
     */
	public JPanel createCharactersPanel() {
		
		charactersPanel = new JPanel();
		
		charactersPanel.setBackground(Color.BLACK);
		
		charactersPanel.setLayout( new BoxLayout(charactersPanel, BoxLayout.Y_AXIS) );
		
        // Create a JLabel for the title
		JLabel title = new JLabel("16 Pre-specified Characters");
		
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		title.setFont( new Font( "Helvetica", Font.BOLD, 22) );
		
		title.setForeground(Color.WHITE);
			
		// Create a JPanel for 16 characters using 4 * 4 GridLayout
		JPanel characters = new JPanel( new GridLayout(4, 4) );
		
		characters.setBackground(Color.BLACK);
		
		// An array of 16 names
		String[] names = {"Luna Lovegood", "Cedric Diggory", "Sirius Black", "Neville Longbottom",
				
				"Horace Slughorn", "Molly Weasley", "Ginny Weasley", "Cho Chang", "Hermione Granger",
				
		        "Draco Malfoy", "Lily Potter", "Albus Dumbledore", "Rubeus Hagrid", "Bellatrix Lestrange", 
		        
		        "Severus Snape", "Ron Weasley"};
		
		// Create an array of 16 JLabels
		JLabel[] labels = new JLabel[names.length];
		
		// Loop to add each name to a newly created JLabel, and add the JLabel to the JPanel
		for (int i = 0; i < labels.length; i++) {
			
			labels[i] = new JLabel(names[i]);
			
			labels[i].setFont( new Font("Helvetica", Font.BOLD, 16) );
			
			labels[i].setForeground(Color.WHITE);
			
			labels[i].setAlignmentX(CENTER_ALIGNMENT);
			
			characters.add(labels[i]);
		}
		
		// Create a JPanel for displaying new characters
        newCharacters = new JPanel( new FlowLayout(FlowLayout.LEFT) );
		
		newCharacters.setBackground(Color.BLACK);
		
		// Add title to the charactersPanel
		charactersPanel.add(title);
		
		// Add 16 characters to the charactersPanel
		charactersPanel.add(characters);
		
		// Add new characters to the charactersPanel
		charactersPanel.add(newCharacters);
		
		return charactersPanel;
		
	}
	
    /**
     * Create a JLabel for each new character and add it to the JPanel.
     */
	public void addNewCharacter() {
		
		JLabel newCharacterLabel = new JLabel(newCharacter);
		
		newCharacterLabel.setFont( new Font("Helvetica", Font.BOLD, 16) );
		
		newCharacterLabel.setForeground(Color.RED);
		
		newCharacters.add(newCharacterLabel);
		
		charactersPanel.add(newCharacters);
		
		this.add(charactersPanel);
		
	}
	
	
	/**
	 * Create a JPanel for displaying questions and getting users' answers.
	 * 
	 * @return QandAPanel
	 */
	private JPanel createQandAPanel() {
		
		JPanel QandAPanel = new JPanel( new GridLayout(2, 1) );
		
		QandAPanel.setBackground(Color.BLACK);
		
		// Create a JPanel for the two JButtons using FlowLayout
		JPanel buttonsPanel = new JPanel( new FlowLayout() );
		
		buttonsPanel.setBackground(Color.BLACK);
		
		// Create a JButton for the "yes" answer 
		yesButton = new JButton("Yes");
		
		yesButton.addActionListener(this);
		
		yesButton.setOpaque(true);
		
		yesButton.setBorderPainted(false);
		
		// yesButton should be disabled before the game starts
		yesButton.setEnabled(false);
		
		// Create a JButton for the "no" answer
		noButton = new JButton("No");
		
		noButton.addActionListener(this);
		
		noButton.setOpaque(true);
		
		noButton.setBorderPainted(false);
		
		// noButton should be disabled before the game starts
		noButton.setEnabled(false);
		
		buttonsPanel.add(yesButton);
		
		buttonsPanel.add(noButton);
		
		// Create a JLabel to display the content (question/message)
		contentLabel = new JLabel(content);
		
		contentLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		contentLabel.setFont( new Font("Courier", Font.BOLD, 26) );
		
		contentLabel.setForeground(Color.WHITE);
		
		// Add the content label and the buttons to QandAPanel
		QandAPanel.add(contentLabel);
		
		QandAPanel.add(buttonsPanel);
		
		return QandAPanel;
			
	}
	
	/**
	 * Create a JPanel to contain the QandAPanel and a JButton to start the guessing game.
	 * 
	 * @return GamePanel
	 */
	public JPanel createGamePanel() {
		
		JPanel gamePanel = new JPanel( new GridLayout(2, 1) );
		
		// Create a JButton to start the guessing game
		startButton = new JButton("Let's play the guessing game!");
		
		startButton.addActionListener(this);
		
		startButton.setFont( new Font("Helvetica", Font.BOLD, 22) );
		
		gamePanel.add( createQandAPanel() );
		
		gamePanel.add( startButton );
		
		return gamePanel;
		
	}
	
	/**
	 * Required by the ActionListener interface.
	 * 
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		
		// if the user answer is "yes"
		if (e.getSource() == yesButton) {
			
			// if the node is a leaf, then "yes" means the program guessed right
			if ( node.isLeaf() ) {
				
				contentLabel.setText("Haha! I guessed it right! " + "Please think about another character.");
				
				// Disable yesButton and noButton
				yesButton.setEnabled(false);
				
				noButton.setEnabled(false);
				
				// Enable the startButton to let the user start a new game
				startButton.setEnabled(true);
				
			} else {
				
				// if the left child of the current node is a leaf, then the program confirms its guess with the user
				if ( node.getLeftChild().isLeaf() ) {
					
					node = node.getLeftChild();
					
					content = node.getData();
					
					contentLabel.setText("Are you thinking about " + content + "?");
				
			    // the program keeps asking questions 
				} else {
					
					node = node.getLeftChild();
					
					content = node.getData();
					
					contentLabel.setText(content);
					
				}
						
			}
		
	    // if the user answer is "no"
		} else if (e.getSource() == noButton) {
			
		   // if the node is a leaf, then "no" means the program guessed wrong
           if ( node.isLeaf() ) {
				
                contentLabel.setText("Oops! I got it wrong! " + "Please give me a chance to learn the new character.");
                
                // Keep popping up a window to ask for the new character if the user clicks "Cancel", close the window, or doesn't type.
                while (newCharacter == null || newCharacter.isEmpty()) {
                	
                	getNewCharacter();
                	
                }
                
                // Keep popping up a window to ask for the user question if the user clicks "Cancel", close the window, or doesn't type.
                while (userQuestion == null || userQuestion.isEmpty()) {
                	
                	getUserQuestion();
                
                }
                
                // Keep popping up a window to ask for the user answer if the user clicks "Cancel", close the window, or doesn't type.
                while (userAnswer == null || userAnswer.isEmpty()) {
                	
                	getUserAnswer();
                }
                
                // Update the decision tree
                growDecisionTree();
                
                // Display the new character in the JPanel
                addNewCharacter();
                
                // Set the user inputs to null to allow the tree to grow
                newCharacter = null;
                
                userQuestion = null;
                
                userAnswer = null;
                
                // Disable yesButton and noButton
				yesButton.setEnabled(false);
				
				noButton.setEnabled(false);
				
				// Enable the startButton to let the user start a new game
				startButton.setEnabled(true);
				
				
			} else {
				
				// if the right child of the current node is a leaf, then the program confirms its guess with the user
				if ( node.getRightChild().isLeaf() ) {
					
					node = node.getRightChild();
					
					content = node.getData();
					
					contentLabel.setText("Are you thinking about " + content + "?");
				
				// the program keeps asking questions
				} else {
					
					node = node.getRightChild();
					
					content = node.getData();
					
					contentLabel.setText(content);
					
				}
						
			}
		
        // if the user clicks the startButton
		} else if (e.getSource() == startButton) {
			
			// Set the root of the tree as the current node
			node = gameTree.getRoot();
			
			content = node.getData();
			
			contentLabel.setText(content);
			
			// Enable yesButton and noButton
			yesButton.setEnabled(true);
			
			noButton.setEnabled(true);
			
			// Disable startButton
			startButton.setEnabled(false);
			
		}	
		
	}
	
	/**
	 * Modify the decision tree to include the new character for a new guessing game.
	 */
	public void growDecisionTree() {
		
		// Transfer the wrong guess to a new BinaryTreeNode
		String wrongGuess = node.getData();
		
		BinaryTreeNode<String> wrongGuessNode = new DefaultBinaryTreeNode<String>();
		
		wrongGuessNode.setData(wrongGuess);
		
		// The node contains the user question
		node.setData(userQuestion);
        
		// Create a new node for the new character
		BinaryTreeNode<String> newCharacterNode = new DefaultBinaryTreeNode<String>();
		
		newCharacterNode.setData(newCharacter);
		
		// if the user answer to the question is "yes"
		if (userAnswer.toLowerCase().equals("yes")) {
			
			// the new character is the left child of the question node
			node.setLeftChild(newCharacterNode);
			
			// the wrong guess is the right child of the question node
			node.setRightChild(wrongGuessNode);
		
		// if the user answer to the question is "no"
		} else if (userAnswer.toLowerCase().equals("no")) {
			
			// the wrong guess is the left child of the question node
			node.setLeftChild(wrongGuessNode);
			
			// the new character is the right child of the question node
			node.setRightChild(newCharacterNode);
		}
		
	}
	
	/**
	 * Use a JOptionPane to ask for the new character.
	 */
	public void getNewCharacter() {
		
	   newCharacter = JOptionPane.showInputDialog("Which character were you thinking of?");
		
	}
	
	/**
	 * Use a JOptionPane to ask for the user question.
	 */
	public void getUserQuestion() {
		
	   userQuestion = JOptionPane.showInputDialog("Please give me a yes/no question that would have determined the new character.");
		
	}
	
	/**
	 * Use a JOptionPane to ask for the yes/no answer.
	 */
	public void getUserAnswer() {
		
	   userAnswer = JOptionPane.showInputDialog("Is the answer to your question yes or no?");
	
	}
	
}
