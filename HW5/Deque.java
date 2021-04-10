/* Author: Artiom Dolghi
 * Due date: Feb 20, 2020
 * Purpose: The Deque class uses a doubly linked list
 * Credits: I did all of the work independently but consulted the slides
 */

//import GroupLinkedList.LinkList;

//import LinkedListCycle.Link;

public class Deque {
	private static class Link {
		public int dData; // data item
		public Link next; // next link in list
		public Link previous; // previous link in list
		// -------------------------------------------------------------

		public Link(int d) { // constructor
			dData = d;
			next = null;
			previous = null;
		}
		// -------------------------------------------------------------
		public void displayLink() { // display this link
			System.out.print(dData + " ");
		}
		// -------------------------------------------------------------
	} // end class Link

	private Link first; // ref to first item
	private Link last; // ref to last item
	
	// -------------------------------------------------------------
	// constructor
	public Deque() {
		first = null; // no items on list yet
		last = null;
	}
	
	// -------------------------------------------------------------
	public void addFront(int dd) // insert at front of list
	{
		Link newLink = new Link(dd); // make new link

		if (isEmpty()) // if empty list,
			last = newLink; // newLink <-- last
		else
			first.previous = newLink; // newLink <-- old first
		
		newLink.next = first; // newLink --> old first
		first = newLink; // first --> newLink
	}

	// -------------------------------------------------------------
	public void addRear(int dd) // insert at end of list
	{ 
		Link newLink = new Link(dd); // create a new link 
		
		if (isEmpty()) {
			first = newLink; 
		}
		else {
			last.next = newLink;  
		}
		
		last = newLink;
	}

	// -------------------------------------------------------------
	public int removeFront() // delete first link
	{ // (assumes non-empty list)
		int temp = first.dData;
	    if(first.next == null)         
	    	last = null;                
	    first = first.next;            
	    return temp;
	}

	// -------------------------------------------------------------
	public int removeRear() // delete last link
	{ // (assumes non-empty list)
		int temp = last.dData;
		last = null;
		return temp;
	}

	// -------------------------------------------------------------
	public void display() {
		System.out.print("List (first-->last): ");
		Link current = first;          
		while(current != null) {
			current.displayLink();      
		    current = current.next;     
		}
		System.out.println("");
	}

	// -------------------------------------------------------------
	public boolean isEmpty() { // true if no links
		return (first == null);
	}
	//--------------------------------------------------------------
	
	public int size() {
		Link temp = first; 
        int count = 0; 
        while (temp != null) { 
            count++; 
            temp = temp.next; 
        } 
        return count; 
	}
	
	public static void main(String[] args) {
		
		Deque d = new Deque();
		
		d.display();
		
		System.out.print(d.isEmpty());
		System.out.println("");
		
		d.addRear(4);
		d.display();
		
		d.addRear(6);
		d.display();
		
		d.addFront(0);
		d.display();
		
		d.addFront(10);
		d.display();
		
		System.out.print(d.size());
		System.out.println("");
		
		System.out.print(d.isEmpty());
		System.out.println("");
		
		d.removeRear();
		d.display();
		
		d.removeFront();
		d.display();
		
		System.out.print(d.isEmpty());
		System.out.println("");

	}
}
