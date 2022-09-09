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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
//         if(root == null)
//             return new TreeNode(val);
        
//         Recursion(root, val);
//         return root;
        
        return Iterative1(root, val);
    }
    
    public TreeNode Recursion(TreeNode root, int K) 
    {
        /*
        Assumption:This fn inserts K at appropriate position in the tree
        rooted at 'node' and returns the updated root node.
        */
        
        if(root == null)
            return new TreeNode(K);
        
        if(root.val > K)
            root.left = Recursion(root.left, K);
        else
            root.right =  Recursion(root.right, K);
        
        return root;
    }
    
    public TreeNode Iterative1(TreeNode root, int K) 
    {   
        if(root == null)
            return new TreeNode(K);
        
        TreeNode curr = root;
        
        while(curr != null)
        {
            // Insert in LST
            if(curr.val > K)
            {
                // Go left till curr is not null
                if(curr.left != null)
                    curr = curr.left;
                else
                {
                    curr.left = new TreeNode(K);
                    break;
                }
            }
            else
            {
                // Go right till curr is not null
                if(curr.right != null)
                    curr = curr.right;
                else
                {
                    curr.right = new TreeNode(K);
                    break;
                }
            }
        }
        
        return root;
    }
    
    public TreeNode Iterative2(TreeNode root, int K) 
    {
        if(root == null)
            return new TreeNode(K);
        
        TreeNode curr = root;
        // Use parent pointer 
        TreeNode parent = null;
        
        while(curr != null)
        {         
            // Make curr node as parent and move forward.
            parent = curr;
            if(curr.val > K)
            {
                curr = curr.left;
            }
            else
            {
                curr = curr.right;
            }
        }
        
        // Check where should new value be added wrt its parent
        if(parent.val > K)
        {
            parent.left = new TreeNode(K);
        }
        else
        {
            parent.right = new TreeNode(K);
        }
        
        return root;
    }
}