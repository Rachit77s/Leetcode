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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        return Iterative(p, q);
        
        // return Recursion(p, q);
    }
    
    public boolean Recursion(TreeNode p, TreeNode q) 
    {
        if(p == null && q == null)
            return true;
        
        if(p == null || q == null)
            return false;
        
        if(p.val == q.val)
            return Recursion(p.left, q.left) & Recursion(p.right, q.right);
        
        return false;
    }
    
    public boolean Iterative(TreeNode p, TreeNode q) 
    {
        if(p == null && q == null)
            return true;
        
        if(p == null || q == null)
            return false;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(p);
        queue.add(q);

        while (!queue.isEmpty())
        {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            
            if(n1 == null && n2 == null)
                continue;
            
            if(n1 == null || n2 == null)
                return false;
        
            if(n1.val != n2.val)
                return false;

            queue.add(n1.left);
            queue.add(n2.left);

            queue.add(n1.right);
            queue.add(n2.right);
            
        }
        
       return true;
    }
}