class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        dict = {}
        
        n = len(nums)
        
        for val in nums:
            if val not in dict:
                dict[val] = 1
            else:
                dict[val] += 1
             
            if dict[val] > (n // 2):
                return val
            
        return 0