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
    
    /*
        Observation:
        We have 3 cases in deletion:
        1. Node to be deleted is a leaf node.
        2. Node to be deleted has 1 child.
        3. Node to be deleted has 2 childrens.
            We need to replace the node having 2 childrens with
            a. Either get the max value node from the LST.
            b. Or get the min value node from the RST.
            
        Case 3:
        Whichever node is being picked as the new root node, it should not
        have anything larger than it on the LST and smaller than it
        on the RST.
        Hence, pick either the max on the LST or the min on the RST.
        i.e. Replace the node to be deleted by either the max of the LST
        and delete the max of the LST as well.
        Or replace the node to be deleted by the min of the RST
        and delete the min of the RST as well.
        
        Also do note that, the max of the LST or min of the RST will have
        atmost only 1 child.
        
        3. Node to be deleted has 2 childrens.
            We need to replace the node having 2 childrens with
            a. Either get the max value node from the LST.
            b. Or get the min value node from the RST.
            The max or the min will have atmost only 1 child.
    */
    
    public TreeNode deleteNode(TreeNode root, int key) {
        
        return Delete(root, key);
    }
    
    public TreeNode Delete(TreeNode root, int K) 
    {
        // This means K is not present
        if(root == null)
            return null;
        
        // Current root value is equal to K
        if(root.val == K)
        {
            // Case 1: Node to be deleted is a leaf node
            if(root.left == null && root.right == null)
                return null;
            
            // Case 2: Node to be deleted has 1 child
            if(root.left == null)
                return root.right;
            
            if(root.right == null)
                return root.left;
            
            // Case 3: Node to be deleted has 2 childrens
            // a. Get max value from LST(Or alternate Get min value from RST)
            // b. Replace root with max value
            // c. Delete max value node from LST
            if(root.left != null && root.right != null)
            {
                TreeNode max = GetMaxValueFromLST(root.left);
                // Replace root node
                root.val = max.val;
                // Now, Delete this max value from the LST
                root.left = Delete(root.left, max.val);
                
            }
        }
        else if(root.val > K)
            root.left = Delete(root.left, K);
        else if(root.val < K)
            root.right = Delete(root.right, K);
        
        return root;
    }
    
    public TreeNode GetMaxValueFromLST(TreeNode root) 
    {
        TreeNode temp = root;
        
        while(temp.right != null)
            temp = temp.right;
        
        return temp;
    }
    
    public TreeNode GetMinValueFromRST(TreeNode root) 
    {
        TreeNode temp = root;
        
        while(temp.left != null)
            temp = temp.left;
        
        return temp;
    }
}