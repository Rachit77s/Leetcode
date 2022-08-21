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
    public boolean isValidBST(TreeNode root) {
        
        return BSTHelperIncreasingOrder(root);
        // return RangeBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        //return NullBSTHelper(root, null, null);
    }
    
    private long value = Long.MIN_VALUE;
    public boolean BSTHelperIncreasingOrder(TreeNode root)
    {
        // The inorder traversal of valid BST is always sorted in ascending order
        // So, using one variable[value] to check 
        // If at every nodeValue in inorder traversal its increasing or not. 
        // If it is not increasing -> return false else return true;
        
        if (root == null)
        {
            //value = 1;
            return true;
        }
            
        boolean leftSubTreeValue = BSTHelperIncreasingOrder(root.left);
        
        if(root.val > value)
        {
            value = root.val;
        }
        else
        {
            value = 0;
            return false;
        }
        
        boolean rightSubTreeValue = BSTHelperIncreasingOrder(root.right);

        return leftSubTreeValue & rightSubTreeValue;       
    }
    
    public boolean BSTHelperInorderTraversal(TreeNode root)
    {
        if (root == null) 
            return true;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode prevNode = null;
        
        while (curr != null || !stack.isEmpty())
        {
            if(curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            else
            {
                curr = stack.pop();                
                // Fail fast
                if(prevNode != null && curr.val <= prevNode.val)
                    return false;
                
                prevNode = curr;
                curr = curr.right;
            }
        }
        
        return true;
    }
    
    public boolean RangeBSTHelper(TreeNode root, long minRange, long maxRange)
    {
        if(root == null)
            return true;
        
        // The current node's value must be between low and high.
        if((root.val <= minRange) || (root.val >= maxRange))
            return false;
        
        // The left and right subtree must also be valid.
        return RangeBSTHelper(root.left, minRange, root.val) && RangeBSTHelper(root.right, root.val , maxRange);
    }
    
    public boolean NullBSTHelper(TreeNode root, TreeNode left, TreeNode right)
    {
        if(root == null)
            return true;
        
        // The current node's value must be between low and high.
        if((left != null && root.val <= left.val) || (right != null && root.val >= right.val))
            return false;
        
        // The left and right subtree must also be valid.
        return NullBSTHelper(root.left, left, root) && NullBSTHelper(root.right, root , right);
    }
}