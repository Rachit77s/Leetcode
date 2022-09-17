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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return HelperBabbar(preorder, inorder);
    }
    
    public TreeNode HelperBabbar(int[] preorder, int[] inorder) 
    {
        if(preorder == null || inorder == null || preorder.length != inorder.length)
            return null;

        //Generate a HM of Inorder elements
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int i = 0; i < inorder.length; i++)
        {
            map.putIfAbsent(inorder[i], i);
        }
        
        int[] preRootIndex = new int[1];
        preRootIndex[0] = 0;
        int inorderStart = 0;  
        int inorderEnd = inorder.length - 1;                 

        return GenerateTree(preorder, inorder, preRootIndex, inorderStart, inorderEnd, map);
    }
    
    // Babbar Video
    public TreeNode GenerateTree(int[] preorder, int[] inorder, int[] preRootIndex, int inorderStart, int inorderEnd, HashMap<Integer,Integer> map)
    {
        if(inorderStart > inorderEnd)
            return null;
        
        int element = preorder[preRootIndex[0]];
        preRootIndex[0]++;
        TreeNode root = new TreeNode(element);
        int inorderRootIdx = map.get(element);
        
        // Get the first node of the PreOrder as it is the root node
        // TreeNode rootNode = new TreeNode(preorder.get(preRootIndex[0]));

        // Get the position of root node in Inorder
        // For INORDER, Determine the boundary of the left and right subtree of the current node
        // int inorderRootIdx = map.get(preorder.get(preRootIndex[0]));
        
        
        root.left = GenerateTree(preorder, inorder, preRootIndex, inorderStart, inorderRootIdx - 1, map);
        
        root.right = GenerateTree(preorder, inorder, preRootIndex, inorderRootIdx + 1, inorderEnd, map);
        
        return root;
    }
}