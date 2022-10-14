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
        
        // return HelperUsingSet(root);
        return RecursiveHelper(root);
    }
    
    public int RecursiveHelper(TreeNode root)
    {
        int[] arrCount = new int[10];
        RecursiveII(root, arrCount);
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
    
    public void RecursiveII(TreeNode root, int[] arrCount)
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
        }
        else
        {
            RecursiveII(root.left, arrCount);
            RecursiveII(root.right, arrCount);
        }

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
    
    public int HelperUsingSet(TreeNode root)
    {
        HashSet<Integer> set = new HashSet<>();
        RecursiveUsingSet(root, set);
        return ans;
    }
    
    // Time O(N)
    // Space O(K + H)
    // Comments: https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/discuss/648345/Java-DFS-%2B-Set-%2B-Recursion
    // https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/discuss/648534/JavaC%2B%2BPython-At-most-one-odd-occurrence
    public void RecursiveUsingSet(TreeNode root, HashSet<Integer> set)
    {
    // INTUITION - Palindrome can have all duplicates or can have at max 1 unique element.
    // Whenever u find a duplicate in a path, just remove it.
    // At the leaf node, either there will be no element, or there can be at max 1 number.
        
        if(root == null)
            return;
        
        // duplicate found, so remove it
        if(set.contains(root.val))
            set.remove(root.val);
        else
            set.add(root.val);
        
        if(root.left == null && root.right == null)
        {
            if(set.size() <= 1)
                ans++;
        }
        
        // Because if we dont pass a copy of the HashSet, then the HashSet will get modified by its subtree. Meaning - the HashSet will be altered by the left subtree according to its needs and then the right subtree will not get intended HashSet. Thats why we need to pass on a copy of the HashSet (at current level) to its next level.
        RecursiveUsingSet(root.left, new HashSet<>(set));
        RecursiveUsingSet(root.right, new HashSet<>(set));
    }
}

//