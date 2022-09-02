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
    
    public boolean isSymmetric(TreeNode root) {
        
        // return UsingQueue(root);
        //return UsingStack(root);
         return Recursion(root.left, root.right); 
    }
    
    public boolean Recursion(TreeNode leftSubtree, TreeNode rightSubtree) 
    {
        if(leftSubtree == null && rightSubtree == null)
            return true;
        
        if(leftSubtree == null || rightSubtree == null)
            return false;
 
        if(leftSubtree.val != rightSubtree.val)
            return false;
 
        return  Recursion(leftSubtree.left, rightSubtree.right) &&
                Recursion(leftSubtree.right, rightSubtree.left);
    }
    
    public boolean UsingStack(TreeNode root) 
    {
        // Comments:
        // https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/627/discuss/33054/Recursive-and-non-recursive-solutions-in-Java
        
        if (root == null) 
            return true;
        
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.empty())
        {
            TreeNode n1 = stack.pop();
            TreeNode n2 = stack.pop();
            
            if(n1 == null && n2 == null)
                continue;
            
            if(n1 == null || n2 == null || n1.val != n2.val)
                return false;
            
            stack.push(n1.left);
            stack.push(n2.right);
            
            stack.push(n1.right);
            stack.push(n2.left);
        }
        
        return true;
    }
    
    public boolean UsingQueue(TreeNode root) 
    {
        // Comments:
        // https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/627/discuss/33152/Short-and-clean-java-iterative-solution
        if (root == null) 
            return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty())
        {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            
            if(n1 == null && n2 == null)
                continue;
            
            if(n1 == null || n2 == null || n1.val != n2.val)
                return false;
            
            queue.add(n1.left);
            queue.add(n2.right);
            
            queue.add(n1.right);
            queue.add(n2.left);
        }
        
        return true;
    }
}