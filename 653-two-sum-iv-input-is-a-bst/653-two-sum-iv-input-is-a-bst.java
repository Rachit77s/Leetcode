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
    public boolean findTarget(TreeNode root, int k) {
        
        return BruteForce(root, k);
    }
    
    public boolean BruteForce(TreeNode root, int k) 
    {
        if(root == null)
            return false;
        
        ArrayList<Integer> treeList = new ArrayList<>();
        
        TreeNode curr = root;
        Stack<TreeNode> stk = new Stack<>();
        
        while(!stk.isEmpty() || curr != null)
        {
            if(curr != null)
            {
                stk.push(curr);
                curr = curr.left;
            }
            else
            {
                TreeNode temp = stk.pop();
                treeList.add(temp.val);
                curr = temp.right;
            }
        }
        
        // 2 Sum
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < treeList.size(); i++)
        {
            if(set.contains(k - treeList.get(i)))
                return true;
            
            set.add(treeList.get(i));
        }
        
        return false;
        
    /*
        // Alternate to HashSet:
        // 2 pointer approach, as the treeList is sorted as per BST inorder property
        int i = 0;
        int j = treeList.size() - 1;
        while(i < j)
        {
            int sum = treeList.get(i) + treeList.get(j);
            
            if(sum == k)
                return true;
            else if(sum > k)
                j--;
            else
                i++;
        }
        
        return false;
    */

    }

//     public boolean OptimizedOne(TreeNode root, int k) 
//     {
        
//     }
}