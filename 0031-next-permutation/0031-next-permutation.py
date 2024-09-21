class Solution:
    def nextPermutation(self, A: List[int]) -> None:
        """
        https://www.scaler.com/help_requests/1026823/?ref=join-call-now
        
        
        I/P:    [2, 4, 1, 7, 5, 0]
        Output: [2, 4, 5, 0, 1, 7]
        
        This is the trick in this question which needs to be learnt
        
        Step 1: From the end of the array, find the 1st value that is decreasing
                i.e. Find 1st decreasing value from the right side of array
                It is 1,  [1, 7, 5, 0], let's call it pivot
                
                [2, 4, 1, 7, 5, 0]
                       ^
                       pivot
                       
        Step 2: Now from 1 or pivot, find the value that is just greater than pivot
                It is 5.
                Reason: To make the just greater permutation, we need the value
                that is just greater than the pivot
                
                [2, 4, 1, 7,   5, 0]
                       ^       ^
                     pivot     Value
                       
        Step 3: Now swap 1 & 5
        
                [2, 4, 5, 7, 1, 0]
                
                This can be 1 permutation, but it is not the just greater
                
        Step 4: Now, reverse all the values just after the pivot index to get the next greater 
                O/P: [2, 4, 5, 0, 1, 7]
                
                
                I/P:    [2, 4, 1, 7, 5, 0]
                Step 1: [2, 4, 1, 7, 5, 0]
                               ^
                             pivot
                             
                Step 2: [2, 4, 1, 7,   5, 0]
                               ^       ^
                            pivot     Value
                Step 3: [2, 4, 5, 7, 1, 0]
                
                Step 4: [2, 4, 5, 0, 1, 7]
                Output: [2, 4, 5, 0, 1, 7]
                
        """
        n = len(A)
        left = -1 # pivot
        
        # range(start, stop, step)
        # range(n-1, -1, -1)
        
        # Step 1: Find 1st decreasing value from the right side of array
        # left ........
        #.     monotonically decreasing
        
        for right in reversed(range(n-1)):
            if A[right] < A[right+1]:
                left = right
                break
        
        
        # if we don't find any such element, then just rev and return
        if left == -1:
            A.reverse()
            return
        
        # Step 2:Now from left+1, find value that is just greater than it
        right = -1
        for i in range(left+1, n):
            if A[left] < A[i]:
                right = i
        
        # Step 3: Now swap 1 & 5
        A[left], A[right] = A[right], A[left]
        
        # Step 4: Reverse all after left/pivot index
        l = left + 1
        r = n - 1
        
        while l < r:
            A[r], A[l] = A[l], A[r]
            l += 1
            r -= 1
        