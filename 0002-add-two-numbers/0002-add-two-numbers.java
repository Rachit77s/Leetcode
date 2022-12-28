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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        return ApproachI(l1, l2);
    }
    
    // Striver: https://www.youtube.com/watch?v=LBVsXSMOIk4
    // https://leetcode.com/problems/add-two-numbers/discuss/1835535/JavaC%2B%2B-A-very-beautiful-explanation-EVER-exists
    public ListNode ApproachI(ListNode l1, ListNode l2) 
    {
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        
        // Edge case: Also Iterate when carry is 1
        while(l1 != null || l2 != null || carry == 1)
        {
            int sum = 0;
            
            if(l1 != null)
            {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if(l2 != null)
            {
                sum += l2.val;
                l2 = l2.next;
            }
            
            // New Digit
            sum = sum + carry;
            carry = sum / 10; // Gives us remainder i.e. carry
            ListNode newNode = new ListNode(sum % 10);
            
            // Update pointers
            curr.next = newNode;
            curr = curr.next;
            
            // Edge case: 8 + 7 = 15, so carry is remaining, 
            // Hence run the loop when carry = 1
        }
        
        return dummy.next;
    }
}


//  342
//  465