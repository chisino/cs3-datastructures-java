/* Author: Artiom Dolghi
 * Due date: Feb 20, 2020
 * Purpose: The removeN() method removes a the Nth node from the end of a LinkedList
 * Credits: I did all of the work independently but consulted the slides
 */

import java.util.Scanner;

public class RemoveLinkedList {
  private static class Link
  {
    public int iData;              // data item
    public Link next;              // next link in list
    
//-------------------------------------------------------------
    public Link(int id) // constructor
    {
      iData = id;                 // initialize data     
      next =  null;
    }                      
    
//-------------------------------------------------------------
    
    public void displayLink()      // display ourself
    {
      System.out.print("{" + iData + "} ");
    }
  }  // end class Link
////////////////////////////////////////////////////////////////
  
  private static class LinkList
  {
    private Link first;            // ref to first link on list
    
//-------------------------------------------------------------
    public LinkList()              // constructor
    {
      first = null;               // no links on list yet
    }
    
// -------------------------------------------------------------
    public boolean isEmpty()       // true if list is empty
    {
      return (first==null);
    }
//-------------------------------------------------------------
    // insert at start of list
    public void insertFirst(int id)
    {                           // make new link
      Link newLink = new Link(id);
      newLink.next = first;       // newLink --> old first
      first = newLink;            // first --> newLink
    }
//-------------------------------------------------------------
    public Link deleteFirst()      // delete first item
    {                           // (assumes list not empty)
      Link temp = first;          // save reference to link
      first = first.next;         // delete it: first-->old next
      return temp;                // return deleted link
    }
//-------------------------------------------------------------
    public void displayList()
   {
      System.out.print("List (first-->last): ");
      Link current = first;       // start at beginning of list
      while(current != null)      // until end of list,
      {
        current.displayLink();   // print data
        current = current.next;  // move to next link
      }
      System.out.println("");
    }
//-------------------------------------------------------------
    
    public void removeN(int n) {
    	Link current = first;  
    	Link previous = first;  
    	while (current != null && current.iData != n) { 
    		previous = current; 
    		current = current.next;  
    	} 
    	if (current == first)
    		first = current.next; 
    	else if (current != null) 
    		previous.next = current.next; 
    }
    
  }  // end class LinkList
////////////////////////////////////////////////////////////////
  
  public static void main(String[] args)
  {
    LinkList theList = new LinkList();  // make new list
    
    theList.insertFirst(1);      // insert five items
    theList.insertFirst(2);
    theList.insertFirst(3);
    theList.insertFirst(4);
    theList.insertFirst(5);
    
    theList.displayList();              // display list
    
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter a number N, so that the Nth node from the end will be deleted: ");
    int pos = input.nextInt();
    input.close();
    
    theList.removeN(pos);
    theList.displayList();
  }  // end main()
}  // end class RemoveLinkedList