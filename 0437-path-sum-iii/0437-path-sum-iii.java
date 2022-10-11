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
    public int pathSum(TreeNode root, int targetSum) {
        
        return PathSumHelper(root, targetSum);
    }
    
    // T.C: O(N^2)
    public int PathSumHelper(TreeNode root, int targetSum) 
    {
        if(root == null)
            return 0;
        
        // Call for the root
        FindPathSum(root, targetSum);
        
        // Call Helper for the left child and right child
        PathSumHelper(root.left, targetSum);
        PathSumHelper(root.right, targetSum);
        
        return ans;
    }
    
    public void FindPathSum(TreeNode root, long targetSum) 
    {
        if(root == null)
            return;
            
        targetSum -= root.val;
        
        if(targetSum == 0)
            ans++;
            
        FindPathSum(root.left, targetSum);
        FindPathSum(root.right, targetSum);
    }
}