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
    public int maxDepth(TreeNode root) {
        return GetMaxDepth(root);
    }
    
    public int GetMaxDepth(TreeNode root)
    {
        if(root == null)
            return 0;
        
        int leftHeight = GetMaxDepth(root.left);
        int rightHeight = GetMaxDepth(root.right);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}