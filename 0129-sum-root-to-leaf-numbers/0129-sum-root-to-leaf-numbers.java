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
    public int sumNumbers(TreeNode root) {
        
        return Iterative(root);
        // return DFS(root, 0);
    }

    // Comments:
    // https://leetcode.com/problems/sum-root-to-leaf-numbers/solutions/41363/short-java-solution-recursion/
    public int DFS(TreeNode root, int sum) 
    {
        if(root == null) 
            return 0;

        sum = sum * 10 + root.val;

        // Focus on 1 node & check for possibilities of that node being the leaf!
        if(root.left == null && root.right == null)
            return sum;
            
        // Generalize that logic to all other nodes be it right or left subtree!
        int leftSum = DFS(root.left, sum);
        int rightSum = DFS(root.right, sum);
        
        return leftSum + rightSum;
    }

    public int Iterative(TreeNode root) 
    {
        Stack<Pair<TreeNode, Integer>> stk = new Stack<>();
        stk.push(new Pair(root, 0));
        int sum = 0;
        int currSum = 0;
        
        while(!stk.isEmpty())
        {
            Pair<TreeNode, Integer> temp = stk.pop();

            currSum = 10 * temp.getValue() + temp.getKey().val;

            if(temp.getKey().left == null && temp.getKey().right == null)
                sum = sum + currSum;

            if(temp.getKey().right != null) 
                stk.push(new Pair(temp.getKey().right, currSum));
            
            if(temp.getKey().left != null)  
                stk.push(new Pair(temp.getKey().left, currSum));
        }

        return sum;
    }
}