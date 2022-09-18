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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        return HelperBabbar(inorder, postorder);
    }
    
    public TreeNode HelperBabbar(int[] inorder, int[] postorder) 
    {
        if(postorder == null || inorder == null || postorder.length != inorder.length)
            return null;

        //Generate a HM of Inorder elements
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int i = 0; i < inorder.length; i++)
        {
            map.putIfAbsent(inorder[i], i);
        }
        
        int[] postRootIndex = new int[1];
        postRootIndex[0] = postorder.length - 1;
        int inorderStart = 0;  
        int inorderEnd = inorder.length - 1;                 

        return GenerateTree(inorder, postorder, postRootIndex, inorderStart, inorderEnd, map);
    }
    
    // Babbar Video
    public TreeNode GenerateTree(int[] inorder, int[] postorder, int[] postRootIndex, int inorderStart, int inorderEnd, HashMap<Integer,Integer> map)
    {
        if(inorderStart > inorderEnd)
            return null;
        
        int element = postorder[postRootIndex[0]];
        postRootIndex[0]--;
        TreeNode root = new TreeNode(element);
        // Find element's index in inorder
        int inorderRootIdx = map.get(element);
        
        root.right = GenerateTree(inorder, postorder, postRootIndex, inorderRootIdx + 1, inorderEnd, map);
        root.left = GenerateTree(inorder, postorder, postRootIndex, inorderStart, inorderRootIdx - 1, map);
        
        return root;
    }
}