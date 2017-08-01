package binaryTree;
/**
 * DefaultBinarySearchTree is the generic class for a basic binary search tree.
 * The binary search tree contains Comparable objects as data with the invariant
 * that all data in the left subtree of a node is less than the data at the node
 * and all data in the right subtree is greater than or equal to the data at the node.
 * 
 * @author Xueying Xu (Shirley)
 * @version Assignment 7
 */

public class DefaultBinarySearchTree<T extends Comparable<T>> extends DefaultBinaryTree<T> implements BinarySearchTree<T> {

	/**
	 * Constructor.
	 */
	public DefaultBinarySearchTree() {
		
		super();
		
	}
	
	/**
	 * Search for data in the tree, finding the node containing
	 * it, or null if the data is not present in the tree.
	 * @param data the data to search for
	 * @return the node containing data or null if none exists.
	 */
	public BinaryTreeNode<T> search(T data) {
		
		// Search from the root
		BinaryTreeNode<T> node = this.getRoot();
		
		// Call the private recursive method to keep searching
		return search(data, node);
		
	}

	
	/**
	 * Search for data from a particular tree node.
	 * @param data the data to search for
	 * @param node the current node
	 * @return the node containing data or null if none exists.
	 */
	private BinaryTreeNode<T> search(T data, BinaryTreeNode<T> node) {
		
		// the node is empty
		if (node == null) {
			
			return null;
		
		// the node is not empty
		} else {
			
			// the data to search for equals the data contained in the node
			if (data.compareTo(node.getData()) == 0) {
				
				return node;
			
			// the data to search for is less than the data contained in the node
			} else if ( data.compareTo(node.getData()) < 0 ) {
				
				// search the left subtree of the node
				return search(data, node.getLeftChild());
					
			// the data to search for is greater than the data contained in the node
			} else {
				
				// search the right subtree of the node
				return search(data, node.getRightChild());
			}
			
		}
		 	
    }

	
	/**
	 * Insert the data into the tree, maintaining the search tree invariant.
	 * @param data the data to insert
	 */  
	public void insert(T data) {
		
		// Start from the root node
		BinaryTreeNode<T> node = this.getRoot();
		
		// the root node is empty
		if (node == null) {
			
			// Create a new node containing the data
			BinaryTreeNode<T> newNode = new DefaultBinaryTreeNode<T>();
			
			newNode.setData(data);
			
			// Set the root of the tree
			this.setRoot(newNode);
		
		// the root node is not empty
		} else {
			
			// Call the private recursive method to keep looking for the right 
			// place to insert the data
			insert(data, node);
			
		}	
	}
	
	/**
	 * Recursively looking for the right place from the current node
	 * to insert the data in the tree.
	 * @param data the data to insert
	 * @param node the current node
	 */
	private void insert(T data, BinaryTreeNode<T> node) {
		
		// the data to insert is less than the data contained in the current node
		if (data.compareTo(node.getData()) < 0) {
			
			// the left child of the current node is empty
			if (node.getLeftChild() == null) {
				
				// Create a new node to insert the data
				BinaryTreeNode<T> newNode = new DefaultBinaryTreeNode<T>();
				
				newNode.setData(data);
				
				node.setLeftChild(newNode);
			
			} else {
				
				// Keep looking for the right place from the left child of the current node
				insert(data, node.getLeftChild());
				
			}
		
		// the data to insert is greater than or equal to the data contained in the current node	
		} else {
			
			// the right child of the current node is empty
			if (node.getRightChild() == null) {
				
				// Create a new node to insert the data
                BinaryTreeNode<T> newNode = new DefaultBinaryTreeNode<T>();
				
				newNode.setData(data);
				
				node.setRightChild(newNode);
				
			
			} else {
				
				// Keep looking for the right place from the right child of the current node
				insert(data, node.getRightChild());
				
			}
				
		}
		
	}
	
	/**
	 * Find the minimum element in the tree.
	 * @return the minimum element
	 */
	public T minElement() {
		
		// Start from the root node
		BinaryTreeNode<T> currentNode = this.getRoot();
		
		// the root is empty
		if (currentNode == null) {
			
			return null;
		
		} else {
			
			// Keep updating the current node as long as it is not the leftmost leaf node
			while (currentNode.getLeftChild() != null) {
				
				currentNode = currentNode.getLeftChild();
				
			}
			
			// Get the data of the leftmost leaf node
			return currentNode.getData();
			
		}
	
	}
	
	
	/**
	 * Find the maximum element in the tree.
	 * @return the maximum element
	 */
	public T maxElement() {
		
		// Start from the root node
		BinaryTreeNode<T> currentNode = this.getRoot();
		
		// the root is empty
		if (currentNode == null) {
			
			return null;
		
		} else {
			
			// Keep updating the current node as long as it is not the rightmost leaf node
			while (currentNode.getRightChild() != null) {
				
				currentNode = currentNode.getRightChild();
			
			}
			
			// Get the data of the rightmost leaf node
			return currentNode.getData();
		
		}
			
	}
	
	
}
