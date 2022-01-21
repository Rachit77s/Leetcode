public class Solution {
    public int FindMaxLength(int[] nums) {
        
        return Optimized(nums);
    }
    
    public int Optimized(int[] A)
    {
        Dictionary<int, int> dict = new Dictionary<int, int>();
        dict.Add(0, -1);
        int sum = 0;
        int ans = 0;
        
        for(int i=0; i<A.Length; i++)
        {
            // consider 0 as -1 and 1 as +1
            if(A[i] == 0)
                sum = sum - 1;
            else
                sum = sum + 1;
            
            
            // If same sum is seen again, it means that subarray has same no of 0s and 1s.
            if(dict.ContainsKey(sum))
            {
                ans = Math.Max(ans, i - dict[sum]);
            }
            else
            {
                dict.Add(sum, i);
            }
        }
        
        return ans;
    }
    
    public int OptimalTwo(int[] nums)
    {
        Dictionary<int, int> dict = new Dictionary<int, int>();
        int sum = 0;
        int maxLength = 0;
        int endingIndex = -1;
        int N = nums.Length;
        
        ///Replace 0 with -1
        for(int i=0; i<N; i++)
        {
            if(nums[i] == 0)
                nums[i] = -1;
        }
        
        for(int i=0; i<N; i++)
        {
            sum += nums[i];
                    
            if(sum == 0)
            {
                maxLength = i+1;
                endingIndex = i;
            }
            
            if(dict.ContainsKey(sum))
            {
                maxLength = Math.Max(maxLength, i - dict[sum]);
            }
            else
            {
                dict.Add(sum, i);
            }
        }
        
        return maxLength;
    }
    
    // T.C.: O(N^2), S.C.: O(1)
    /*
        Run two FOR loops to make all the possible subarrays.
        Count the no of zeros and ones in each subarray. If both the counts become equal
        then keep track of the maxLength between them.
    */
   
    public int BruteForce(int[] A)
    {
        int maxLength = 0;
       
        for(int i=0; i<A.Length; i++)
        {
            int zeroCount = 0;
            int oneCount = 0;
           
            for(int j=i; j<A.Length; j++)
            {
                if(A[j] == 0)
                    zeroCount++;
                else
                    oneCount++;
               
                if(zeroCount == oneCount)
                {
                    maxLength = Math.Max(maxLength, j - i + 1);
                }
            }
        }
       
        return maxLength;        
    }

}