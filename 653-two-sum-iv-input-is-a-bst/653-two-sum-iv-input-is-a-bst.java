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
        
        return BSTIteratorApproach(root, k);
        // return DFSHelper(root, k);
        // return InorderApproach(root, k);
    }
    
    public boolean InorderApproach(TreeNode root, int k) 
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
//         HashSet<Integer> set = new HashSet<>();
        
//         for(int i = 0; i < treeList.size(); i++)
//         {
//             if(set.contains(k - treeList.get(i)))
//                 return true;
            
//             set.add(treeList.get(i));
//         }
        
//         return false;
        
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
    
    public boolean DFSHelper(TreeNode root, int k) 
    {
        HashSet<Integer> set = new HashSet<>();
        return DFSWithHashset(root, set, k);
    }

    public boolean DFSWithHashset(TreeNode root, HashSet<Integer> set, int k) 
    {
        if(root == null)
            return false;
        
        if(set.contains(k - root.val))
            return true;
        
        set.add(root.val);
        
        return DFSWithHashset(root.left, set, k) || DFSWithHashset(root.right, set, k);
    }
    
    // https://www.youtube.com/watch?v=ssL3sHwPeb4
    // Interview expected approach in SC of O(H)
    public boolean BSTIteratorApproach(TreeNode root, int k)
    {
        if(root == null)
            return false;
        
        BSTIterator left = new BSTIterator(root, true);
        
        // Before or Reverse is a Descending order sorted array
        // i.e. Right Node Left
        // Iterate in backward direction i.e from highest to lowest i.e. right to left
        BSTIterator right = new BSTIterator(root, false);
        
        int i = left.next();
        int j = right.next();
        
        while(i < j)
        {
            if(i+j == k)
                return true;
            else if(i+j < k)
                i = left.next();
            else
                j = right.next();
        }
        
        return false;
    }
        
}

public class BSTIterator
{
    private Stack<TreeNode> stack;
    private boolean isForward = true;
    
    public BSTIterator(TreeNode root, boolean flag)
    {
        stack = new Stack<>();
        this.isForward = flag;
        
        // If isForward is true, go to extreme left while inserting nodes in the stack
        // If isForward is false, go to extreme right while inserting nodes in stack
        pushAll(root);
    }
    
    public boolean hasNext()
    {
        return !stack.isEmpty();
    }
    
    public int next()
    {
        // isForward: true  Left Node Right
        // isForward: false Right Node Left
        
        // Pop the top most element, go to its right and 
        // push all the left nodes in stack.
        TreeNode temp = stack.pop();
        
        // isForward:false then pop the stack, go to left and
        // put all of its right nodes to the stack
        if(this.isForward == false)
            pushAll(temp.left);
        else
            pushAll(temp.right);
        
        return temp.val;
    }
    
    // Take all the left's and push in the stack
    public void pushAll(TreeNode root)
    {
        while(root != null)
        {
            stack.push(root);
            
            if(this.isForward == false)
                root = root.right;
            else
                root = root.left;
        }
    }
}