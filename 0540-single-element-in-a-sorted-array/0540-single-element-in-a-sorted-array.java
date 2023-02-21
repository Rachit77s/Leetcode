class Solution {
    public int singleNonDuplicate(int[] nums) {
                
        // https://www.youtube.com/watch?v=nMGL2vlyJk0
        
        //We need 1st occurrence, check occur is even or odd, if even left part, odd right part
        if(nums == null || nums.length == 0) 
            return -1;
        
        int n = nums.length;
        int low = 0;
        int high = n-1;
        
        //Base Cases
        
        //1.
        if(n == 1)
            return nums[0];
        
        //2. Mid is on extreme left
        if(nums[0] != nums[1])
            return nums[0];
        
        
        //3. Mid is on extreme right
        if(nums[n-1] != nums[n-2])
            return nums[n-1];
        
        
        // The pair will always start at even index
        // and end at odd index.
        // If this is the case, no unique element present.
        while(low <= high)
        {
            int mid = (high + low) / 2;
            
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])
                return nums[mid];
            
            if(nums[mid] == nums[mid-1])
                mid = mid-1;
            
            if(mid % 2 == 0)
            {
                low = mid+2;
            }
            else
            {
                high = mid-1;              
            }
            
        }
        
        return -1;
    }
}