package binaryTree;
/**
 * A generic class for a single node in a linked list.
 * 
 * @param <T>
 * @author Xueying Xu (Shirley)
 * @version Assignment 7
 */
public class LinkedListNode<T> {

	private T data;
	
	private LinkedListNode<T> next;
	
	/**
	 * Constructor.
	 */
	public LinkedListNode() {
		
		
	}
	
	/**
	 * Set the data stored at this node.
	 * 
	 * @param data the data to store in the node
	 */
	public void setData( T data ) {
		
		this.data = data;
		
	}
	
	/**
	 * Get the data stored at this node.
	 * 
	 * @return the data in the node
	 */
	public T getData() {
		
		return data;
		
	}
	
	/**
	 * Set the next pointer to passed node.
	 * 
	 * @param node the next node
	 */
	public void setNext( LinkedListNode<T> node ) {
		
		this.next = node;
	}
	
	/**
	 * Get (pointer to) next node.
	 * 
	 * @return the next node
	 */
	public LinkedListNode<T> getNext() {
		
		return next;
		
	}
	
	/**
	 * Get a String representation of this node.
	 * 
	 * @return a String representation of this node
	 */
	public String toString() {
	      
	   return getData().toString();
		
	}
		
	
}
