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
    public boolean isBalanced(TreeNode root) {
        
        return IsHeightBalancedOptimised(root).isBalanced;
        
        //return IsHeightBalancedBruteForce(root);
    }
    
    public class Info 
    {
        public boolean isBalanced;
        public int height;

        public Info (boolean isBalanced, int height)
        {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public Info IsHeightBalancedOptimised(TreeNode root)
    {
        /*
            What is the minimum information every node requires from its subtrees
            1. Height of its LST.
            2. Height of its RST.
            3. Whether the LST and RST are balanced or not.
        */
        
        if(root == null)
            return new Info(true, 0);

        // Check for each and every node
        Info left = IsHeightBalancedOptimised(root.left);
        Info right = IsHeightBalancedOptimised(root.right);
        // Access properties of left and right and check the condition
        boolean condition = Math.abs(left.height - right.height) <= 1;
        
        // If all the 3 conditions match, return true.
        if(left.isBalanced == true && right.isBalanced == true && condition == true)
            return new Info(true, 1 + Math.max(left.height, right.height)); 
        // Return the height as well.
        else
            return new Info(false, 0);
    }
    
    public boolean IsHeightBalancedBruteForce(TreeNode root)
    {
        if(root == null)
            return true;
        
        boolean left = IsHeightBalancedBruteForce(root.left);
        boolean right = IsHeightBalancedBruteForce(root.right);
        boolean condition = Math.abs(Height(root.left) - Height(root.right)) <= 1;
        
        if(left == true && right == true && condition == true)
            return true;
        else
            return false;
    }
    
    public int Height(TreeNode root)
    {
        if(root == null)
            return 0;

        int left = Height(root.left);
        int right = Height(root.right);

        return 1 + Math.max(left, right);
    }
}