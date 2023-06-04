class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        minVal = inf
        ans = 0
        
        for val in prices:
            minVal = min(minVal, val)
            ans = max(ans, val - minVal)
            
        return ans
