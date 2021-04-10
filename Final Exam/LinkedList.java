// Artiom Dolghi

package Final2020S;
/* Problem 3.
 * Given a sorted linked list, delete all duplicates such that each element appear only once. 
 * Example 1:  Input:  1->1->2    Output:  1->2
 * Example 2:  Input: 1->1->2->3->3   Output: 1->2->3
*/

class Node {
	int val;
	Node next;
	Node(int val){
		this.val = val;
	}
}

public class LinkedList {
	public static void removeDuplicate(Node first) {
		Node current = first;
		
		while (current != null) {
			Node temp = current;
			
			while (temp != null && temp.val == current.val) {
				temp = temp.next;
			}
			
			current.next = temp;
			current = current.next;
		}

	}
	
	public static void main(String[] args){
		Node n1 = new Node(1);
		Node n2 = new Node(1);
		Node n3 = new Node(2);
		Node n4 = new Node(3);
		Node n5 = new Node(3);
		removeDuplicate(n1);
	}
}
