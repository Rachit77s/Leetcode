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
    public TreeNode invertTree(TreeNode root) {
        
        return LevelOrder(root);
        //Invert(root);
        //return root;
    }
    
    public void Invert(TreeNode root) 
    {
        if(root == null)
            return;
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        Invert(root.left);
        Invert(root.right);
    }
    
    public TreeNode LevelOrder(TreeNode root)
    {
        if(root == null)
            return null;
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        while (q.size() > 0)
        {
            // pop top node from queue
            TreeNode curr = q.peek();
            q.remove();

            // swap left child with right child
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            // push left and right children
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
        
        return root;
    }
}