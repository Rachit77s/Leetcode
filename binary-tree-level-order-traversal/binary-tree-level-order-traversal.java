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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        return levelOrderTraversal(root);
    }
    
    public List<List<Integer>> levelOrderTraversal(TreeNode root) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null)
            return ans;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            List<Integer> tempList = new ArrayList<Integer>();
            
            // Get the size of every level before traversal
            int levelSize = queue.size();
            
            for(int i = 0; i < levelSize; i++)
            {
                TreeNode curr = queue.peek();
                queue.remove();
                
                tempList.add(curr.val);
                
                if(curr.left != null)
                    queue.add(curr.left);

                if(curr.right != null)
                    queue.add(curr.right);
            }
            
            ans.add(tempList);
        }
        
        return ans;
    }
}