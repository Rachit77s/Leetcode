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

// Striver: https://www.youtube.com/watch?v=D2jMcmxU4bs
class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();
    
//     public BSTIterator(TreeNode root) {
//         // Go all the way on the left while adding in stk till we encounter null    
//         pushAll(root);
//     }
    
//     public int next() {
//         // Pop the top most element, go to right and push all the left nodes in stack.
//         TreeNode temp = stk.pop();
//         pushAll(temp.right);
//         return temp.val;
//     }
    
//     // If stk is not empty I have a list, if it is empty, I don't have list
//     public boolean hasNext() {
//         return !stk.isEmpty();
//     }
    
//     //My function
//     // Take all the left's and push in the stack
//     private void pushAll(TreeNode root)
//     {
//         while(root != null)
//         {
//             stk.push(root);
//             root = root.left;
//         }
//     }
    
    public BSTIterator(TreeNode root)
    {
        stack = new Stack<>();
        //this.isForward = flag;
        
        // Go to extreme left while inserting in stack
        pushAll(root);
    }
    
    public boolean hasNext()
    {
        return !stack.isEmpty();
    }
    
    public int next()
    {
        // Pop the top most element, go to its right and 
        // push all the left nodes in stack.
        TreeNode temp = stack.pop();
        pushAll(temp.right);
        
        return temp.val;
    }
    
    // Take all the left's and push in the stack
    public void pushAll(TreeNode root)
    {
        while(root != null)
        {
            stack.push(root);
            root = root.left;
        }
    }
    
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */