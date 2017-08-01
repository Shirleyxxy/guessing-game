package binaryTree;
/**
 * A generic class for a single binary tree node. 
 * 
 * @param <T>
 * @author Xueying Xu (Shirley)
 * @version Assignment 7
 */
public class DefaultBinaryTreeNode<T> implements BinaryTreeNode<T> {
	
	private T data;
	
	private BinaryTreeNode<T> left;
	
	private BinaryTreeNode<T> right;
	
	/**
	 * Constructor.
	 */
	public DefaultBinaryTreeNode() {
				
	}

	
	/**
	 * Get the data stored at this node.
	 * @return Object data.
	 */
	public T getData() {
		
		if (data != null) {
			
			return data;
			
		} else {
			
			return null;
		}
	
	}

	
	/**
	 * Set the data stored at this node.
	 * @param data the data to store
	 */
	public void setData(T data) {
		
		this.data = data;
	}
	
	
	/**
	 * Get the left child.
	 * @return BinaryTreeNode that is left child
	 * or null if no child.
	 */
	public BinaryTreeNode<T> getLeftChild() {
		
		if (left != null) {
			
			return left;
			
		} else {
			
			return null;
		}
	
	}
	
	
	/**
	 * Set the left child.
	 * @param left the left child
	 */
	public void setLeftChild( BinaryTreeNode<T> left ) {
		
		this.left = left;
		
	}
	
	
	/**
	 * Get the right child.
	 * @return BinaryTreeNode that is right child
	 * or null if no child.
	 */
    public BinaryTreeNode<T> getRightChild() {
		
		if (right != null) {
			
			return right;
		
		} else {
			
			return null;
		
		}
	
	}
    
    
    /**
	 * Set the right child.
	 * @param right the right child
	 */
	public void setRightChild( BinaryTreeNode<T> right ) {
		
		this.right = right;
		
	}
	
	
	/**
	 * Tests if this node is a leaf node(has no children).
	 * @return true if it is a leaf node.
	 */
	public boolean isLeaf() {
		
		return ( getLeftChild() == null && getRightChild() == null);
	
	}
		
}
