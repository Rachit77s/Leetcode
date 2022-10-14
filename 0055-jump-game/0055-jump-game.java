class Solution {
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        
        int i = 0;
        int currFarther = 0;
        
        if(nums[0] == 0 && n > 1)
            return false;
        
        while(i < n && i <= currFarther)
        {
            currFarther = Math.max(i+ nums[i], currFarther);
            // System.out.print(currFarther + " ");
            
            if(i == currFarther)
                break;
            
            i++;       
        }
        
        
        return i >= n-1;
    }
}