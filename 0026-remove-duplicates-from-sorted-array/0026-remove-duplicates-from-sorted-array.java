class Solution {
    public int removeDuplicates(int[] nums) {
        
        int index = 0;
        int prev = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != prev)
            {
                nums[index] = nums[i];
                prev = nums[i];
                index++;
            }
        }
        
        return index;
    }
}