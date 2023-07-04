class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        count = 0
        runningSum = 0
        dict = {}
        
        dict[0] = 1
        
        for item in nums:
            runningSum += item
            
            remainder = runningSum % k
            if remainder < 0:
                runningSum += k
                
            if remainder in dict:
                count += dict[remainder]
                
            dict[remainder] = dict.get(remainder, 0) + 1
            
        return count