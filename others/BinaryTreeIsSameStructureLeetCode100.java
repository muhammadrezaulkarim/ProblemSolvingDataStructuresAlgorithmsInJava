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
public class BinaryTreeIsSameStructureLeetCode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        inOrderTraversal(p, sb1);
        inOrderTraversal(q, sb2);

        if(sb1.toString().equals(sb2.toString()))
            return true;
        else
            return false;
        
    }

    public void inOrderTraversal(TreeNode node, StringBuilder sb)
    {
        if(node == null) 
        {
            sb.append("null"); // this is very important to compare tree structure
            return;
        }

        sb.append(node.val);

        inOrderTraversal(node.left, sb);
        inOrderTraversal(node.right, sb);     
    }
}

/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 
Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 

Constraints:

1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

*/
