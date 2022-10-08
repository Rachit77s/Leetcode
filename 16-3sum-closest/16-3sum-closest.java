class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        return ThreeSum(nums, target);
    }
    
    public int ThreeSum(int[] A, int K) 
    {
        if(A.length < 3)
            return 0;
        
        int n = A.length;
        Arrays.sort(A);
        
        // Intial sum or assumption that intial three values are the closet sum.
        int closestSum = A[0] + A[1] + A[2];
        
        for(int first = 0; first < n - 2; first++)
        {
            int second = first + 1;
            int third = n - 1;
            
            while(second < third)
            {
                int currSum = A[first] + A[second] + A[third];
                
                // If we find better or closer sum then we update closestSum value
                if(Math.abs(closestSum - K) > Math.abs(currSum - K))
                    closestSum = currSum;
                    
                if(currSum == K)
                    return K;
                
                if(currSum >  K)
                    third--;
                else
                    second++;
            }
        }
        
        return closestSum;
    }
}