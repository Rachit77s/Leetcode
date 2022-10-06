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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        
        return Recursion(root, low, high);
    }
    
    public TreeNode Recursion(TreeNode root, int low, int high) 
    {
        
// CASE 1 : (root->val < low)
// Range [ low, high ] is present at the right of the root, so we need to call trimBST(root->right, low, high)

// CASE 2 : (root->val > high)
// Range [ low, high ] is present at the left of the root, so we need to call trimBST(root->left, low, high)

// CASE 3 : (root->val > low) && (root->val < high)
// Range [ low, high ] contains the root , so find the left and right subtree by recursively calling trimBST(root->left, low, high) and trimBST(root->right, low, high) respectively


        if(root == null)
            return null;
        
        // CASE 1
        // SINCE BST GO TO RIGHT FOR VALID RANGE [ low , high ]
        if(root.val < low)
            return Recursion(root.right, low, high);
        
        // CASE 2
	   // SINCE BST GO TO LEFT FOR VALID RANGE [ low, high ]
        if(root.val > high)
            return Recursion(root.left, low, high);
        else
        {
            // CASE 3
            // At this stage root lies WITHIN RANGE [ low , high ]
            // Root's value is inside the range.
            // Root will remain the same but update its LST and RST,
            // since we don't know that they are in the range or not.
            root.left = Recursion(root.left, low, high);
            root.right = Recursion(root.right, low, high);
            return root;
        }
    }
}