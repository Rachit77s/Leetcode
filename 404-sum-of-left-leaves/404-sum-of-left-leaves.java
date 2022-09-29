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
    public int sumOfLeftLeaves(TreeNode root) {
        
        return Recursive(root);
        
        // return Level(root);
    }
    
    public int Level(TreeNode root)
    {   
        if(root == null) 
            return 0;

        // Single node
        if(root.left == null && root.right == null)
            return 0;
        
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            //  ArrayList<Integer> tempList = new ArrayList<>();
            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++)
            {
                TreeNode curr = queue.peek();
                queue.remove();

                if(curr.left != null && curr.left.left == null && curr.left.right == null)
                    sum = sum + curr.left.val;
                
                if(curr.left != null)
                    queue.add(curr.left);

                if(curr.right != null)
                    queue.add(curr.right);
            }
        }

        return sum;
    }
    
    public int StackDFS(TreeNode root)
    {   
        if(root == null) 
            return 0;

        // Single node
        if(root.left == null && root.right == null)
            return 0;
        
        int sum = 0;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode curr = root;

        while(!stk.isEmpty() || curr != null)
        {
            if(curr != null)
            {
                if(curr.left != null && curr.left.left == null && curr.left.right == null)
                    sum = sum + curr.left.val;
                
                stk.push(curr);
                curr = curr.left;
            }
            else
            {
                TreeNode temp = stk.pop();
                
                if(temp.right != null && temp.right.left == null)
                    sum = sum + temp.right.val;
                
                curr = temp.right;
            }
        }

        return sum;
    }
    
    public int Recursive(TreeNode root)
    {
        if(root == null) 
            return 0;
        
        int result = 0;
        
        if(root.left != null && root.left.left == null && root.left.right == null)
                result = result + root.left.val;
        
        return result + Recursive(root.left) + Recursive(root.right);
    }
}


