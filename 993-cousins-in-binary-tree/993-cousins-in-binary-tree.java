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
    public boolean isCousins(TreeNode root, int x, int y) {
        
        return IterativeBFS(root, x, y);
    }
    
    public boolean IterativeBFS(TreeNode root, int x, int y) 
    {    
        /*
          To be a cousins, below condition should met
            1. Level should be same
            2. Parent node should be different
        */
        
        /*
            Sol 1: Check level of two nodes x and y(it should be equal), and
                   if curr left and right is x and y, 
                   it means they have same parent, return false
        */
        
        if(root == null)
            return false;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
            boolean xExists = false;
            boolean yExists = false;
            int qSize = q.size();
            
            for(int i = 0; i < qSize; i++)
            {
                TreeNode curr = q.poll();
                
                if(curr.val == x)
                    xExists = true;
                
                if(curr.val == y)
                    yExists = true;
                
                // Check if the curr node is parent of its children, return false
                if(curr.left != null && curr.right != null)
                {
                    if(curr.left.val == x && curr.right.val == y)
                        return false;
                    
                    if(curr.left.val == y && curr.right.val == x)
                        return false;
                }
                
                if(curr.left != null)
                    q.offer(curr.left);
                
                if(curr.right != null)
                    q.offer(curr.right);
            }
            
            if(xExists == true && yExists == true)
                return true;
        }
        
        return false;
    }
}