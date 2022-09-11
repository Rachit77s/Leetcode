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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        return Inorder(root);
    }
    
    public List<Integer> Inorder(TreeNode root) 
    {
        List<Integer> ans = new ArrayList<>();
        
        if(root == null)
            return ans;
        
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode curr = root;
        
        while(!stk.isEmpty() || curr != null)
        {
            if(curr != null)
            {
                stk.push(curr);
                curr = curr.left;    
            }
            else
            {
                curr = stk.pop();
                ans.add(curr.val);
                curr = curr.right;
            }
        }
        
        return ans;
    }
    
    public List<Integer> MorrisTraversal(TreeNode root) 
    {
        List<Integer> ans = new ArrayList<>();
        
        if(root == null)
            return ans;
        
        TreeNode curr = root;
        
        while(curr != null)
        {
            if(curr.left == null)
            {
                ans.add(curr.val);
                // Go right since left is null.
                // Also once the thread is created we can go to the parent node
                // using this.
                curr = curr.right;
            }
            else
            {
                // If the left node exists, get the right most last node on RST
                TreeNode prev = curr.left;
                
                while(prev.right != null && prev.right != curr)
                    prev = prev.right;
                
                if(prev.right == null)
                {
                    // Create the thread
                    prev.right = curr;
                    // Move onto the next node
                    curr = curr.left;
                }
                else
                {
                    // Thread already exists, break the thread
                    prev.right = null;
                    // Curr node is the root
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }
                    
        return ans;
    }
    
}