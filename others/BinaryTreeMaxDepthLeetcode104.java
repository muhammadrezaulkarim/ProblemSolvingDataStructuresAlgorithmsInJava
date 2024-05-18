/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BinaryTreeLeetcode104 {
    public int maxDepth(TreeNode root) {

        if(root == null)
            return 0;

        return pathNodeCount(root);
    }

    public int pathNodeCount(TreeNode node)
    {     
        int count = 0;

        if(node.left==null && node.right==null)
            count = 1;    

        else if(node.left!=null && node.right==null)
            count = pathNodeCount(node.left) + 1;
        
        else if(node.right!=null && node.left==null)
           count = pathNodeCount(node.right) + 1;

        else
            count = Math.max(pathNodeCount(node.left), pathNodeCount(node.right)) + 1;
        

        return count;
    }
}

/*

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2

*/
