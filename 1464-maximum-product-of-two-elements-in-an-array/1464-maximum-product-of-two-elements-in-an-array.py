class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        curr_max = 1
        res = 0
        for i in range(len(nums)):
            res = max(res, (nums[i] - 1) * (curr_max - 1))
            curr_max = max(curr_max, nums[i])
        return res