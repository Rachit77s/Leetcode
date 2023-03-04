class Solution:
    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        N = len(nums)
        count = 0
        min_position = max_position = left_bound = -1
        for i in range(N):
            if nums[i] < minK or nums[i] > maxK:
                left_bound = i
            if nums[i] == minK:
                min_position = i
            if nums[i] == maxK:
                max_position = i
            count += max(0, min(min_position, max_position) - left_bound)
        return count