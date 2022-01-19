public class Solution {
    public int MissingNumber(int[] nums) {
     
        //return XORApproach(nums);
        return SumApproach(nums);
        return TrickyApproach(nums);
    }
    
    // T.C.: O(N), S.C.: O(1)
    public int XORApproach(int[] A)
    {
        /*
            Observation:
            1. I/P: 3,0,1
            (3^0^1) ^ (0^1^2^3)     ==> Every element cancels out and return the missing no
        */
       
        // XOR Of given Array Numbers from 0 to N - 1
        int xor1 = A[0];
        for(int i=1; i< A.Length; i++)
        {
            xor1 = xor1 ^ A[i];
        }
       
        // XOR Of Natural Numbers from 0 to N
        int xor2 = 0;
        for(int i=1; i<= A.Length; i++)
        {
            xor2 = xor2 ^ i;
        }
       
        return xor1 ^ xor2;
       
        // int res = nums.Length;
        // for(int i=0; i<nums.Length; i++){
        //     res = res ^ i ^ nums[i]; // a^b^b = a
        // }
        // return res;
    }
   
    // T.C.: O(N), S.C.: O(1)   OVERFLOW
    public int SumApproach(int[] nums)
    {
        int n = nums.Length;        
        int totalArraySum = 0;
       
        foreach (int num in nums)
        {
            totalArraySum += num;
        }
       
        // Natural numbers sum
        int expectedSum = n * (n + 1) / 2;
       
        return expectedSum - totalArraySum;
    }
   
    // Fastest Runtime
    public int TrickyApproach(int[] nums)
    {
        int i = 0;
        int length = nums.Length;
       
        while (i < length)
        {
            //swap nums at i and nums[i]-1
            if (nums[i] > 0 && nums[i] != nums[nums[i]-1])
            {
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
            else
            {
                i++;
            }
        }
       
        for (i = 0; i < length; i++)
        {
            if (nums[i] != i + 1)
            {
                return i + 1;
            }
        }
       
        return 0;
    }
   
    // T.C.: O(N), S.C.: O(N)
    public int HashingApproach(int[] A)
    {
        return 1;
    }
}