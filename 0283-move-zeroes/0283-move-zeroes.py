class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        zero_count = 0
        index = 0
        
        # Count the number of zeroes and move non-zero elements to the beginning of the list
        for num in nums:
            if num != 0:
                nums[index] = num
                index += 1
            else:
                zero_count += 1

        # Fill the remaining elements with zeroes
        while zero_count > 0:
            nums[index] = 0
            index += 1
            zero_count -= 1
                