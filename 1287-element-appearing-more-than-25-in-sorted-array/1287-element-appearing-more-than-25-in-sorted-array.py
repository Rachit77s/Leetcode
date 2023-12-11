class Solution:
    def findSpecialInteger(self, arr: List[int]) -> int:
        size = len(arr) // 4
        for i in range(len(arr) - size):
            if arr[i] == arr[i + size]:
                return arr[i]
        
        return -1