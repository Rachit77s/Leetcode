class Solution {
    public int findMin(int[] nums) {
        
        return GetMinPivotElement(nums);
    }
    
    public int GetMinPivotElement(int[] A)
    {
        int low = 0;
        int high = A.length - 1;
        int n = A.length;
        
        if(A.length == 1)
        {   
            return A[0];
        }
        
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            
            if(mid + 1 < n && A[mid + 1] < A[mid])
                return A[mid + 1];
            
            if(mid - 1 >= 0 && A[mid - 1] > A[mid])
                return A[mid];
            
            if(A[low] >= A[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        return A[0];
    }
}