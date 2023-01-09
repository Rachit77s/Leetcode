class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        return Helper3(intervals);
        // return Helper2(intervals);
        // return Helper1(intervals);
    }
    
    public int Helper1(int[][] intervals) 
    {
        /*
            Draw on number line:
            
            [1,6] [3,9]
            Which one to delete, does order of their deletion matters?
            Yes, in this case it doesn't appear. But consider below
            
            [1,6] [3,9] [7,15]
            Now deletion matters, hence, we need to delete [3,9]
            to get ans = 1(No of deletions)
            
            Case 2: When 1st interval is larger
            [1,9] [3,6] [7,10]
            Order of deletion matters, hence, delete [1,9] to get
            ans = 1, otherwise, if [1,9] would not be deleted
            we would had to delete [3,6] [7,10] and ans would be 2.
            
        */
        
        // Sort by start
        Arrays.sort(intervals, (a,b) -> {
            if(a[0] != b[0]) 
                return a[0] - b[0];
            else
                return a[1] - b[1];
        });
        
        int count = 0;
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++)
        {
            int currStart = intervals[i][0];
            
            // [1,5] [3,6] Overlapping intervals
            // Intervals are overlapping
            if(prevEnd > currStart)
            {
                count++;
                
                /*
                    Now there are 2 cases in overlapping
                    
                    Case1: [1,5] [3,6]
                    We would have deleted bigger end time interval
                    So delete [3,6]
                    
                    Case2: [1,5] [2,3]
                    We would delete the bigger end time interval
                    i.e. Delete [1,5]
                */
                
                // currEnd > prevEnd
                if(intervals[i][1] > prevEnd)
                {
                    // Do nothing, so high end time gets ignore
                }
                else if(prevEnd >= intervals[i][1])
                {
                    // Update prev to current as curr is lower end time
                    prevEnd = intervals[i][1];
                }
            }
            else
            {
                prevEnd = intervals[i][1];
            }
        }
        
        return count;
    }
    
        
    public int Helper2(int[][] intervals) 
    {
        Arrays.sort(intervals, (a,b) -> {
            if(a[0] != b[0]) 
                return a[0] - b[0];
            else
                return a[1] - b[1];
        });
        
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
                // Delete the interval with greater end time.
                // Because larger interval might overlap with some
                // other interval.
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            }
            else
            {
                prevEnd = intervals[i][1];
            }
        }
        
        return count;
    }
    
    public int Helper3(int[][] intervals) 
    {
        if (intervals.length == 0 ) 
            return 0;
        
        // arr : [[1,2],[2,3],[3,4],[1,3]]
//sorted by end: [[1, 2], [2, 3], [1, 3], [3, 4]]
        
        // Sort by the second number in each interval:
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int removed = 0;
        // The second value of the last valid interval.
        int prevEnd = intervals[0][1]; 
        
        // We need to traverse the sorted intervals, counting the number of invalid intervals, and
        // updating the prevEnd value when you find a valid interval.
        for(int i = 1;  i < intervals.length; i++)
        {
            // We have an invalid interval if the  current start time is < prevEnd;
            if(intervals[i][0] < prevEnd)
                removed++;
            else{
                prevEnd = intervals[i][1];
            }
        }
        
        // Return the number of intervals removed:
        return removed;
    }
}