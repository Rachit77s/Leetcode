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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        return Merge(root1, root2);
    }
    
    public TreeNode Merge(TreeNode root1, TreeNode root2) 
    {
        if(root1 != null && root2 != null)
        {
            
            TreeNode root = new TreeNode(root1.val + root2.val);
            root.left = Merge(root1.left, root2.left);
            root.right = Merge(root1.right, root2.right);
            return root;
        }
        else if(root1 != null)
            return root1;
        else
            return root2;
    }
}