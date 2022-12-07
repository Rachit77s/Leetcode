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

    public int rangeSumBST(TreeNode root, int low, int high) {
        
        return RangeSumBSTHelper(root, low, high);
    }
    
    public int RangeSumBSTHelper(TreeNode root, int low, int high) 
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
}