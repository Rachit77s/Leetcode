class Solution {
    public long zeroFilledSubarray(int[] nums) {
        
        return Optimized(nums);
    }
    
    public long Optimized(int[] A) 
    {
        long zeroCount = 0;
        long subArrays = 0;
        
        for (int i = 0; i < A.length; i++) 
        {
            if(A[i] == 0)
                zeroCount++;
            else
            {
                subArrays += (zeroCount * (zeroCount + 1) ) / 2;
                zeroCount = 0;
            }
        }
        
        subArrays += (zeroCount * (zeroCount + 1) ) / 2;
        
        return subArrays;
    }
}