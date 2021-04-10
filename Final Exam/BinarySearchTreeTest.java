// Artiom Dolghi

package Final2020S;
/* Problem 5
 * Consider the following class defining a tree node in a binary search tree.  
 * Please finish implementing the following method containsValue() 
 * which determines whether there is a node on the binary search tree whose value is equal to the provided target value. The reference to the root node has been given to you.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public boolean containsValue (TreeNode root, int target){
	
	if (root == null) {
		return false;
	}
	
	if (root.data == target) {
		return true;
	}
	
	boolean result1 = containsValue(root.left, target);
	if (result1 == true) {
		return true;
	}
	
	boolean result2 = containsValue(root.right, target);
	
	return result2;

}
