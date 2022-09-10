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
    public TreeNode searchBST(TreeNode root, int val) {
        
        return Recursive(root, val);
    }
    
    public TreeNode Recursive(TreeNode root, int K) 
    {
        // Node not found
        if(root == null)
            return null;
        
        if(root.val == K)
            return root;
        
        if(root.val > K)
            return Recursive(root.left, K);
        else
            return Recursive(root.right, K);
    }
    
//     public TreeNode Iterative(TreeNode root, int K) 
//     {   
//         TreeNode curr = root;
        
//         while(curr != null)
//         {
//             if(curr.val == K)
//                 return curr;
            
//             if(curr.val > K)
//                 curr = curr.left;
//             else
//                 curr = curr.right;
//         }
        
//         return curr;
//     }
}