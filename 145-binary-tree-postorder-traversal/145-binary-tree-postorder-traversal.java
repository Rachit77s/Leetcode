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
    public List<Integer> postorderTraversal(TreeNode root) {
        return Postorder(root);
    }
    
    public List<Integer> Postorder(TreeNode A) 
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
                curr = curr.right;
            }
            else
            {
                TreeNode topNode = stk.pop();
                curr = topNode.left;
            }
        }
        
        Collections.reverse(ans);
        return ans;
    }
}