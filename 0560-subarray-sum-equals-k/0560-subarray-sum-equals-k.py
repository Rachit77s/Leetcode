class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        map = {}
        map[0] = 1
        runningSum = 0
        count = 0
        
        for val in nums:
            runningSum += val
            
            if (runningSum - k) in map:
                count += map[runningSum - k]
            
            if runningSum not in map:
                map[runningSum] = 1
            else:
                map[runningSum] += 1

        return count