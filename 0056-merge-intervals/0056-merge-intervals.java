class Solution {
    public int[][] merge(int[][] intervals) {
        
        return ApproachI(intervals);
    }
    
    public int[][] ApproachI(int[][] intervals) 
    {
        if (intervals.length <= 1)
			return intervals;
        
        // As we are sorting the intervals, they are bound 
        // to be consecutive and once they are consecutive,
        // we can easily merge them.
        Arrays.sort(intervals, (a, b)->(Integer.compare(a[0], b[0])));
        
        /*
            // If not Sort, below TC will fail
            // Input
            // [[1,4],[0,4]]
            // Output
            // [[1,4]]
            // Expected
            // [[0,4]]
        */
        
        List<int[]> ans = new ArrayList<>();
        
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++)
        {
            int currStart = intervals[i][0];
            
            // Intervals are overlapping
            if(prevEnd >= currStart)
            {
                prevEnd = Math.max(prevEnd, intervals[i][1]);
            }
            else
            {
                // Merge the previous overlapping interval
                ans.add(new int[] { prevStart, prevEnd });
                prevStart = currStart;
                prevEnd = intervals[i][1];
            }
        }
        
        ans.add(new int[] { prevStart, prevEnd });
        return ans.toArray(new int[0][]);
    }
}