class Solution {

    // https://leetcode.com/explore/interview/card/top-interview-questions-easy/98/design/670/discuss/86006/simple-java-solution
    
    private int[] nums;
    
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int[] reset() {
        return this.nums;
    }
    
    public int[] shuffle() {
        
        if(nums == null) 
            return null;
        
        int[] rand = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++){
            
            
            // Because of Math.random. It returns a positive double value >= 0.0 and < 1.0.
            // suppose array length is 10 then in the last iteration i would be 9.
            // If we multiply this with random, the minimum you get is 0 and maximum value you get is 8 not 9 because random generates value less than 1.But you need random number out of 10 elements.i.e from 0 to 9.so you need to bump the i by 1 otherwise you weren't giving chance for the last element in this iteration.
            // Pick a random index from 0 to i
            int r = (int) (Math.random() * (i+1));
            // System.out.print(r);
            // Swap A[i] with the element at random index
            rand[i] = rand[r];
            rand[r] = nums[i];
        }
        
        return rand;    
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */