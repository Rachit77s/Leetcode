class Solution:
    def findLHS(self, nums: List[int]) -> int:
        nums.sort()
        
        print(nums)
        ans = 0
        left = 0
        right = 1
        
        while right < len(nums):
            diff = nums[right] - nums[left]
            
            if diff == 1:
                ans = max(ans, right - left + 1)
            
            if diff <= 1:
                right += 1
            elif diff > 1:
                left += 1
            
        return ans