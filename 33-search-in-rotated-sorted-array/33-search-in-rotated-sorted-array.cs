public class Solution {
    public int Search(int[] nums, int target) {
        
        return ModifiedBinarySearch(nums, target);
    }
    
    public int ModifiedBinarySearch(int[] nums, int target) 
    {
        /*
        // Observation: 
             
        1. At least the left half or the right half would have a strictly increasing graph.
        2. i.e. It is compulsory that either the left half will be sorted or the right half                 will be sorted.
        */
        
        int low = 0;
        int high = nums.Length - 1;
        
        while(low <= high)
        {
            int mid = (low + high) / 2;
            
            // Check if mid equals target
            if(nums[mid] == target)
            {
                return mid;
            }
            // Check if the left half has a uniformly increasing curve i.e. This means the Left side would be sorted.    
            else if(nums[low] <= nums[mid])
            {
                // Figure out if the target lies in this range of { Low to Mid } or not.
                if(target >= nums[low] && target <= nums[mid])
                {
                    // Decrease the search to this range, as the target lies in this range.
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
                if(target >= nums[mid] && target <= nums[high])
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