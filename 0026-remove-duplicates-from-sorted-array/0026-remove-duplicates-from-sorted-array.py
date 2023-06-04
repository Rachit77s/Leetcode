class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:

        
#         cnt = 0
#         prevValue = -inf
        
#         for val in nums:
#             if val != prevValue:
#                 nums[cnt] = val
#                 prevValue = val
#                 cnt += 1
                
#         return cnt


        index = 1
    
        for i in range(1,len(nums)):
            if nums[i] != nums[i-1]:
                nums[index] = nums[i]
                index += 1
                
        return index