class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        return insertI(intervals, newInterval);
    }
    
    public int[][] insertI(int[][] intervals, int[] newInterval) {
		List<int[]> result = new LinkedList<>();
	    int i = 0;
	    // add all the intervals ending before newInterval starts
	    while (i < intervals.length && intervals[i][1] < newInterval[0]){
	        result.add(intervals[i]);
	        i++;
	    }
	    
	    // merge all overlapping intervals to one considering newInterval
	    while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
	    	// we could mutate newInterval here also
	        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
	        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
	        i++;
	    }
	    
	    // add the union of intervals we got
	    result.add(newInterval); 
	    
	    // add all the rest
	    while (i < intervals.length){
	    	result.add(intervals[i]); 
	    	i++;
	    }
	    
	    return result.toArray(new int[result.size()][]);
    }
    
    public int[][] HelperI(int[][] intervals, int[] newInterval) 
    {
        if(intervals.length == 0)
            return intervals;
        
        boolean flag = false;
        int prevEnd = intervals[0][1];
        
        ArrayList<ArrayList<Pair>> lis1t = new ArrayList<>();
        ArrayList<Pair> list = new ArrayList<>();
        
        for(int i = 0; i < intervals.length; i++)
        {
            int currEnd = intervals[i][1];
            
            if(currEnd >= newInterval[0])
            {
                flag = true;
                currEnd = Math.max(currEnd, newInterval[1]);
                
                //System.out.print("New interval" + newInterval[1]);
                //System.out.print(" Orgnl interval" + intervals[i][1]);
                intervals[i][0] = Math.min(intervals[i][0], newInterval[0]);
                intervals[i][1] = currEnd;
                
                
                list.add(new Pair(intervals[i][0], intervals[i][1]));
                
                prevEnd = currEnd;
            }
            else if(flag == true && prevEnd >= intervals[i][0])
            {
                currEnd = Math.max(currEnd, prevEnd);
                intervals[i][1] = currEnd;
                prevEnd = currEnd;
            }
            else if(currEnd < newInterval[0])
            {
                list.add(new Pair(intervals[i][0], intervals[i][1]));
            }
        }
        
        return intervals;
    }
}

