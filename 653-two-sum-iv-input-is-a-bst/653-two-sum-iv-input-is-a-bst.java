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
    public boolean findTarget(TreeNode root, int k) {
        
        return BruteForce(root, k);
    }
    
    public boolean BruteForce(TreeNode root, int k) 
    {
        if(root == null)
            return false;
        
        ArrayList<Integer> treeList = new ArrayList<>();
        
        TreeNode curr = root;
        Stack<TreeNode> stk = new Stack<>();
        
        while(!stk.isEmpty() || curr != null)
        {
            if(curr != null)
            {
                stk.push(curr);
                curr = curr.left;
            }
            else
            {
                TreeNode temp = stk.pop();
                treeList.add(temp.val);
                curr = temp.right;
            }
        }
        
        // 2 Sum
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < treeList.size(); i++)
        {
            if(set.contains(k - treeList.get(i)))
                return true;
            
            set.add(treeList.get(i));
        }
        
        return false;
    }
}