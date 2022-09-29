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
        
        // return Recursive(root);
        return StackDFS(root);
        // return Level(root);
    }
         
    public int Recursive(TreeNode root)
    {
        if(root == null) 
            return 0;
        
        int result = 0;
        
        // Focus on one node and checks for various possibilities of that node being 
        // the left leaf!!!!
        if(root.left != null && root.left.left == null && root.left.right == null)
                result = result + root.left.val;
        
        // Then generalize that logic to all other nodes be it right or left subtree!
        return result + Recursive(root.left) + Recursive(root.right);
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
        
        int sum = 0;
        TreeNode curr = root;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        
        stk.push(curr);

        while(!stk.isEmpty())
        {
            TreeNode temp = stk.pop();
            
            if(temp.left != null)
            {
                if(temp.left.left == null && temp.left.right == null)
                    sum = sum + temp.left.val;
                else
                    stk.push(temp.left);
            }
            
            if(temp.right != null)
            {   
                stk.push(temp.right);
            }
        }

        return sum;
    }
}


