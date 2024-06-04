class Solution {
    public int findMaxLength(int[] nums) {
        
        //  0  1  2  3  4  5  6
        // {1, 0, 1, 1, 1, 0, 0};
        //  1 -1  1  1  1 -1 -1
        
        //  0  1  0  1  2  3  2  1
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0)
                nums[i] = -1;
        }
        
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 0;
        
        for(int i = 0; i < nums.length; i++) 
            prefix[i+1] = prefix[i] + nums[i];
        
        int ans = Integer.MIN_VALUE;
        
        for(int i = 0; i < prefix.length; i++) {       
            if(map.containsKey(prefix[i])) {
                ans = Math.max(ans, i - map.get(prefix[i]));
            } else {
                map.put(prefix[i], i);
            }
        }
        
        if(ans == Integer.MIN_VALUE)
            return 0;
        
        return ans;
    }
}