class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        
        intervals.sort()
        
        ans = []
        n = len(intervals)
        i = 1

        prevStart = intervals[0][0]
        prevEnd = intervals[0][1]
        
        while i < n:
            currStart = intervals[i][0];
            
            if prevEnd >= intervals[i][0]:
                prevEnd = max(prevEnd, intervals[i][1])
                i += 1
            else:
                ans.append([prevStart, prevEnd])
                prevStart = currStart
                prevEnd = intervals[i][1]
                i += 1
          
        ans.append([prevStart, prevEnd])
        return ans
        