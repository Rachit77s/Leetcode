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
    int max = 0;
    public int maxDepth(TreeNode root) {
         return Iterative(root);
    }
    
    public int Iterative(TreeNode root)
    {
        if(root == null)
            return 0;
        
        int height = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(q.size() != 0)
        {
            height = height + 1;
            int levelSize = q.size();
            
            for(int i = 0; i < levelSize; i++)
            {
                TreeNode temp = q.remove();
                
                if(temp.left != null)
                    q.add(temp.left);
                
                if(temp.right != null)
                    q.add(temp.right);
            }
        }
        
        return height;
    }
    
    public int Recursive(TreeNode root)
    {
        if(root == null)
            return 0;
        
        int leftHeight = Recursive(root.left);
        int rightHeight = Recursive(root.right);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}