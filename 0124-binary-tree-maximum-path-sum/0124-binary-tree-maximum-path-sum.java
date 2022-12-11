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
    public int maxPathSum(TreeNode root) {
        
        return MaxPathHelper(root);
    }

    public int MaxPathHelper(TreeNode root)
    {
        if(root == null)
            return 0;
        
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        
        MaxPathModifiedHeightFunction(root, ans);

        return ans[0];
    }
    

    // Striver: https://www.youtube.com/watch?v=WszrfSwMz58
    // Aditya: https://www.youtube.com/watch?v=Osz-Vwer6rw
    // https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/603423/Python-Recursion-stack-thinking-process-diagram
    // https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/389609/Full-Explanation-article-with-pseudo-code-Beats-JAVA-100-time-and-100-space-Solution
    public int MaxPathModifiedHeightFunction(TreeNode root, int[] ans)
    {
        // Max Height of Binary Tree concept
        // For any node, max path can be node itself +
        // max path on its left, + max path on its right
        // For a node = its value + LST + RST will give max path
        // Do this for every node, and get max among all the nodes
        
        if(root == null)
            return 0;
        
        int maxGainOnLeftSubTree = MaxPathModifiedHeightFunction(root.left, ans);
        int maxGainOnRightSubTree = MaxPathModifiedHeightFunction(root.right, ans);
        
        // Do not consider -ve sum, as we need max path sum
        if(maxGainOnLeftSubTree < 0)
            maxGainOnLeftSubTree = 0;
        
        if(maxGainOnRightSubTree < 0)
            maxGainOnRightSubTree = 0;
        
        // ans[0] is the value which is recording whether this current root is the final root, so we use left + right + node.val. But to the upper layer(after return statement), we cannot choose both left and right brunches, so we need to select the larger one, so we use max(left, right) + node.val to prune the lower brunch.
        // Get the max path at the current node, do this across all nodes.
        ans[0] = Math.max(ans[0], maxGainOnLeftSubTree + maxGainOnRightSubTree + root.val);
        
        // Max path can either be on LST or RST and not both, think!!
        // return 1 + Max(leftHeight, rightHeight);
        return root.val + Math.max(maxGainOnLeftSubTree, maxGainOnRightSubTree);
    }
}

