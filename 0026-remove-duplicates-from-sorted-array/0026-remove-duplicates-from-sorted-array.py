class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        
        cnt = 0
        prevValue = -inf
        
        for val in nums:
            if val != prevValue:
                nums[cnt] = val
                prevValue = val
                cnt += 1
                
        return cnt