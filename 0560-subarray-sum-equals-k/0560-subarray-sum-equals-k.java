class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int count = 0;
        
        // Stores the sum encountered till now. currSum: its frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Edge case
        map.put(0, 1);
        
        // Sum of elements so far
        int runningSum = 0;
 
        for (int i = 0; i < nums.length; i++)
        {
            // runningSum  - prev/earlier sum = K(target)
            // runningSum - K = prev/earlier sum
            
            runningSum = runningSum + nums[i];
            
            // Can we chop of some prefix of this array
            // so that we can make our runningSum match K
            if(map.containsKey(runningSum - k))
            {
                count = count + map.get(runningSum - k);
            }
            
            // Store the current sum and its frequency
            if(!map.containsKey(runningSum))
            {
                map.put(runningSum, 1);
            }
            else
            {
                // If subarray appears twice add it.
                map.put(runningSum, map.get(runningSum) + 1);    
            }
        }
        
        return count;
    }
}