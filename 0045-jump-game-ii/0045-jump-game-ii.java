class Solution {
    public int jump(int[] nums) {
        
        int n = nums.length;
        int jump = 0;
        int currEnd = 0;
        int fartherEnd = 0;
        
        for(int j = 0; j < n -1; j++)
        {
            fartherEnd = Math.max(fartherEnd, j + nums[j]);
            
            if(j == currEnd)
            {
                jump++;
                currEnd = fartherEnd;
            }
        }

        return jump;
    }
}