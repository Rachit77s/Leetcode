class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        return HelperI(intervals, newInterval);
        // return insertI(intervals, newInterval);
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
        
        
        List<int[]> result = new ArrayList<>();
        
            /*
        _____: current interval(i); 
        _ _ _: newInterval

1) i.start > newInterval.end，then we can safely add both to result，
	and mark newInterval as null
	
			       |________|
	|_ _ _ _ _|
    
			
2) i.end < newInterval.start，then we can safely add i to result;
	newInterval still needs to be compared with latter intervals

	|________|
			       |_ _ _ _ _|
			
3) There is overlap between i and newInterval. We can merge i into newInterval, 
then use the updated newInterval to compare with latter intervals.

	
	|________|
		|_ _ _ _ _|
			
		|________|
	|_ _ _ _ _|
        
    */
        
        /*
            Input
            []
            [5,7]
            Output
            []
            Expected
            [[5,7]]
        */ 
        
        for(int[] i : intervals)
        {
            // Case I: 
            /*1. No overlap and newInterval appears before the 
            current interval, add newInterval to result.*/
            if(i[0] > newInterval[1])
            {
                result.add(newInterval);
                
                // save the previous interval to newInterval 
                // for next loop use
                newInterval = i;
            }
            
            // Case II:
            /*2. No overlap and newInterval appears after the 
            current interval, add current interval to result.*/
            else if(newInterval[0] > i[1])
            {
                result.add(i);
            }
            
            
            // Case III: 
            /*3. Has overlap, update the toAdd to the merged interval.*/
            // If above conditions fail its an overlap since possibility 
            // of new interval existing in left & right of slot is checked
            // Update lowest of start & highest of end & not insert
            else
            {
                newInterval[0] = Math.min(newInterval[0], i[0]);//get min
                newInterval[1] = Math.max(newInterval[1], i[1]);//get max
            }
        }
        
        // insert the last newInterval
        result.add(newInterval);
        
        // if(newInterval != null)
        //     result.add(newInterval);
        
        // convert to int[][] array
        return result.toArray(new int[result.size()][]);
    }
}

