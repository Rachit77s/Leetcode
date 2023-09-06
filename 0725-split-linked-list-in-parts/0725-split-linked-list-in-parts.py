# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution(object):
    def splitListToParts(self, head, k):
        N = 0
        ptr = head
        while ptr:
            ptr = ptr.next
            N += 1
        
        # r implies how many extra nodes cannot be fit.
        # N=8, k=3  ==> [3, 3, 2]
        # 8 % 3 = 2 ==> it has 2 mroe nodes can't be fit
        #               r = 2 slots starting from the front will have one more.
        q, r = divmod(N, k)
        
        ans = []
        for i in range(k):
            size = q + 1 if (r := r - 1) >= 0 else q

            ans.append(head)
            last = None
            while size > 0:
                last = head
                head = head.next
                size -= 1
            if last: last.next = None
                
        return ans