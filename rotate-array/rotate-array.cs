public class Solution {
    public void Rotate(int[] nums, int k) {
        k = k % nums.Length;
        
        Reverse(nums, 0 , nums.Length - 1);
        Reverse(nums, 0 , k-1);
        Reverse(nums, k , nums.Length - 1);
        
        // nums = [1,2,3,4,5,6,7], k = 3
        //        [7,6,5,4,3,2,1]
        //        [5,6,7,4,3,2,1]
        //        [5,6,7,1,2,3,4]
        // Output: [5,6,7,1,2,3,4]
    }
    
    public void Reverse(int[] nums, int left, int right)
    {
        // for(int i=0; i<nums.Length; i++)
        // {
        //     int temp = nums[i];
        //     nums[i] = nums[nums.Length - 1 - i];
        //     nums[nums.Length - 1 - i] = temp;
        // }
        
        while(left < right)
        {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            
            left += 1;
            right -= 1;
        }
    }
}