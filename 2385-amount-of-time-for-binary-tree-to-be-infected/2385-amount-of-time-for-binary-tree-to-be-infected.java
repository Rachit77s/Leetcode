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
    public int amountOfTime(TreeNode root, int start) {
        
        /*
            Step 1&2: Create the parent mapping and return the target node
            Step 3: Burn the tree using a visited HM to mark visited nodes
        */
        
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode targetNode =  CreateParentMapping(root, start, parentMap);
        int ans = BurnTree(targetNode, parentMap);
        
        return ans;
        
    }
    
    public static TreeNode CreateParentMapping(TreeNode root, int K, HashMap<TreeNode, TreeNode> map)
    {
        TreeNode targetNode = new TreeNode(-1);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
            TreeNode temp = q.poll();
            
            if(temp.val == K)
                targetNode = temp;
            
            if(temp.left != null)
            {
                q.offer(temp.left);
                // node and its parent
                map.put(temp.left, temp);
            }
            
            if(temp.right != null)
            {
                q.offer(temp.right);
                // node and its parent
                map.put(temp.right, temp);
            }
        }
        
        return targetNode;
    }
    
    public static int BurnTree(TreeNode targetNode, HashMap<TreeNode, TreeNode> parentMap)
    {
                
        int count = 0;
        Queue<TreeNode> q = new LinkedList<>();
        // Track the visited nodes
        HashMap<TreeNode, Integer> visitedMap = new HashMap<>();

        q.offer(targetNode);
        visitedMap.put(targetNode, 1);
        
        while(!q.isEmpty())
        {
            // To track if we have add anything in the queue
            int flag = 0;
            int qSize = q.size();
            
            for(int i = 0; i < qSize; i++)
            {
                TreeNode temp = q.poll();
            
                // We are visiting 1st time
                if(temp.left != null && visitedMap.get(temp.left) == null)
                {
                    q.offer(temp.left);
                    visitedMap.put(temp.left, 1);
                    flag = 1;
                }

                if(temp.right != null && visitedMap.get(temp.right) == null)
                {
                    q.offer(temp.right);
                    visitedMap.put(temp.right, 1);
                    flag = 1;
                }
                
                if(parentMap.get(temp) != null && visitedMap.get(parentMap.get(temp)) == null)
                {
                    q.offer(parentMap.get(temp));
                    visitedMap.put(parentMap.get(temp), 1);
                    flag = 1;
                }
            }
            
            if(flag == 1)
                count++;
        }
        
        return count;
    }
}