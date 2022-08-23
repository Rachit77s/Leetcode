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
class Solution {
    public boolean isBalanced(TreeNode root) {
        
        return IsHeightBalancedBruteForce(root);
    }
    
    public boolean IsHeightBalancedBruteForce(TreeNode root)
    {
        if(root == null)
            return true;
        
        boolean left = IsHeightBalancedBruteForce(root.left);
        boolean right = IsHeightBalancedBruteForce(root.right);
        boolean condition = Math.abs(Height(root.left) - Height(root.right)) <= 1;
        
        if(left == true && right == true && condition == true)
            return true;
        else
            return false;
    }
    
    public int Height(TreeNode root)
    {
        if(root == null)
            return 0;

        int left = Height(root.left);
        int right = Height(root.right);

        return 1 + Math.max(left, right);
    }
}