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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        return LeetcodeDiscuss(root);
    }
    
    public List<List<Integer>> ZigZagUsingQueueBabbar(TreeNode root) 
    {
        // https://www.youtube.com/watch?v=s1d8UGDCCN8&list=PLDzeHZWIZsTo87y1ytEAqp7wYlEP3nner&index=4
        
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null) 
            return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        boolean leftToRight = true;
        
        while(!queue.isEmpty())
        {   
            int levelSize = queue.size();
            //List<Integer> subList = Arrays.asList(new Integer[levelSize]);//new ArrayList<>(levelSize);
            
            // Note this step, else you will get CTE.
            List<Integer> subList = new ArrayList<>(levelSize);
            for(int i = 0; i < levelSize; i++) 
                subList.add(0);
            
            for(int i = 0; i < levelSize; i++)
            {
                TreeNode tempNode = queue.peek();
                queue.remove();
                
                // Normal insert or reverse insert in subList
                int index = 0;
                if(leftToRight == true)
                    index = i; 
                else
                    index = levelSize - i - 1;

                // find position to fill node's value
                // int index = (leftToRight) ? i : (levelSize - 1 - i);
                
                // System.out.print(index);
                subList.set(index, tempNode.val);
                // subList.add(2, 25);
                
                                
                // if(leftToRight == true){
                //     subList.set(i, tempNode.val);
                // }else{
                //     subList.set(levelSize - 1 - i, tempNode.val);
                // }

                if(tempNode.left != null)
                    queue.add(tempNode.left);
                
                if(tempNode.right != null)
                    queue.add(tempNode.right);
            }
            
            ans.add(subList);
            
            // Reverse the polarity of bool
            leftToRight = !leftToRight;
        }
        
        return ans;
    }
    
    public List<List<Integer>> Approach2(TreeNode root) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null) 
            return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean rightToLeft = false;

        while (!queue.isEmpty())
        {
            List<Integer> level = new ArrayList<>();
            int cnt = queue.size();

            for (int i = 0; i < cnt; i++)
            {
                TreeNode node = queue.poll();
                
                if (rightToLeft == true) 
                {
                    level.add(0, node.val);
                }
                else 
                {
                    level.add(node.val);
                }

                if (node.left != null) 
                {
                    queue.add(node.left);
                }

                if (node.right != null) 
                {
                    queue.add(node.right);
                }
            }

            ans.add(level);
            rightToLeft = !rightToLeft;
        }

        return ans;
    }
    
    public List<List<Integer>> GFG(TreeNode root) 
    {
        if (root == null)
        {
            return new ArrayList();
        }
        
        List<List<Integer>> ans = new ArrayList<>();
     
        // declare two stacks
        Stack<TreeNode> currentStack = new Stack<TreeNode>();
        Stack<TreeNode> nextStack= new Stack<TreeNode>();
        
        currentStack.push(root);
            
        boolean leftToRight = true;
        
        while(currentStack.size() != 0)
        {
            TreeNode node = currentStack.pop();
            
            if(leftToRight == true)
            {
                if (node.left != null)
                    nextStack.push(node.left);
                
                if (node.right != null)
                    nextStack.push(node.right);
            }
            else
            {                
                if (node.right != null)
                    nextStack.push(node.right);
                
                if (node.left != null)
                    nextStack.push(node.left);
            }
                
            if(currentStack.isEmpty())
            {
                leftToRight = !leftToRight;
                // swap these two stacks 
                Stack<TreeNode> temp = currentStack;
                currentStack = nextStack;
                nextStack = temp;
            }
        }
        
        return ans;
    }
    
    public List<List<Integer>> LeetcodeDiscuss(TreeNode root) 
    {
        // https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/discuss/33904/JAVA-Double-Stack-Solution
        
       // TreeNode c=root;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if(root == null) 
           return ans;
        
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root);
        
        while(!s1.isEmpty() || !s2.isEmpty())
        {
            List<Integer> tempList = new ArrayList<Integer>();
            TreeNode tempNode;
            
            while(!s1.isEmpty())
            {
                tempNode = s1.pop();
                tempList.add(tempNode.val);
                
                if(tempNode.left != null) 
                    s2.push(tempNode.left);
                
                if(tempNode.right != null) 
                    s2.push(tempNode.right);
            }
            
            ans.add(tempList);
            
            // Re-initialise
            tempList = new ArrayList<Integer>();
            
            while(!s2.isEmpty())
            {
                tempNode = s2.pop();
                tempList.add(tempNode.val);
                
                // Change the order of insertion in Stack
                if(tempNode.right != null) 
                    s1.push(tempNode.right);
                
                if(tempNode.left != null) 
                    s1.push(tempNode.left);
            }
            
            if(!tempList.isEmpty())
                ans.add(tempList);
        }
        
        return ans;
    }
}