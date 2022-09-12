/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return LCA(root, p, q);
    }
    
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) 
    {
        // every node will check if I am the LCA or not.
        if(root == null)
            return null;
        

        if(root == p || root == q)
            return root;
        
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        
        if(left != null && right != null)
            return root; // I am the LCA
        else if(left != null && right == null)
            return left;
        else if(left == null && right != null)
            return right;
        else
            return null;
    }
}