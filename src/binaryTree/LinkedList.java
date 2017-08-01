package binaryTree;
/**
 * A generic class for a linked list.
 * 
 * @param <T>
 * @author Xueying Xu (Shirley)
 * @version Assignment 7
 */
public class LinkedList<T> {
    
	private LinkedListNode<T> head;
	
	/**
	 * Constructs an empty linked list.
	 */
	public LinkedList() {
		 
		head = null;		
	}
	
	/**
	 * Get data stored in head node of list.
	 * @return the data in the head node
	 */
	public T getFirst() {
		
		if (!isEmpty()) {
		
			return head.getData();
	  
		} else {
			
			return null;
		}
	}
	 
	/**
	 * Get the head node of the list.
	 * @return the head node
	 */
	public LinkedListNode<T> getFirstNode() {
		
		if (!isEmpty()) {
			
			return head;
		
		} else {
			
			return null;
		}
		
	}
	 
	/**
	 * Get data stored in last node of list.
	 * @return the data in the tail node
	 */
	public T getLast() {
		
		if (!isEmpty()) {
			
			return getLastNode().getData();
		
		} else {
			
			return null;
		}
		
	}
	 
	/**
	 * Get the tail node of the list.
	 * @return the tail node
	 */
	public LinkedListNode<T> getLastNode() {
		
		LinkedListNode<T> lastNode = head;
		
		if (isEmpty()) {
			
		    lastNode = null;
		
		} else {
			
		    while (lastNode.getNext() != null) {
		    	
		    	lastNode = lastNode.getNext();
		    
		    } 
		     
		}
		
		return lastNode;
	}
	 
	/**
	 * Insert a new node with data at the head of the list.
	 * @param data the data to insert
	 */
	public void insertFirst( T data ) {
		
		// Create a new node
		LinkedListNode<T> headNode = new LinkedListNode<T>();
		
		// Set the data 
	    headNode.setData(data);
		
		headNode.setNext(head);
		
		head = headNode;
		
	}
	 
	/**
	 * Insert a new node with data after currentNode
	 * @param currentNode the target node to insert a new node after it
	 * @param data the data to insert
	 */
	public void insertAfter( LinkedListNode<T> currentNode, T data ) {
		
		LinkedListNode<T> node = new LinkedListNode<T>();
		
		node.setData(data);
		
		node.setNext(currentNode.getNext());
		
		currentNode.setNext(node);
		
	}
	 
	/**
	 * Insert a new node with data at the end of the list.
	 * @param data the data to insert
	 */
	public void insertLast( T data ) {
		
		LinkedListNode<T> node = new LinkedListNode<T>();
		
		node.setData(data);
		
		LinkedListNode<T> currentNode = head;
		
		if (currentNode == null) {
			
			head = node;
		
		} else {
			
			while (currentNode.getNext() != null) {
				
				currentNode = currentNode.getNext();
				
			}
			
			currentNode.setNext(node);
			
		}
		
	}
	 
	/**
	 * Remove the first node.
	 */
	public void deleteFirst() {
		
		if (!isEmpty()) {
			
		   head = head.getNext();
		
		}
	
	}

	
	/**
	 * Remove the last node.
	 */
	public void deleteLast() {
		
		LinkedListNode<T> currentNode = head;
		
		if (currentNode == null) {
			
			System.out.println("The linked list is empty. Nothing to remove.");
		
		} else if (currentNode.getNext() == null) {
			
			head = null;
		
		} else {
			
			while (currentNode.getNext().getNext() != null) {
				
				currentNode = currentNode.getNext();
			}
			
			currentNode.setNext(null);
			
		}
	}
	 
	/**
	 * Remove node following currentNode.
	 * If no node exists (i.e., currentNode is the tail), do nothing
	 * @param currentNode the target node to remove a node after it
	 */
	public void deleteNext( LinkedListNode<T> currentNode ) {
		
		if (currentNode.getNext() != null) {
			
			currentNode.setNext(currentNode.getNext().getNext());
			
		}
	}

	
	/**
	 * Get the size of the linked list.
	 * @return the number of nodes in this list.
	 */
	public int size() {
		
		if (isEmpty()) {
			
			return 0;
		
		} else {
			
			LinkedListNode<T> currentNode = head;
			
			int nodeCounter = 1;
			
			while (currentNode.getNext() != null) {
				
				nodeCounter++;
				
				currentNode = currentNode.getNext();
				
			}
			
			return nodeCounter;
		}
	
	}
	 
	/**
	 * Check if list is empty.
	 * @return true if list contains no items.
	 */
	public boolean isEmpty() {
		
		return head == null;
	}
	 
	/**
	 * Get a String representation of the linked list.
	 * 
	 * @return a String representation of the list.
	 */
	public String toString() {
		
	     String result = "";
	
	     if ( !isEmpty() ) {
	
	        LinkedListNode<T> currentNode = head;
	
	        while (currentNode.getNext() != null) {
		
		    result = result + currentNode.toString() + "\n";
		
		    currentNode = currentNode.getNext();
	     
	      }
	
	         return result + getLastNode().toString();


	      } else {
			     
	    	 return result;
	
	      }
	 
	 }

}
