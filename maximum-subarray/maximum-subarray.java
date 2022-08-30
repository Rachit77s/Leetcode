class Solution {
    public int maxSubArray(int[] nums) {
        
        return MaxSum(nums);
    }
    
    public int MaxSum(int[] A)
    {
        int globalMax = Integer.MIN_VALUE;
        int maxTillNow = 0;
        
        // [-2,1,-3,4,-1,2,1,-5,4]
        
        for(int i = 0; i < A.length; i++)
        {
            maxTillNow += A[i];
            
            globalMax = Math.max(globalMax, maxTillNow);
            
            if(maxTillNow < 0)
                maxTillNow = 0;
        }
        
        return globalMax;
    }
}