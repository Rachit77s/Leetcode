class Solution {
    public int search(int[] nums, int target) {
        
        // return Template1(nums, target);
        return Template2(nums, target);
    }
    
    public int Template1(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right)
        {
            int mid = left + (right - left) / 2;
            
            if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        
        if(nums[left] == target) 
            return left;
        
        return -1;
    }
    
    // https://www.youtube.com/watch?v=UZx_DI4z_l8
    // https://leetcode.com/problems/binary-search/discuss/3363888/Image-Explanation-MOST-Generalized-Binary-Search-C%2B%2BJavaPython
    public int Template2(int[] nums, int target) 
    {
        int l = 0, r = nums.length - 1;
        
        while (l < r) 
        {
            int mid = l + (r - l) / 2;
            
            if (nums[mid] >= target)
                r = mid;
            else
                l = mid + 1;  
        }

        if (nums[l] != target) return -1;
        return l;
    }
}