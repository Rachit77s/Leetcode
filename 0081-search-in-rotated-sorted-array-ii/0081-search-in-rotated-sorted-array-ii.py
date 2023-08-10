class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        
        n = len(nums)
        left = 0
        right = n-1
        while left < right:
            mid = left + (right - left) // 2
            while left < mid and nums[left] == nums[mid]:
                left += 1
                mid = left + (right - left) // 2
            
            while mid < right and nums[mid] == nums[right]:
                right -= 1
                mid = left + (right - left) // 2

            if nums[mid] == target: return True
            elif nums[mid] < nums[right]:
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid
            else:
                if nums[left] <= target and target <= nums[mid]:
                    right = mid
                else:
                    left = mid + 1

        if nums[left] == target: return True
        else: return False