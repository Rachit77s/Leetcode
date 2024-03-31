class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        for(int index = 0; index < 2 * n; index++)
        {
            // IDX: 0 1 2 3 4 5
            // 2 1
            while(!stack.isEmpty() && nums[index % n] > nums[stack.peek()])
            {
                ans[stack.peek()] = nums[index % n];
                stack.pop();
            }
            
            if(index < n)
                stack.push(index);
        }
        
        return ans;
    }
}