class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        
        count, candidate = 0, 0
        
        for val in nums:
            if count == 0:
                candidate = val
                
            if candidate == val:
                count += 1
            else:
                count -= 1
                
            if count > (len(nums) // 2):
                return candidate
            
        return candidate
            