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
    
    private long totalSum = 0;
    private long maxProduct = 0;
    
    public int maxProduct(TreeNode root) {
        
        GetTotalSum(root);
        System.out.print(totalSum);
        GetSubTreeSum(root);

        return (int)(maxProduct % ((int)Math.pow(10, 9) + 7));
    }
    
    public void GetTotalSum(TreeNode root)
    {   
        if(root == null)
            return;
        
        GetTotalSum(root.left);
        GetTotalSum(root.right);
        
        totalSum += root.val;
    }
    
    public long GetSubTreeSum(TreeNode root)
    {
        if(root == null)
            return 0;
        
        long left = GetSubTreeSum(root.left);
        long right = GetSubTreeSum(root.right);
        
        long subTreeSum = left + right + root.val;
        
        maxProduct = Math.max(maxProduct, (subTreeSum) * (totalSum - subTreeSum));
        
        return subTreeSum;
    }
}