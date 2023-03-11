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
        
        return OptimizedApproach(head);
        // return Helper(head);
    }
    
    public TreeNode OptimizedApproach(ListNode head) 
    {
    /*
        Steps:
        1. Find the middle element of the LL
        2. Break the link after the mid
    */
        
        if(head == null)
            return null;
        
        if(head.next == null)
            return new TreeNode(head.val);
        
//         // Find middle
//         // Get middle element by Floyd's Cycle Detection Algorithm.
// 		ListNode fast = head;
// 		ListNode slow = head;
// 		while(fast != null && fast.next != null)
// 		{
// 				slow = slow.next;      // move by x speed
// 				fast = fast.next.next; // move by 2x speed
// 		}

// 		// If fast is null, it means it is an even length LL
// 		// If fast is not null, it means it is a odd length LL
// 		if(fast != null)
// 			 slow = slow.next; // Move slow to one ahead
        
        ListNode slow=head,fast=head,prev=null;
            while(fast!=null&&fast.next!=null){
                prev=slow;
                fast=fast.next.next;
                slow=slow.next;
            }
        prev.next=null;
        TreeNode root=new TreeNode(slow.val);
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(slow.next);
        return root;
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