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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        Backtrack(root, targetSum, ans, new ArrayList<Integer>());
        
        return ans;
    }
    
    public void Backtrack(TreeNode root, int targetSum, List<List<Integer>> ans,
                                      List<Integer> tempList) 
    {
        if(root == null)
            return;
        
        tempList.add(root.val);
        
        if(root.left == null && root.right == null && targetSum == root.val)
        {
            ans.add(new ArrayList<Integer>(tempList));
            tempList.remove(tempList.size() - 1);//don't forget to remove the last integer
            return;
        }
        
        Backtrack(root.left, targetSum - root.val, ans, tempList);
        Backtrack(root.right, targetSum - root.val, ans, tempList);
        
        tempList.remove(tempList.size() - 1);  
    }
}