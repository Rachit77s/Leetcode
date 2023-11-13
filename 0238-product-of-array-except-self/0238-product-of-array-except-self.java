class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        return ApproachI(nums);
    }
    
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
}