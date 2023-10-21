class Solution:
    def constrainedSubsetSum(self, nums: List[int], k: int) -> int:
        dp = nums[:1]
        decrease = collections.deque(dp)
        for i, x in enumerate(nums[1:], 1):
            if i > k and decrease[0] == dp[i - k - 1]:
                decrease.popleft()
            tmp = max(x, decrease[0] + x)
            dp += tmp,
            while decrease and decrease[-1] < tmp:
                decrease.pop()
            decrease += tmp,                
        return max(dp)  