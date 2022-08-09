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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return SlowFastPointer(head, n);
    }
    
    public ListNode SlowFastPointer(ListNode head, int n)
    {
        // https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/603/discuss/1164537/Short-and-Simple-One-Pass-Solution-w-Explanation-or-Beats-100-or-No-dummy-node-required!
        
        ListNode slow = head;
        ListNode fast = head;
        
        //Move fast in front so that the gap between slow and fast becomes n
        for(int i = 0; i < n; i++)
            fast = fast.next;
        
        // If node to be deleted is the 1st node.
        if(fast == null)
            return head.next;
        
        //Move fast to the end, maintaining the gap
        while(fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return head;
        
        // https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/603/discuss/589304/CLEAR-JAVA-SOLUTION-WITH-DETAILED-EXPLANATION!
        // https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/603/discuss/1164542/JS-Python-Java-C++-or-Easy-Two-Pointer-Solution-w-Explanation
        // https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/603/discuss/8804/Simple-Java-solution-in-one-pass
    }
    
    public ListNode TwoPassAppraoch(ListNode head, int n)
    {
        int length = 0;
        ListNode curr = head;
        
        // finding the length of linked list
        while(curr != null)
        {
            curr = curr.next;
            length++;
        }
        
        //System.out.print(length);
        
        if(length == n)
        {
            return head.next;
        }
            
        curr = head;
        //System.out.print(curr.val);
        int idx = 1;
        while(idx != length - n)
        {
            curr = curr.next;
            idx++;
        }
        
        //System.out.print(curr.val);
        curr.next = curr.next.next;
        
        return head;
    }
}