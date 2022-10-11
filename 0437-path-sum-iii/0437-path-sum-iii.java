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
        
        return PathSumHelperUsingMap(root, targetSum);
        // return PathSumHelperRecursive(root, targetSum);
    }
    
    // T.C: O(N^2)
    public int PathSumHelperRecursive(TreeNode root, int targetSum) 
    {
        if(root == null)
            return 0;
        
        // Call for the root
        FindPathSum(root, targetSum);
        
        // Call Helper for the left child and right child
        PathSumHelperRecursive(root.left, targetSum);
        PathSumHelperRecursive(root.right, targetSum);
        
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
    
    // Prerequisite: https://leetcode.com/problems/subarray-sum-equals-k/
    // https://www.youtube.com/watch?v=yyZA4v0x16w
    public int PathSumHelperUsingMap(TreeNode root, int targetSum) 
    {
        if(root == null)
            return 0;
        
        // long is used for case - [1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000] , 0
        HashMap<Long, Integer> map = new HashMap<>();
        map.put((long)0, 1);
        
        // Call for the root
        FindPathSumUsingMap(root, targetSum, map, 0);

        return ans;
    }
    
    // https://www.youtube.com/watch?v=yyZA4v0x16w
    public void FindPathSumUsingMap(TreeNode root, int targetSum, HashMap<Long, Integer> map, long runningSum) 
    {
        if(root == null)
            return;
            
        runningSum += root.val;
        
        if(map.containsKey(runningSum - targetSum))
        {
            int temp = map.get(runningSum - targetSum);
            ans += temp;
        }
            
        map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        
        FindPathSumUsingMap(root.left, targetSum, map, runningSum);
        FindPathSumUsingMap(root.right, targetSum, map, runningSum);
        
        // Remove the frequency of node before returning
        map.put(runningSum, map.get(runningSum) - 1);
        return;
    }
    
}