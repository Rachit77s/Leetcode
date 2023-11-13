class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        return MostOptimized(nums);
        // return ApproachI(nums);
    }
    
    // https://www.youtube.com/watch?v=G9zKmhybKBM
    public int[] ApproachI(int[] A) {
        
        // For a number, we are getting product of all the numbers on the left &
        // product of all the numbers on the right, and then multiplying
        // prod on left * prod on right
        
        int n = A.length;
        
        int[] left = new int[n];
        
        left[0] = 1;
        for(int i = 1; i < n; i++)
        {
            left[i] = left[i-1] * A[i-1];
        }
        
        int[] right = new int[n];
        right[n-1] = 1;
        
        for(int i = n-2; i >= 0; i--)
        {
            right[i] = right[i+1] * A[i+1];
        }
        
        
        int[] ans = new int[n];
        for(int i = 0; i < n; i++)
        {
            ans[i] = left[i] * right[i];
        }
        
        return ans;
    }
    
    public int[] MostOptimized(int[] A)
    {
        // Based on optimization of MI
        int n = A.length;
        int product = 1;
        int[] ans = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            ans[i] = product;
            product = product * A[i];
        }
        
        product = 1;
        for(int i = n-1; i >= 0; i--)
        {
            ans[i] = ans[i] * product;
            product = product * A[i];
        }
        
        return ans;
    }
}