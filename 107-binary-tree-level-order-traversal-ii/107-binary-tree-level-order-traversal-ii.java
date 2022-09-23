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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        return ReversLevelOrder(root);
    }
    
    public List<List<Integer>> ReversLevelOrder(TreeNode root) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null)
            return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            int level = q.size();
            List<Integer> tempList = new ArrayList<>();
            
            for(int i = 0; i < level; i++)
            {
                TreeNode temp = q.poll();
                tempList.add(temp.val);
                
                if(temp.left != null)
                    q.add(temp.left);
                
                if(temp.right != null)
                    q.add(temp.right);                         
            }
            
            ans.add(tempList);
        }
        
        Collections.reverse(ans);
            
        return ans;
    }
}

// 3 9 20 15 7
// 7 15 20 9 3

// 3 20 9 7 15
// 15 7 9 20 3

// 3 9 20 15 7
// 