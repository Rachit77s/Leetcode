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
    
    // https://www.youtube.com/watch?v=4mTFS1ls3ho
    public boolean IterativeBFS(TreeNode root, int x, int y) 
    {    
        /*
          To be a cousins, below condition should met
            1. Level should be same
            2. Parent node should be different i.e. parent should not be same for 2 nodes

            Aliter Sol 1: Check level of two nodes x and y(it should be equal), and
                   if curr left and right is x and y, 
                   it means they have same parent, return false

            Algo:
            1. Assume x & y nodes are not there, so bool false.
            2. For every level, check if curr node is x & y and also
               if curr node is parent of x & y, return false.
            3. If we found x & y and also their parents are diff., return true
        */
        
        if(root == null)
            return false;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
            // To check x & y present at the same level or not
            // If they are at same level, both x & y will be true
            boolean xExists = false;
            boolean yExists = false;
            int qSize = q.size();
            
            for(int i = 0; i < qSize; i++)
            {
                TreeNode curr = q.poll();
                
                // Check if x is present
                if(curr.val == x)
                    xExists = true;
                
                // Check if y is present
                if(curr.val == y)
                    yExists = true;
                
                // Check if curr node is parent of x & y, if yes return false
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
            
            // Found two diff nodes whose left and right child is equal to x & y
            if(xExists == true && yExists == true)
                return true;
        }
        
        return false;
    }
}