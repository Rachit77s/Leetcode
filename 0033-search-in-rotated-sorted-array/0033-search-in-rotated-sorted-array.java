class Solution {

    // subham: https://www.scaler.com/help_requests/694867/?ref=join-call-now    
    public int search(int[] nums, int target) {
        int n = nums.length;
        
        int pivot = findPivot(nums);

        int idx1 = Arrays.binarySearch(nums, 0, pivot, target);
        int idx2 = Arrays.binarySearch(nums, pivot, n, target);

        // for(int idx : new int[]{idx1, idx2}){
        //     if(idx < 0){
        //         idx = -idx - 1;
        //     }
        //     if (idx < n && nums[idx] == target) 
        //         return idx;
        // }
        
        if (idx1 < 0)
            idx1 = -idx1 - 1;   // -1 because index can be at max -1
        
        if (idx2 < 0)
            idx2 = -idx2 - 1;
        
        if (idx1 < n && nums [idx1] == target)
            return idx1;
        else if (idx2 < n && nums [idx2] == target)
            return idx2;
        
        return -1;
    }
    
    private int findPivot(int[] nums) 
    {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int minVal = Math.min(nums[mid], Math.min(nums[left], nums[right]));
            if (minVal == nums[right])
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }
}