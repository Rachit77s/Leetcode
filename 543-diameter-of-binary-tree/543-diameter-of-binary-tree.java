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
    
    int diameter = -1;
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        DiameterMostOptimised(root);
        return diameter;
        // return DiameterBruteForce(root);
    }
    
    // Scaler VideoSolution
    public int DiameterMostOptimised(TreeNode root)
    {
        if(root == null)
            return -1;
        
        int left = DiameterMostOptimised(root.left);
        int right = DiameterMostOptimised(root.right);
        
        //int currHeight = 1 + Math.max(left, right);
        
        diameter = Math.max(diameter, 2 + left + right);
        
        //return currHeight;
        return 1 + Math.max(left, right);
    }
    
    public int DiameterBruteForce(TreeNode root)
    {
        /*
            Diameter is the length of the longest path between any two nodes in a tree. Hence we need to traverse in both the directions. Height is single dimension.
            
            In this solution, height and diameter of a single node is considered as 0. And of null node is considered as -1.
        */
        
        if(root == null)
            return -1;
        
        int leftHeight = ModifiedHeight(root.left);
        int rightHeight = ModifiedHeight(root.right);
        
        // Compute diameter for each and every node
        int diameterLeft = DiameterBruteForce(root.left);
        int diameterRight = DiameterBruteForce(root.right);
        int diameterThroughRoot = leftHeight + rightHeight + 2;
        
        return Math.max(diameterThroughRoot, Math.max(diameterLeft, diameterRight));
    }   
    
    public int ModifiedHeight(TreeNode root)
    {
        /*
            Here we are calculating height by the edges instead of the normal approach of nodes. Normally, we used to assume height of null node to be 0, but here in this questions, we need to assume height of null node as -1.
            Thereby height of single node would be Max(-1, -1) + 1 => 0
        */
        
        if(root == null)
            return -1;
        
        int left = ModifiedHeight(root.left);
        int right = ModifiedHeight(root.right);
        
        return 1 + Math.max(left, right);
    }
}