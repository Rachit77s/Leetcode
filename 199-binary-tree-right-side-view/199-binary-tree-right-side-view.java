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
        
        return UsingIteration(root);
        // List<Integer> ans = new ArrayList<Integer>();
        // UsingRecursion(root, 0, ans);
        // return ans;
    }
    
    public List<Integer> UsingIteration(TreeNode root) 
    {
        if(root == null)
            return new ArrayList<Integer>();
        
        List<Integer> ans = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            int level = q.size();
            
            for(int i = 0; i < level; i++)
            {
                TreeNode curr = q.peek();
                q.remove();
                
                if(i == level - 1)
                    ans.add(curr.val);
                
                if(curr.left != null)
                    q.add(curr.left);
                
                if(curr.right != null)
                    q.add(curr.right);
            }
        }
        
        
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