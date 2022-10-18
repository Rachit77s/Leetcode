class Solution {
    public int firstMissingPositive(int[] nums) {
//           int n = nums.length;
    
//     // 1. mark numbers (num < 0) and (num > n) with a special marker number (n+1) 
//     // (we can ignore those because if all number are > n then we'll simply return 1)
//     for (int i = 0; i < n; i++) {
//         if (nums[i] <= 0 || nums[i] > n) {
//             nums[i] = n + 1;
//         }
//     }
//     // note: all number in the array are now positive, and on the range 1..n+1
    
//     // 2. mark each cell appearing in the array, by converting the index for that number to negative
//     for (int i = 0; i < n; i++) {
//         int num = Math.abs(nums[i]);
//         if (num > n) {
//             continue;
//         }
//         num--; // -1 for zero index based array (so the number 1 will be at pos 0)
//         if (nums[num] > 0) { // prevents double negative operations
//             nums[num] = -1 * nums[num];
//         }
//     }
    
//     // 3. find the first cell which isn't negative (doesn't appear in the array)
//     for (int i = 0; i < n; i++) {
//         if (nums[i] >= 0) {
//             return i + 1;
//         }
        
        return SolutionII(nums);
    //}
    
    // 4. no positive numbers were found, which means the array contains all numbers 1..n
   // return n + 1;
    }
    
    public int SolutionII(int[] A)
    {
        for(int i=0;i<A.length;i++)
        {
            // Avoiding -ve numbers and nums>A.length
            if(A[i] >= A.length || A[i] < 1)
                continue;
            
            // Swapping multiple condition to avoid same numbers, num>A.length, num<1,  cur num is already at crct place
            while(A[i]!=(i+1) && A[i]<A.length && A[i]>0 && A[i]!=A[A[i]-1])
            {
                int t=A[i];
                A[i]=A[t-1];
                A[t-1]=t;
            }
         }
        
         // Validatng
        for(int i=0;i<A.length;i++)
        {
            if(A[i]!=(i+1))
                return i+1;
        }
        
        // Edge case
        if(A[A.length-1] == A.length)
            return A.length + 1;
        
        return 1;

    }
}