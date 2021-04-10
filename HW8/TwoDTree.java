/* Author: Artiom Dolghi
 * Due date: April 26, 2020
 * Purpose: The TwoDTree class represents a 2 dimensional BST
 * Credits: I did not work with anybody else on this assignment
 */

import java.util.*;

import java.io.*;

public class TwoDTree {
    private Node root; // root of the KdTree

    private static class Point2D {
    	double x;
    	double y;
    	
    	public Point2D(double x, double y){
    		this.x = x;
    		this.y = y;
    	}
    }
    	
    // 2d-tree (generalization of a BST in 2d) representation.
    private static class Node {
        private Point2D p;   // the point
        private Node left;     // the left/bottom subtree
        private Node right;     // the right/top subtree

        // Construct a node given the point
        Node(Point2D p) {
            this.p = p;
        }
    }
    
    public TwoDTree(){
    	root = null;
    }
    
    public void insert(Point2D p){
    	
    	Node newNode = new Node(p);   
    	
		if (root == null) root = newNode;
		else {
			Node current = root;
			Node parent = root;
			while (current != null){
				parent = current;
				if (p.x < current.p.x){
					current = current.left;
				} else {
					current = current.right;
				}
			}
			if (p.y < parent.p.y) parent.left = newNode;
			else parent.right = newNode;
		}	
    	
    }
    
    public boolean search(Point2D p){
    	return contains(root, p.x, p.y);
    }
    
    public boolean contains(Node node, double x, double y) {
    	if (node == null) return false;
    	if (node.p.x == x && node.p.y == y) return true;
    	
    	if (x < node.p.x) return contains(node.left, x, y);
    	
    	else return contains(node.right, x, y);
    }
    
    public void display(){
    	
    	levelOrderTraversal(root);
    }
    
    public boolean printLevel(Node root, int level)
	{

		if (root == null) {
			return false;
		}

		if (level == 1)
		{
			System.out.print(root.p.x + " ");
			System.out.print(root.p.y + " ");
			System.out.println();

			return true;
		}

		boolean left = printLevel(root.left, level - 1);
		boolean right = printLevel(root.right, level - 1);

		return left || right;
	}
    
    public void levelOrderTraversal(Node root)
	{

		int level = 1;

		while (printLevel(root, level)) {
			level++;
		}
	}

   
    public static void main(String[] args) throws Exception {
    	// 1. YOUR CODES to Read file and build the tree by insertion
    	
    	TwoDTree tree1 = new TwoDTree();
    	
    	try {
    		File f = new File("src/Input10K.txt"); //using a mac
    		Scanner reader = new Scanner(f);
    		while (reader.hasNextLine()) {
    			String data = reader.nextLine();
    			String[] splitStr = data.trim().split("\\s+");
    			Double x = Double.parseDouble(splitStr[0]);
    			Double y = Double.parseDouble(splitStr[1]);
    			Point2D point = new Point2D(x, y);
    			tree1.insert(point);
    		}
    		reader.close();
    	} catch (FileNotFoundException e) {
    		System.out.println("An error occured.");
    	}
    	
    	// 2. Display the TwoDTree in Level-Order
    
    	tree1.display();
    	
    	// 3. Search for some arbitrary points.
    	
    	Point2D p1 = new Point2D(0.40636, 0.6781);
    	Point2D p2 = new Point2D(0.5, 0.7);
    
    	System.out.println("Is point (" + p1.x + ", " + p1.y + ") on the tree: " +  tree1.search(p1));
    	System.out.print("Is point (" + p2.x + ", " + p2.y + ") on the tree: " +  tree1.search(p2));
    	
    }
}
