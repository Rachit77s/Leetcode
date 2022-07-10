/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public IList<IList<int>> ZigzagLevelOrder(TreeNode root) 
    {       
        List<IList<int>> ans = new List<IList<int>>();
        
        if(root == null)
            return ans;
        
        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root);
		bool rightToLeft = false;
		
		while(queue.Count != 0)
		{
			List<int> row = new List<int>();
            int size = queue.Count;
            
            for(int i = 0; i < size; i++)
			{
				TreeNode currNode = queue.Dequeue();
				
				if(rightToLeft == true)
				{
					row.Insert(0, currNode.val);
				}
				else
				{
					row.Add(currNode.val);
				}
				
				if(currNode.left != null)
					queue.Enqueue(currNode.left);
					
				if(currNode.right != null)
					queue.Enqueue(currNode.right);
			}
			
			ans.Add(row);
			rightToLeft = !rightToLeft;
		}
		
		return ans;
    }
}