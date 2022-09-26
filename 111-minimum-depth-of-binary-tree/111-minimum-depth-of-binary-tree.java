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
    int minVal = 0;
    public int minDepth(TreeNode root) {
        
        return LevelOrder(root);
    }
    
    public int LevelOrder(TreeNode root) 
    {
        if(root == null)
            return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;  
        
        while(!q.isEmpty())
        {
            int qSize = q.size();
            
            for(int i = 0; i < qSize; i++)
            {
                TreeNode temp = q.poll();
                
                if(temp.left == null && temp.right == null)
                    return level;
                
                if(temp.left != null)
                    q.offer(temp.left);
                
                if(temp.right != null)
                    q.offer(temp.right);
            }
            
            level++;
        }
        
        return level;
    }
}