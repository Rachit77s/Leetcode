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