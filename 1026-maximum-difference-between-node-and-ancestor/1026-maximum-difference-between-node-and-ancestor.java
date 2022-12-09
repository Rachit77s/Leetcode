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
    
    int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        
        Helper(root, root.val, root.val);
        return ans; 
    }
    
    public void Helper(TreeNode root, int min, int max) 
    {
        if(root == null)
            return;
        
        max = Math.max(root.val, max);
        min = Math.min(root.val, min);
        
        ans = Math.max(ans, Math.abs(max - min));
        
        Helper(root.left, min, max);
        Helper(root.right, min, max);
    }
}