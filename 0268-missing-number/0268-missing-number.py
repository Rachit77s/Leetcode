class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        result = 0
            
        for number in range(len(nums) + 1 ): # 0, 1, 2 ,3
            result ^= number
		
        # Essentially now result = ( 0 ^ 0 ^ 1 ^ 2 ^ 3)

        #XOR result with values in nums
        for num in nums : # 3,0,1
            result ^= num
                
        return result