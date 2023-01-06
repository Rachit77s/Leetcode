class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        return Helper1(intervals);
    }
    
    public int Helper1(int[][] intervals) 
    {
        Arrays.sort(intervals, (a,b) -> {
            if(a[0] != b[0]) 
                return a[0] - b[0];
            else
                return a[1] - b[1];
        });
        
        // [[-52,31],[-73,-26],[82,97],[-65,-11],[-62,-49],[95,99],[58,95],[-31,49],[66,98],[-63,2],[30,47],[-40,-26]]
        
        for (int i = 0; i < intervals.length; i++)
        {
            System.out.print(intervals[i][0] + "," + intervals[i][1] + " ");
        }
        
        int count = 0;
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++)
        {
            int currStart = intervals[i][0];
            
            // Intervals are overlapping
            if(prevEnd > currStart)
            {
                count++;
                // Keep the interval which has min end time,
                // delete the interval with greater end time.
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            }
            else
            {
                // prevStart = currStart;
                prevEnd = intervals[i][1];
            }
        }
        
        return count;
    }
}