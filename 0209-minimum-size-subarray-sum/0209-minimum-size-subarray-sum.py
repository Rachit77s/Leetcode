class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        ans = float('inf')
        
        n = len(nums)
        left = 0
        right = 0
        sum = 0
        
        while right < n:
            sum += nums[right]
            right += 1
            
            while sum >= target:
                ans = min(ans, right - left)
                sum -= nums[left]
                left += 1
                
        if ans == float('inf'):
            return 0
        
        return ans