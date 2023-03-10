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

    ListNode head;
    Random r;
    public Solution(ListNode head) {
        this.head = head;
        r = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int count = 0;
        ListNode node = head;
        ListNode candidate = head;
        
        while(node != null) {
            if(r.nextInt(++count) == 0) candidate = node;
            node = node.next;
        }
        return candidate.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */