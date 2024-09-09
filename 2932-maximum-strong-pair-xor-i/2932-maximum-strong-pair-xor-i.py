class Solution:
    def maximumStrongPairXor(self, nums: List[int]) -> int:
        
        maxXor = 0
        
        for i in range(len(nums)):
            for j in range(len(nums)):
                
                if abs(nums[i] - nums[j]) <= min(nums[i], nums[j]):
                    maxXor = max(maxXor, nums[i] ^ nums[j])
                else:
                    continue
                    
                
        return maxXor