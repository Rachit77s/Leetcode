class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        globalMax = float('-inf')
        currMax = 0
        
        for i in range(len(nums)):
            currMax += nums[i]
            
            globalMax = max(globalMax, currMax);
            
            if currMax < 0:
                currMax = 0
                
        return globalMax