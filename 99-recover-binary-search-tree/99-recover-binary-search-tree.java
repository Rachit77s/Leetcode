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
        Question to ask yourself:
        1. There will be 4 elements elements involved in the wrong order, but how do we know which 2 elements are the one which are not at their correct position?
        2. Is it always necessary that we will always find 2 anomalies only? It will be at max 2, but can we find 1 anomaly as well?
        
     */
    
    /*
        If we traverse in in-order way. The ideal nature of BST is increasing. But if two numbers gets swapped, the nature will become a peak (123, 2 is peak here) and valley at last representing smaller number (4356, 3 is valley). So those two nodes disrupting the ideal flow is the answer. This is called Inversion pair.

    Algo:
    1. First, we will consider only 1 anomaly, and the moment we find the 1st mismatch or anomaly,
       we will initialise the firstElement(n1) with the larger of the two nodes.
       And we will initialise secondElement(n2) with the smaller of the two nodes.
    2. Now, later on, if we encounter another anomaly, then we will 
       update secondElement(n2) value as the smaller of the two nodes.

    So basically firstElement will hold the largest value and secondElement will hold the smaller value.

    */
    
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode prevElement = null; //new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        
        RecursiveInorder(root);
        
        // Swap the values of the two nodes
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
        
    }
    
    public void RecursiveInorder(TreeNode root) 
    {
        if(root == null)
            return;
        
        RecursiveInorder(root.left);
        
        // Check if we even have a prev node to consider &
        // Check for an anomaly or mistmatch
        if(prevElement != null && prevElement.val > root.val)
        {
            // Check if it is 1st anomaly, for this firstElement would be null
            if(firstElement == null)
            {
                // firstElement will hold the larger of the two nodes
                firstElement = prevElement;
                secondElement = root;
            }
            else    // This is 2nd anomaly as firstElement is not null
            {
                // Update secondElement as the smaller of the two values
                secondElement = root;
            }
        }
        
        // Update prev element to current element
        prevElement = root;
        
        RecursiveInorder(root.right);
    }
}