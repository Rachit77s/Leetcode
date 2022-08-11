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
    public boolean isValidBST(TreeNode root) {
        return ValidBST(root, null, null);
    }
    
    
    
    public boolean ValidBST(TreeNode root, TreeNode left, TreeNode right)
    {
        if(root == null)
            return true;
        
        if((left != null && root.val <= left.val) || (right != null && root.val >= right.val))
            return false;
        
        return ValidBST(root.left, left, root) && ValidBST(root.right, root , right);
    }
}