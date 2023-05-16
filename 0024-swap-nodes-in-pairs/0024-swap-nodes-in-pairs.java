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
    public ListNode swapPairs(ListNode head) {
        
        
        ListNode sentinal = new ListNode(-1);
        ListNode prev = sentinal;
        while(head != null && head.next != null){
            prev.next  = head.next;
            ListNode next = head.next.next;
            head.next.next = head;
            prev = head;
            head = next;
        }
        prev.next = head;
        return sentinal.next;
    }
}