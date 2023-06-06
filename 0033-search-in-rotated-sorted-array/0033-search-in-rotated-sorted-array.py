class Solution:
    def search(self, nums: List[int], target: int) -> int:
        return self.helper( nums, target)
    
    
    def helper(self, A, target):

        if len(A) == 1:
            if A[0] == target:
                return 0
            return -1

        pivotIndex = self.getPivotIndex(A)
        
        # print(pivotIndex)
        
        if target >= A[0] and target <= A[pivotIndex]:
            return self.binarySearch(A, target, 0, pivotIndex)
        
        if pivotIndex + 1 < len(A) and target >= A[pivotIndex + 1] and target <= A[len(A) - 1]:
            return self.binarySearch(A, target, pivotIndex + 1, len(A) - 1)
        
        return -1
    
    def getPivotIndex(self, A):
            left, right, n = 0, len(A) - 1, len(A)
            
            while left <= right:
                
                mid = left + (right - left) // 2
                
                if mid + 1 < n and A[mid] > A[mid + 1]:
                    return mid
                
                if mid - 1 >= 0 and A[mid - 1] > A[mid]:
                    return mid - 1
                
                if A[left] >= A[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
                    
            return 0
        
    def binarySearch(self, A, target, left, right):
        while left <= right:
            mid = left + (right - left) // 2

            if A[mid] == target:
                return mid

            if A[mid] > target:
                right = mid - 1
            else:
                left = mid + 1

        return -1