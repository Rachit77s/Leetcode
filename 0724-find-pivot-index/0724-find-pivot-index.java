class Solution {
    public int pivotIndex(int[] nums) {
        return MostOptimized(nums);
    }
    
    public int MostOptimized(int[] nums)
    {
        int prefixSum = 0;

        for(int i=0; i < nums.length; i++)
            prefixSum += nums[i];
        
        int leftSum = 0;
        for(int i = 0; i < nums.length; i++)
        {
            prefixSum -= nums[i];
            
            if(leftSum == prefixSum)
                return i;
            
            leftSum += nums[i];
        }
        
        return -1;
    }
    
    public int BetterApproach(int[] nums)
    {
        int[] prefixSum = new int[nums.length];
        
        prefixSum[0] = nums[0];
        
        for(int i=1; i < nums.length; i++)
            prefixSum[i] = prefixSum[i-1] + nums[i];
        
        for(int i = 0; i < nums.length; i++)
        {
            int leftSum = 0;
            int rightSum = 0;
            if(i <= 0)
                leftSum = 0;
            else
                leftSum = prefixSum[i-1];
            
            if(rightSum >= nums.length)
                rightSum = 0;
            else
                rightSum = prefixSum[nums.length-1] - prefixSum[i];
            
            if(leftSum == rightSum)
                return i;
        }
        
        return -1;
    }
}

// [1,7,3,6,5,6] = 28
//.      17      28-17