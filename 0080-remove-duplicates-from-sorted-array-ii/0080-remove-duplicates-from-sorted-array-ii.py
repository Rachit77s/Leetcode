class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        
        idx = 0
        cnt = 0
        prevValue = -inf
        
        for val in nums:
            if val != prevValue:
                nums[idx] = val
                idx += 1
                prevValue = val
                cnt = 1
            else:
                cnt += 1
                prevValue = val
                if cnt <= 2:
                    nums[idx] = val
                    idx += 1
                    
        return idx
        
        
        
        