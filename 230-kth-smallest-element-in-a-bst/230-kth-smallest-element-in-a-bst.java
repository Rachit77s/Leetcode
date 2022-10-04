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
    int[] cnt = new int[1];
    public int kthSmallest(TreeNode root, int k) {
        
        return Iterative(root, k);
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
}