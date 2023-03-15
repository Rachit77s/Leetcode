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
    public boolean isCompleteTree(TreeNode root) {
        
        return LevelOrder(root);
    }
    
    public boolean LevelOrder(TreeNode root) 
    {
        // Idea is if we do a level order traversal and we see a non emptyNode followed by an empty node, it isn't a complete binary tree.
        // Or in other terms, When level-order traversal in a complete tree, after the last node, all nodes in the queue should be null.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean seenLastNode = false;
        
        while(!queue.isEmpty())
        {
            TreeNode curr = queue.poll();
            
            if(curr == null)
            {
                seenLastNode = true;
                continue;
            }
            else if(seenLastNode == true)
                return false;
            
            queue.add(curr.left);
            queue.add(curr.right);
        }
        
        return true;
    }
    
    public boolean LevelOrderWrongApproach(TreeNode root) 
    {
        if(root == null)
            return false;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty())
        {
            int level = q.size();
            
            for(int i = 0; i < level; i++)
            {
                TreeNode temp = q.remove();
                
                if(temp.left == null && temp.right != null)
                    return false;
                
                if(i != level - 1 && temp.left != null && temp.right == null)
                    return false;
                
                if(temp.left != null)
                    q.add(temp.left);
                
                if(temp.right != null)
                    q.add(temp.right);
            }
        }
        
        return true;
    }
}

//   2
//  3  4