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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        return Preorder(root);
    }
    
    public List<Integer> Preorder(TreeNode A) 
    {
        List<Integer> ans = new ArrayList<Integer>();
        
        if(A == null)
            return new ArrayList<Integer>();
        
        Stack<TreeNode> stk = new Stack<TreeNode>();    
        TreeNode curr = A;
        
        while(!stk.isEmpty() || curr != null)
        {
            //If element is not null, go left
            if(curr != null)
            {            
                //Print
                ans.add(curr.val);   
                stk.push(curr);
                //Go left
                curr = curr.left;
            }
            else
            {
                //If curr element is null, this maybe due to 4.left = null
                // Pop the top element and travel to its right
                TreeNode topNode = stk.pop();
                // go right
                curr = topNode.right;
            }
        }
        
        return ans;
    }
}