package binaryTree;
/**
 * A generic class for a binary tree. 
 * 
 * @param <T>
 * @author Xueying Xu (Shirley)
 * @version Assignment 7
 */
public class DefaultBinaryTree<T> implements BinaryTree<T> {
	
	private BinaryTreeNode<T> root;
	
	/**
	 * Constructor.
	 */
	public DefaultBinaryTree() {
		
		
	}
		
	/**
	 * Get the root node for this tree.
	 * @return root or null if tree is empty.
	 */
	 public BinaryTreeNode<T> getRoot() {
		 
		 if (root != null) {
			 
			 return root;
		 
		 } else {
			 
			 return null;
		 }
 
	 }

	/**
	 * Set the root node for this tree.
	 * @param root the root node
	 */
	 public void setRoot(BinaryTreeNode<T> root) {
		
		 this.root = root;
	
	 }

	/**
	 * Test if the tree is empty.
	 * @return true if tree has no data.
	 */
	 public boolean isEmpty() {
		 
		 return (root == null);
	 }

	/**
	 * Get the data of this tree using in-order traversal.
	 * @return in-order LinkedList.
	 */
	 public LinkedList<T> inorderTraversal() {
		 
		 // Create a new LinkedList record
		 LinkedList<T> inorderTraversal = new LinkedList<T>();
		 
		 // Call the private recursive method
		 inorderTraversal(root, inorderTraversal);
		 
		 return inorderTraversal;
		 
	 }
     
	 /**
	  * A recursive method to traverse the binary tree in order (left subtree --> current node --> right subtree).
	  * @param node the current node
	  * @param traversal the LinkedList traversal record
	  */
	 private void inorderTraversal( BinaryTreeNode<T> node, LinkedList<T> traversal ) {
		 
		 // the node is empty
		 if (node == null) {
			 
			 return;
		 
		 } else {
			 
			 // the current node is a leaf node
			 if ( node.isLeaf() ) {
				 
				 // Insert the data at the end of the traversal record
				 traversal.insertLast( node.getData() );
				 
			 // the current node is not a leaf node
			 } else {
				 
				 // Keep traversing in order (left subtree, current node, then right subtree)
				 inorderTraversal(node.getLeftChild(), traversal);
				 
				 traversal.insertLast( node.getData() );
				 
				 inorderTraversal(node.getRightChild(), traversal);
				 
			 }		 
			 
		 }
		 	 
	 }
	 
	 
	/**
	 * Get the data of this tree using pre-order traversal.
	 * @return pre-order LinkedList.
	 */
	 public LinkedList<T> preorderTraversal() {
		 
		 // Create a new LinkedList record
		 LinkedList<T> preorderTraversal = new LinkedList<T>();
		 
         // Call the private recursive method
		 preorderTraversal(root, preorderTraversal);
		 
		 return preorderTraversal;
		 		 
	 }
	 
	 /**
	  * A recursive method to traverse the binary tree pre-order (current node --> left subtree --> right subtree).
	  * @param node the current node
	  * @param traversal the LinkedList traversal record
	  */
	 private void preorderTraversal( BinaryTreeNode<T> node, LinkedList<T> traversal ) {
		 
		 // the node is empty
         if (node == null) {
			 
			 return;
		 
		 } else {
			 
			 // the current node is a leaf node
			 if ( node.isLeaf() ) {
				 
				 // Insert the data at the end of the traversal record
				 traversal.insertLast( node.getData() );
				 
			 // the current node is not a leaf node
			 } else {
				 
				 // Keep traversing pre-order (current node, left subtree, then right subtree)
				 traversal.insertLast( node.getData() );
				 
				 preorderTraversal(node.getLeftChild(), traversal);
				 
				 preorderTraversal(node.getRightChild(), traversal);
				 
			 }		 
			 
		 }
	 
	 }
	 

	/**
	 * Get the data of this tree using post-order traversal.
	 * @return post-order LinkedList.
	 */
	 public LinkedList<T> postorderTraversal() {
		 
		 // Create a new LinkedList record
		 LinkedList<T> postorderTraversal = new LinkedList<T>();
		 
         // Call the private recursive method
         postorderTraversal(root, postorderTraversal);
		 
		 return postorderTraversal;	 
		 
	 }
	
	 
	 /**
	  * A recursive method to traverse the binary tree post order (left subtree --> right subtree --> current node).
	  * @param node the current node
	  * @param traversal the LinkedList traversal record
	  */
     private void postorderTraversal( BinaryTreeNode<T> node, LinkedList<T> traversal ) {
		 
		 // the node is empty
    	 if (node == null) {
			 
			 return;
		 
		 } else {
			 
			 // the current node is a leaf node
			 if ( node.isLeaf() ) {
				 
				 // Insert the data at the end of the traversal record
				 traversal.insertLast( node.getData() );
				 
			 // the current node is not a leaf node
			 } else {
				 
				 // Keep traversing post order (left subtree, right subtree, then current node)
				 postorderTraversal(node.getLeftChild(), traversal);
				 
				 postorderTraversal(node.getRightChild(), traversal);
				 
				 traversal.insertLast( node.getData() );
				 
			 }		 
			 
		 }
		 	 
	 }
     
     /**
      * Get the string representation of the in-order traversal record.
      * @return String traversal record
      */
     public String inorderToString() {
    	 
    	 return inorderTraversal().toString();
    	 
     }
     
     /**
      * Get the string representation of the pre-order traversal record.
      * @return String traversal record
      */
     public String preorderToString() {
    	 
    	 return preorderTraversal().toString();
    	 
     }
     
     /**
      * Get the string representation of the post-order traversal record.
      * @return String traversal record
      */
     public String postorderToString() {
    	 
    	 return postorderTraversal().toString();
    	 
     }
     
     /**
      * Create a DefaultBinaryTree instance corresponding to the Seven Dwarves.   
      * @param args
      */
     public static void main(String[] args) {
    	 
    	 DefaultBinaryTree<String> sevenDwarves = new DefaultBinaryTree<String>();
    	 
    	 // Create a DefaultBinaryTreeNode of type String for each dwarf
    	 DefaultBinaryTreeNode<String> Doc = new DefaultBinaryTreeNode<String>();
    	 
    	 Doc.setData("Doc");
    	 
         DefaultBinaryTreeNode<String> Grumpy = new DefaultBinaryTreeNode<String>();
    	 
    	 Grumpy.setData("Grumpy");
    	 
         DefaultBinaryTreeNode<String> Happy = new DefaultBinaryTreeNode<String>();
    	 
    	 Happy.setData("Happy");
    	 
         DefaultBinaryTreeNode<String> Sleepy = new DefaultBinaryTreeNode<String>();
    	 
    	 Sleepy.setData("Sleepy");
    	 
         DefaultBinaryTreeNode<String> Dopey = new DefaultBinaryTreeNode<String>();
    	 
    	 Dopey.setData("Dopey");
    	 
         DefaultBinaryTreeNode<String> Bashful = new DefaultBinaryTreeNode<String>();
    	 
    	 Bashful.setData("Bashful");
    	 
         DefaultBinaryTreeNode<String> Sneezy = new DefaultBinaryTreeNode<String>();
    	 
    	 Sneezy.setData("Sneezy");
    	 
    	 // Set the root of the binary tree
    	 sevenDwarves.setRoot(Happy);
    	 
    	 // Set the left and right children of each binary tree node
    	 Happy.setLeftChild(Doc);
    	 
    	 Happy.setRightChild(Sleepy);
    	 
    	 Doc.setLeftChild(Bashful);
    	 
    	 Doc.setRightChild(Grumpy);
    	 
    	 Sleepy.setLeftChild(Dopey);
    	 
    	 Sleepy.setRightChild(Sneezy);
    	 
    	 // Print the three types of traversal record for this binary tree
    	 System.out.println( sevenDwarves.inorderToString() );
    	 
    	 System.out.println( sevenDwarves.preorderToString() );
    	 
    	 System.out.println( sevenDwarves.postorderToString() );
    	 	 
     }
	 
}
