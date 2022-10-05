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
        
        IterativeStack(root);
        // PostorderRecursion(root);
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
    
    // https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36991/Accepted-simple-Java-solution-iterative
    public void IterativeStack(TreeNode root)
    {
        if(root == null)
            return;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty())
        {
            TreeNode curr = stack.pop();
            
            if(curr.right != null)
                stack.push(curr.right);
            
            if(curr.left != null)
                stack.push(curr.left);
            
            if(!stack.isEmpty())
                curr.right = stack.peek();
            
            curr.left = null;  // dont forget this!! 
        }
    }
}