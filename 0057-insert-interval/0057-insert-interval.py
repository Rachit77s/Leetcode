class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        ans = []        
        n = len(intervals)
        i = 0
        
        # Merge before 
        while i < n and intervals[i][1] < newInterval[0]:
            ans.append(intervals[i])
            i += 1
            
        # [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
        # Case 2: Overlapping and merging intervals
        while i < n and intervals[i][0] <= newInterval[1]:
            newInterval[0] = min(intervals[i][0], newInterval[0])
            newInterval[1] = max(intervals[i][1], newInterval[1])
            i += 1
            
        ans.append(newInterval)
        
        while i < n:
            ans.append(intervals[i])
            i += 1

        return ans