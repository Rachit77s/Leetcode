class Solution {
    public int search(int[] nums, int target) {
        
        return ModifiedBinarySearch(nums, target);
    }
    
    public int ModifiedBinarySearch(int[] A, int target)
    {
        // Observation: At least the left half or the right half would have a strictly increasing graph.
        // i.e. It is compulsory that either the left half will be sorted or the right half will be sorted.
       
        int low = 0;
        int high = A.length - 1;
       
        while(low <= high)
        {
            int mid = (low + high) / 2;
           
            // Step 1: Check if mid equals target
            if(A[mid] == target)
            {
                return mid;
            }
           
            // Check if the left half has a uniformly increasing curve i.e. This means the Left side would be sorted.
            if(A[mid] >= A[low])
            {
                // Figure out if the target lies in this range of { Low to Mid } or not.
                if(target >= A[low] && target <= A[mid])
                {
                    // Decrease the search to this range only, as the target lies in this range.
                    high = mid - 1;
                }
                else
                {
                    // Discard the entire left half range as the target element was not present in the left half.
                    // Hence it might be present in the right half.
                    low = mid + 1;
                }
            }
            // Else, the right half would be strictly increasing i.e. the right half would be sorted.
            else
            {
                // Check if the target lies in this range of { Mid to High } or not.
                if(target >= A[mid] && target <= A[high])
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
        }
       
        return -1;
    }
}