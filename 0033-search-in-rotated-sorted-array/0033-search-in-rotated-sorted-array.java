class Solution {
    public int search(int[] nums, int target) {
        
        // Babbar Code Help
        return Helper(nums, target);
    }
    
    public int Helper(int[] A, int target) 
    {
        if(A.length == 1)
        {
            if(A[0] == target)
                return 0;
            
            return -1;
        }
            
        
        int pivotIndex = GetPivotIndex(A);
        
        if(target >= A[0] && target <= A[pivotIndex])
        {
            // Search in the array1 i.e. 1st sorted array
            // Search from 0 to Pivot index
            int ans = BinarySearch(A, target, 0, pivotIndex);
            return ans;
        }
        
        if(pivotIndex + 1 < A.length && target >= A[pivotIndex + 1] && target <= A[A.length - 1])
        {
            // Search in the array2 i.e. 2nd sorted array
            // Search from Pivot index + 1 to N - 1
            int ans = BinarySearch(A, target, pivotIndex + 1, A.length - 1);
            return ans;
        }
        
        // Target doesn't exists
        return -1;
    }
    
    public int GetPivotIndex(int[] A) 
    {
        int left = 0;
        int right = A.length - 1;
        int n = A.length;
        
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            
            // Check for those 2 abnormal cases which are breaking the sorted order.
            // Since we know in sorted array mid+1 will always be greater than mid.
            if(mid + 1 < n && A[mid] > A[mid + 1])
                return mid;
            
            if(mid - 1 >= 0 && A[mid - 1] > A[mid])
                return mid - 1;
            
            // Assumption: Pivot will be the largest element in the array.
            // Start ele will be lesser than mid element in sorted array.
            // Compare the start element with mid. 
            // Go towards the abnormality.
            if(A[left] >= A[mid])    // Go left
                right = mid - 1;
            else // if(A[mid] > A[start])  // Go right
                left = mid + 1;
        }
        
        return 0;
    }
    
    public int BinarySearch(int[] A, int target, int left, int right)
    {
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            
            if(A[mid] == target)
                return mid;
            
            if(A[mid] > target)
                right = mid - 1;
            else 
                left = mid + 1;
        }
        
        return -1;
    }
}