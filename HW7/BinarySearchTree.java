/* Author: Artiom Dolghi
 * Due date: March 26, 2020
 * Purpose: find() --> helper method added to help with getLCA()
 * 			isBST() --> checks whether or not the tree is a BST
 * 			getLCA() --> returns the LCA of two nodes in the tree
 * Credits: I did not work with anybody else on this assignment
 */

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	private Node root;

	private static class Node {
		public int data;              // data item (key)
		public Node left;         // this node's left child
		public Node right;        // this node's right child

		public Node(int data){
			this.data = data;
		}

		public void displayNode()      // display ourself
		{
			System.out.print(data + " ");
		}
	}  // end class Node

//-------------------------------------------------------------
	public BinarySearchTree()         // constructor of the Binary Tree
	{ root = null; }            // no nodes in tree yet
	
	public void insert(int id) {
		Node newNode = new Node(id);    // make new node
		if(root==null)                // no node in root
			root = newNode;
		else {
			Node current = root;
			Node parent = root;
			while (current!=null){
				parent = current;
				if (id<current.data){
					current = current.left;
				} else {
					current = current.right;
				}
			}
			if (id<parent.data) parent.left = newNode;
			else parent.right = newNode;
		} 
	}  // end insert()
	
	public Node find(Node current, int target) { // Taken from the slides to help with getLCA()
		if (current == null || target == current.data) return current;
		
		if (target < current.data) return find(current.left, target);
		
		else return find(current.right, target);
	}
	
	/*
	 * @param none
	 * @return true or false indicating whether the tree is a binary search tree
	 */
	public boolean isBST(){
		
		return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean isBSTHelper(Node node, int minVal, int maxVal) {
		if (node == null) return true;
		
		if (node.data < minVal || node.data > maxVal) return false;
		
		return isBSTHelper(node.left, minVal, node.data) && isBSTHelper(node.right, node.data, maxVal);
	}
	
	/*
	 * @param two nodes
	 * @return the data of the node which is the lowest common ancestor of node p and q;
	 * @return -1 if either p or q does not exist in the tree
	 */
	public int getLCA(Node p, Node q) {
		
		if (p == null) {
			System.out.println("The first node (p) does not exist"); // error checking
			return -1;
		}
		
		if (q == null) {
			System.out.println("The second node (q) does not exist");
			return -1;
		}
		
		else return getLCAHelper(root, p.data, q.data).data;
	}
	
	public Node getLCAHelper(Node node, int pData, int qData) { 
		
        if (node == null) 
            return null; 
   
        if (node.data > pData && node.data > qData) 
            return getLCAHelper(node.left, pData, qData); 
   
        if (node.data < pData && node.data < qData)  
            return getLCAHelper(node.right, pData, qData); 
   
        return node;
    } 
	
	public static void main(String[] args){
		Node root1 = new Node(2);
		Node left1 = new Node(1);
		Node right1 = new Node(3);
		root1.left = left1;
		root1.right = right1;
		BinarySearchTree tree1 = new BinarySearchTree();
		tree1.root = root1;
		System.out.println("Is the first tree a valid BST?: " + tree1.isBST());
		
		Node root2 = new Node(5);
		Node left2_1 = new Node(1);
		Node right2_1 = new Node(4);
		Node left2_2 = new Node(3);
		Node right2_2 = new Node(6);
		root2.left = left2_1;
		root2.right = right2_1;
		right2_1.left = left2_2;
		right2_2.right = right2_2;
		BinarySearchTree tree2 = new BinarySearchTree();
		tree2.root = root2;
		System.out.println("Is the second tree a valid BST?: " + tree2.isBST());
		
		BinarySearchTree tree3 = new BinarySearchTree();
		int[] nodes = {6, 8, 2, 4, 0, 9, 7, 5, 3};
		for (int n: nodes){
			tree3.insert(n);
		}
		// YOUR CODES to get the LCA for the following two nodes' set:
		// node 2 and node 8
		int result = tree3.getLCA(tree3.find(tree3.root, 2), tree3.find(tree3.root, 8));
		if (result != -1) {
		System.out.println(result);
		}
		// node 0 and node 3
		result = tree3.getLCA(tree3.find(tree3.root, 0), tree3.find(tree3.root, 3));
		if (result != -1) {
		System.out.println(result);
		}
		// node 2 and node 10
		result = tree3.getLCA(tree3.find(tree3.root, 2), tree3.find(tree3.root, 10));
		if (result != -1) {
		System.out.println(result);
		}
		// node 1 and node 3
		result = tree3.getLCA(tree3.find(tree3.root, 1), tree3.find(tree3.root, 3));
		if (result != -1) {
		System.out.println(result);
		}
	}
}
//-------------------------------------------------------------