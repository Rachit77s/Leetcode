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

    int recurSum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        RangeSumBSTRecursive(root, low, high);
        return recurSum;
        
        // return RangeSumBSTIterative(root, low, high);
    }
    
    public int RangeSumBSTIterative(TreeNode root, int low, int high) 
    {
        int sum = 0;
        
        if(root == null)
            return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
            int lvlSize = q.size();
            
            for(int i = 0; i < lvlSize; i++)
            {
                TreeNode curr = q.poll();
                
                if(low <= curr.val && curr.val <= high)
                    sum += curr.val;
                
                if(curr.left != null)
                    q.offer(curr.left);
                
                if(curr.right != null)
                    q.offer(curr.right);
            }

        }
        
        return sum;
    }
    
    public void RangeSumBSTRecursive(TreeNode root, int low, int high) 
    {
        if(root == null)
            return;
        
        if(root.val >= low && root.val <= high)
            recurSum += root.val;
        
        if(root.val > low)
            RangeSumBSTRecursive(root.left, low, high);
        
        if(root.val < high)
            RangeSumBSTRecursive(root.right, low, high);
    }
}