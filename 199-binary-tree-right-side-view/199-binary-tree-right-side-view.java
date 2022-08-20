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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans = new ArrayList<Integer>();
        UsingRecursion(root, 0, ans);
        return ans;
    }
    
    public void UsingRecursion(TreeNode root, int level, List<Integer> ans) 
    {
        if(root == null)
            return;

        if(level == ans.size())
            ans.add(root.val);
        
        UsingRecursion(root.right, level + 1, ans);
        UsingRecursion(root.left, level + 1, ans);
    }
}