package fileReader;
import binaryTree.*;

import javax.xml.parsers.*;

import org.xml.sax.SAXException;  
import org.w3c.dom.*;

import java.io.*;

/**
 * CharactersFileReader is a class that parses HarryPotter_characters.xml into a decision tree.
 * 
 * @author Xueying Xu (Shirley)
 * @version Final Project
 */

public class CharactersFileReader {
	 
	 /**
	  * Set up the XML file and parse the file into a decision tree.
	  * Return the decision tree.
	  * 
	  * @return a BinaryTree
	  */ 
	 public static BinaryTree<String> buildTree() {
		 
		    // Use try/catch blocks to handle three specific exceptions when setting up the XML file
			try {
				    // Setup XML Document
				    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				   
				    DocumentBuilder builder = factory.newDocumentBuilder();
				
				    File xmlFile = new File( "HarryPotter_characters.xml" );
				
				    Document document = builder.parse( xmlFile );
				    
				    // Parse the data in the XML file into a decision tree
				    BinaryTree<String> gameTree = parseIntoDecisionTree(document);
				    
				    //System.out.println(gameTree.preorderTraversal().toString());
				    
				    return gameTree;
				   	   
				} catch (ParserConfigurationException pce) {
				  
					System.out.println("There is a parser configuration exception.");
				
				} catch (SAXException saxe) {
				    
					System.out.println("There is an SAX exception.");
				
				} catch (IOException ioe) {
					
					System.out.println("There is an IO exception.");
				  
				}	
			
			 return null;
	  
		  }
		 	 
	/**
	 * Parse the document into a decision tree by creating a tree
	 * and setting its root.
	 * 
	 * @param doc
	 * @return BinaryTree
	 */
	 private static BinaryTree<String> parseIntoDecisionTree(Document doc) {
		  
		  // Get the root node of the xml file and cast it to the type Element
		  Element rootElement = (Element) doc.getDocumentElement();
		  
		  // Create a new decision tree
		  BinaryTree<String> decisionTree = new DefaultBinaryTree<String>();
		  
		  // Parse the root element and set it as the root of the decision tree
		  decisionTree.setRoot(parseXMLQuestionElementIntoDTNode(rootElement));
		 
		  return decisionTree;
		 
	 }
	
	 /**
	  * Parse a question element in the XML file into a decision tree node.
	  * 
	  * @param element
	  * @return BinaryTreeNode
	  */
	 private static BinaryTreeNode<String> parseXMLQuestionElementIntoDTNode(Element element) {
		 
		 if (!element.getTagName().equals("question")) {
			 
			 System.out.println("Error: Not a Question Element."); 
			 
			 return null;
		 
		 } else {
			
			// Create a new node with the question text
	        BinaryTreeNode<String> questionNode = new DefaultBinaryTreeNode<String>();
			 
	        questionNode.setData(element.getAttribute("text"));
			
	        // Get all of the children of this element
	        NodeList childNodes = element.getChildNodes();
			
	        // Loop all of the children
		    for (int i = 0; i < childNodes.getLength(); i++) {
				
		    	// Check whether the child is an instance of Element
			    if (childNodes.item(i) instanceof Element) {
				   
			       // Cast the type Node to the type Element
				   Element childElement = (Element) childNodes.item(i);
				   
				   // Parse answers 
				   if (childElement.getAttribute("useranswer").equals("yes")) {
					   
					   // Set it as the left child of the question node
					   BinaryTreeNode<String> yesChild = parseXMLAnswerElementIntoDTNode(childElement);
						 
					   questionNode.setLeftChild(yesChild);
						 		 
				   } else if (childElement.getAttribute("useranswer").equals("no")) {
					   
					   // Set it as the right child of the question node
					   BinaryTreeNode<String> noChild = parseXMLAnswerElementIntoDTNode(childElement);
						 
					   questionNode.setRightChild(noChild);
						 			 
				   } else {
						 
					   System.out.println("Error: Unexpected answers for a yes/no question.");
			    
				   }
		 
			     }
		    
		    }
		    
		    return questionNode;
		    
		 }
			 
    }

	 
	 /**
	  * Parse an answer element in the XML file into a decision tree node.
	  * 
	  * @param element
	  * @return BinaryTreeNode
	  */	 
	 private static BinaryTreeNode<String> parseXMLAnswerElementIntoDTNode(Element element) {
		 
		 if (!element.getTagName().equals("answer")) {
			 
			 System.out.println("Error: Not an Answer Element.");
			 
			 return null;
			 
		 } else {
			 
			 // Get all of the children of this element
		     NodeList childNodes = element.getChildNodes();
			 
		     // Loop all of the children
		     for (int i = 0; i < childNodes.getLength(); i++) {
			   
		       // Check whether the child is an instance of Element
			   if (childNodes.item(i) instanceof Element) {
				
				   // Cast the type Node to the type Element
				   Element childElement = (Element) childNodes.item(i);
				   
				   // Check whether the child is another question element
				   if (childElement.getTagName().equals("question")) {
						 
					   return parseXMLQuestionElementIntoDTNode(childElement);
				   
				   // Check whether the child is a text node
				   } else if (childElement.getTagName().equals("character")) {
				       
					   // Create a new node with the character text
				       BinaryTreeNode<String> characterNode = new DefaultBinaryTreeNode<String>();
				    	 
				       characterNode.setData(childElement.getTextContent());
				    	 
				       return characterNode;
				    	 
				   } else {
				    	 
				       System.out.println("Error: Invalid tagname.");
				    	 
				   }   
					 		 
			     }
				 
			}
			 
			 return null;
		 }
		 
	 } 
	 
	 /**
	  * Start the program.
	  * 
	  * @param args
	  */
     public static void main(String args[]) {
		
         buildTree(); 

	 }

}
