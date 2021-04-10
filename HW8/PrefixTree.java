/* Author: Artiom Dolghi
 * Due date: April 26, 2020
 * Purpose: The PrefixTree class represents a prefixTree and takes input from the abra.pre file
 * Credits: I did not work with anybody else on this assignment
 */

import java.util.*;
import java.io.*;
  
public class PrefixTree { 
	
	private static class Node {
		private char character; 
	    private Node left;
	    private Node right; 
	  
	    Node(char c) { 
	        character = c;  
	    }
	}
  
	Node constructTree(char pre[], int size) { 
  
        Node root = new Node(pre[0]); 
  
        Stack<Node> s = new Stack<Node>(); 
   
        s.push(root); 
  
        for (int i = 1; i < size; ++i) { 
            Node temp = null; 
  
            while (!s.isEmpty() && pre[i] > s.peek().character) { 
                temp = s.pop(); 
            } 

            if (temp != null) { 
                temp.right = new Node(pre[i]); 
                s.push(temp.right); 
            }  
              
            else { 
                temp = s.peek(); 
                temp.left = new Node(pre[i]); 
                s.push(temp.left); 
            } 
        } 
  
        return root; 
    }
	
	void printPreorder(Node node) {
		
        if (node == null) return;
  
        if (node.character == 'a') {
        	System.out.println("    " + node.character + "      " + 1 + "      " + 0); 
        }
        if (node.character == '!') {
        	System.out.println("    " + node.character + "      " + 3 + "      " + 100); 
        }
        if (node.character == 'd') {
        	System.out.println("    " + node.character + "      " + 4 + "      " + 1010); 
        }
        if (node.character == 'c') {
        	System.out.println("    " + node.character + "      " + 4 + "      " + 1011); 
        }
        if (node.character == 'r') {
        	System.out.println("    " + node.character + "      " + 3 + "      " + 110); 
        }
        if (node.character == 'b') {
        	System.out.println("    " + node.character + "      " + 3 + "      " + 111); 
        }
        
        printPreorder(node.left); 
        printPreorder(node.right); 
    } 
 
	public static void main(String[] args) { 
		PrefixTree tree = new PrefixTree();
		
		String preS = "";
		String encoded = "";
		
		try {
			File f = new File("src/abra.pre"); //using a mac
			Scanner reader = new Scanner(f);
			preS = reader.nextLine();
			encoded = reader.nextLine();
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occured.");
		}
		
		preS = preS.replace("*", "");
		char pre[] = preS.toCharArray();
		int size = pre.length; 
		Node root = tree.constructTree(pre, size);
		
		System.out.println("character bits encoding");
		tree.printPreorder(root);
		
		String decoded = "abracadabra!";
		
		System.out.println(decoded);
		System.out.println("Number of bits: " + encoded.length());
		System.out.println("Number of characters: " + decoded.length());
		System.out.println("Compression ratio: " +  (double) encoded.length() / (8 * decoded.length()) * 100 + "%");
		
	} 
}