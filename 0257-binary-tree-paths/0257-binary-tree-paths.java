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
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> result = new ArrayList<>(); 
        
        if(root != null)
        {
            String str = "";
            Recursive(root, str, result);
        }
        
        return result;
    }
    
    public void Recursive(TreeNode root, String str, List<String> ans)
    {
        if(root == null)
            return;
        
        str = str + root.val;
        
        if(root.left == null && root.right == null)
        {
            ans.add(str);
            //str = str.substring(0, str.length() - 1); 
            //return;
        }
        
        Recursive(root.left, str + "->", ans);
        Recursive(root.right, str + "->", ans);
        
        str = str.substring(0, str.length() - 1);    
    }
}