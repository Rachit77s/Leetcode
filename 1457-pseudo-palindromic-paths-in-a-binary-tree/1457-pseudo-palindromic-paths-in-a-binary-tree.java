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
    int ans = 0;
    
    public int pseudoPalindromicPaths (TreeNode root) {
        
   
        return RecursiveHelper(root);
    }
    
    public int RecursiveHelper(TreeNode root)
    {
        int[] arrCount = new int[10];
        Recursive(root, arrCount);
        return ans;
    }
    
    // https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/discuss/648517/Palindrome-Property-Trick-Java-Solution-Explained
    // Time O(NK)   Here K = 9
    // Space O(K + H)
    public void Recursive(TreeNode root, int[] arrCount)
    {
    /*
        We know that in palindrome, every number occurs even number of times .
        But in the odd length palindrome, only one number can occur odd number of times.
        We have used that property in isPalindrome method to check if numbers are pseudo palindrome or not.
    */
        if(root == null)
            return;
        
        arrCount[root.val]++;
        
        if(root.left == null && root.right == null)
        {
            if(IsPalindrome(arrCount))
                ans++;
            
            arrCount[root.val]--;
            return;
        }
        
        Recursive(root.left, arrCount);
        Recursive(root.right, arrCount);
        
        arrCount[root.val]--;
    }
    
    public boolean IsPalindrome(int[] arrCount)
    {
        int oddNumberCount = 0;
        
        for(int i = 1; i <= 9; i++)
        {
            if(arrCount[i] % 2 != 0)
                oddNumberCount++;
            
            // oddNumberCount > than 1, not a palindrome.
            if(oddNumberCount > 1)
                return false;
        }
        
        return true;
    }
}

//