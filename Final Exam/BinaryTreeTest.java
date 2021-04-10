// Artiom Dolghi

package Final2020S;

/* Problem 4
 * Please finish implementing the following method 
 * that will find and return the number of non-leaf (or interior nodes) on the binary tree.
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

public int nonLeafNodeCount(TreeNode root){
	return getSize(root)-getLeafNodeCount(root);
}

public int getSize(TreeNode root) {
    if (root == null) {
    	return 0;
    } else {
    	return (size(root.left) + 1 + size(root.right));
    }
    
}

public int getLeafNodeCount(TreeNode root) {
     if (root == null) {
    	 return 0;
     }
     
     if (root.left == null && root.right == null) {
    	 return 1;
     } else {
    	 return getLeafNodeCount(root.left) + getLeafCount(root.right);
     }

}
