class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        
        intervals.sort(key = lambda x: x[1])
        ans = 0
        
        prevEnd = intervals[0][1]
        
        for x,y in intervals[1:]:
            if prevEnd > x:
                ans += 1
                prevEnd = min(prevEnd, y)
            else:
                prevEnd = y
        
        return ans