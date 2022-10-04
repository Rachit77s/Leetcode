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
   
    int count = 0;
    int result = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        
        Recursion(root, k);
        return result;
        // return Iterative(root, k);
    }
    
    public int Iterative(TreeNode root, int k)
    {
        if(root == null)
            return 0;

        int ans = 0;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode curr = root;

        while(curr != null || !stk.isEmpty())
        {
            if(curr != null)
            {                
                stk.push(curr);
                curr = curr.left;
            }
            else
            {
                TreeNode temp = stk.pop();
                
                k = k - 1;
                
                if(k == 0)
                    ans = temp.val;
                
                curr = temp.right;
            }
        }

        return ans;
    }
    
    public void Recursion(TreeNode root, int k) 
    {
        if(root == null)
            return;
        
        Recursion(root.left, k);
        
        count++;
        
        if(count == k)
            result = root.val;

        Recursion(root.right, k);
    }
}