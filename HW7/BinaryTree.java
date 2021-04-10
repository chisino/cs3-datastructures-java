/* Author: Artiom Dolghi
 * Due date: March 26, 2020
 * Purpose: getNodes() --> returns the number of nodes in the tree
 * 			isSymmetric() --> returns whether or not the tree is symmetric
 * 			getPaths() -- > returns all paths of the tree
 * Credits: I did not work with anybody else on this assignment
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.Random;
import java.util.*;

public class BinaryTree {
////////////////////////////////////////////////////////////////
  private Node root;
  
  private static class Node {
    public int iData;              // data item (key)
    public Node leftChild;         // this node's left child
    public Node rightChild;        // this node's right child
    
    public void displayNode()      // display ourself
    {
      System.out.print(iData + " ");
    }
  }  // end class Node

//-------------------------------------------------------------
  public BinaryTree()         // constructor of the Binary Tree
  { root = null; }            // no nodes in tree yet
//-------------------------------------------------------------
  
  public void insert(int id) {
    Node newNode = new Node();    // make new node
    newNode.iData = id;           // insert data

    if(root==null)                // no node in root
      root = newNode;
    else                          // root occupied
    {
      Random rnd = new Random();
      Node current = root;
      Node parent = root;
      int rand = 0;
      while (current!=null){
        parent = current;
        rand = rnd.nextInt(2);
        if (rand==0) current = current.leftChild;
        else current = current.rightChild;
      }
      if (rand==0) parent.leftChild = newNode;
      else parent.rightChild = newNode;
    }
  }  // end insert()

//-------------------------------------------------------------

  /* Level-order traversal of the Tree
   */
  public void displayTree() {
    Queue<Node> q = new LinkedList<Node>();
    q.add(root);
    while (!q.isEmpty()){
      Node current = q.poll();
      current.displayNode();
      if (current.leftChild!=null) {
        System.out.print(current.iData + " " + "Left: " + current.leftChild.iData + "\t");
        q.add(current.leftChild);
      }
      else {
        System.out.print(current.iData + " " + "Left:NULL" + "\t");
      }
      if (current.rightChild!=null) {
        System.out.print(current.iData + " " + "Right: " + current.rightChild.iData + "\n");
        q.add(current.rightChild);
      }
      else {
        System.out.println(current.iData + " " + "Right:NULL");
      }
    }
    System.out.println();
  }  

  public void displayTree2() {
    Queue<Node> q = new LinkedList<Node>();
    q.add(root);
    while (!q.isEmpty()){
      Node current = q.poll();
      current.displayNode();
      if (current.leftChild!=null) {
        q.add(current.leftChild);
      }
      if (current.rightChild!=null) {
        q.add(current.rightChild);
      }
    }
  }  
  /* @param none
   * @return the total number of nodes in this Binary Tree
   */
  public int getNodes(){
	  return count(root);
  }
  
  public int count(Node root) { //Helper function for getNodes
	 
	  if (root == null) return 0;
	  
	  return 1 + count(root.leftChild) + count(root.rightChild);
  }
  
  /*@param  another binary tree
   * @return return true or false
   * indicating whether this binary tree is symmetric of itself.
   */
  public boolean isSymmetric() {
	  
	  return isSymmetricHelper(root, root);
  }
  
  public boolean isSymmetricHelper(Node node1, Node node2) {
	  
	  if (node1 == null && node2 == null) return true;
	  
	  if (node1 != null && node2 != null && node1.iData == node2.iData) { 
          return (isSymmetricHelper(node1.leftChild, node2.rightChild) && isSymmetricHelper(node1.rightChild, node2.leftChild)); 
	  }
	  
	  return false;
  }
  
  /*
   * @param none
   * @return return all the root-to-leaf paths in this Binary Tree
   */
  public ArrayList<ArrayList<Integer>> getPaths() {
	  
	  ArrayList<Integer> result = new ArrayList<Integer>();
	  ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
	  
	  if (root == null) return results;
	  
	  getPathsHelper(root, results, result);
	  
	  return results;
  }
  
  public void getPathsHelper(Node node, ArrayList<ArrayList<Integer>> results, ArrayList<Integer> result) {
	  result.add(node.iData);
	  
	  if (node.leftChild == null && node.rightChild == null) {
		  results.add(result);
		  return;
	  }
	  
	  if (node.leftChild != null) {
		  ArrayList<Integer> temp = new ArrayList<Integer>(result);
		  getPathsHelper(node.leftChild, results, temp);
	  }
	  
	  if (node.rightChild != null) {
		  ArrayList<Integer> temp = new ArrayList<Integer>(result);
		  getPathsHelper(node.rightChild, results, temp);
	  }
  }
  
  public static void main(String[] args) throws IOException {
    // Sample Codes, Create a binary tree and display all the nodes in level-order
    BinaryTree theTree = new BinaryTree();
    theTree.insert(50);    
    theTree.insert(25);    
    theTree.insert(75);
    theTree.insert(12);    
    theTree.insert(37);    
    theTree.insert(43); 
    theTree.insert(30);    
    theTree.insert(33);
    theTree.insert(87);
    theTree.insert(93);    
    theTree.insert(97);
    
    theTree.displayTree();
    
    /* Problem 1:
     * Please call the methods of getNode(), and return the total number of nodes in this binary tree
     * YOUR CODES
     */
    
    System.out.println(theTree.getNodes());
    
    /* Problem 2:
     * Call isSymmetric() to judge this binary tree is symmetric of itself around the center.
     * YOUR CODES
     */
    
    if (theTree.isSymmetric()) {
    	System.out.println("The binary tree is symmetric");
    } else {
    	System.out.println("The binary tree is not symmetric");
    }
    
    /*
     * Problem 3:
     * Call the getPaths() method, and display all the root-to-leaf paths on the binary tree
     * YOUR CODES
     */
    
    ArrayList<ArrayList<Integer>> results = theTree.getPaths();
    
    for (int i = 0;i < results.size();i++) {
    	for (int j = 0;j < results.get(i).size();j++) {
    		if (j == 0) {
    			System.out.print(results.get(i).get(j) + " ");
    		} else {
    			System.out.print("-> " + results.get(i).get(j) + " ");
    		}
    	}
    	System.out.println("");
    }
    
  }
}