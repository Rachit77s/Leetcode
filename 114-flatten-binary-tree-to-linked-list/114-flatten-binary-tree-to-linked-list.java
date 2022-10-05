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
    
    private TreeNode prev = null;
    
    public void flatten(TreeNode root) {
        
        PostorderRecursion(root);
    }
    
    // https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36977/My-short-post-order-traversal-Java-solution-for-share
    public void PostorderRecursion(TreeNode root)
    {
        // If we traverse the flattened tree in the reverse way, we would notice that [6->5->4->3->2->1] is in (right, left, root) order of the original tree. So the reverse order after flattening is post order traversal in (right, left, root) order like [6->5->4->3->2->1].
//The idea is to traverse the original tree in this order.
        
        if(root == null)
            return;
        
        PostorderRecursion(root.right);
        PostorderRecursion(root.left);
        
        root.right = prev;
        root.left = null;
        prev = root;
    }

    // Initially pass null
    // https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36977/My-short-post-order-traversal-Java-solution-for-share
    // Check comments
    private TreeNode PostorderRecursion2(TreeNode root, TreeNode pre) 
    {
        if(root==null) 
            return pre;
        
        TreeNode right_pre = PostorderRecursion2(root.right, pre);    
        TreeNode left_pre = PostorderRecursion2(root.left, right_pre);
        
        root.right = left_pre;
        root.left = null;

        // the original pre=root statement is redundant as we are already returning left_pre
        return left_pre;
    }
    

}