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
    public TreeNode bstFromPreorder(int[] preorder) {
        
        return BruteForceHelper(preorder);
    }
    
    
    public TreeNode BruteForceHelper(int[] preorder)
    {
        return BruteForce(preorder, 0, preorder.length - 1);
    }
    
    // T.C.: O(N^2)
    // https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/discuss/589059/JAVA-EASIEST-SOLUTION-WITH-CLEAR-EXPLANATION-OF-LOGIC!
    public TreeNode BruteForce(int[] preorder, int start, int end)
    {
        if(start > end)
            return null;
        
        TreeNode root = new TreeNode(preorder[start]);
        
        // Find the next higher element
        int i;
        for(i = start; i <= end; i++)
        {
            if(preorder[i] > root.val)
                break;
        }
        
        root.left = BruteForce(preorder, start + 1 , i - 1);
        root.right = BruteForce(preorder, i, end);
        
        return root;
    }
}