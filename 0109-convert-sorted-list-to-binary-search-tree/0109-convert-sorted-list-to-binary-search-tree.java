/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        
        return Helper(head);
    }
    
    public TreeNode Helper(ListNode head)
    {
        if(head == null)
            return null;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        ListNode temp = head;
        
        while(head != null)
        {
            list.add(head.val);
            head = head.next;
        }
        
        return RecursiveHelper(list, 0, list.size() - 1);
    }
    
    public TreeNode RecursiveHelper(ArrayList<Integer> A, int low, int high) 
    {
        if(low > high)
            return null;
        
        int mid = (low + high) / 2;
        
        TreeNode root = new TreeNode(A.get(mid));
        root.left = RecursiveHelper(A, low, mid - 1);
        root.right = RecursiveHelper(A, mid + 1, high);
        
        return root;
    }
}