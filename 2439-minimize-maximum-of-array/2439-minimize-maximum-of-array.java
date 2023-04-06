class Solution {
    public int minimizeArrayValue(int[] A) {
        
        return NeetcodeApproach(A);
    }
    
    public int NeetcodeApproach(int[] A)
    {
        // Neetcode: https://www.youtube.com/watch?v=AeHMvcKuR0Y 
    
    /*
        Observation 1: 
        The result/ans can't be possibly smaller than the first value in the array.
        Example1:           0  1  2  3
                            3  7  1  6
        prefix sum:         3 10 11 17
        Avg till ith index: 3 5  4   5  Take Ceil here
                    
        
        Example2:
                            0  1  2   3
                            4  3  8   6
        prefix sum:         4  7  15  21
        Avg till ith index: 4  4  5   6  Take Ceil here
        
        
        Example3:
                            0  1  2   3  4
                            4  3  1   1  6
        prefix sum:         4  7  8   9  15
        Avg till ith index: 4  4  3   3  3   Take Ceil here
        
    */
        
        long sum = A[0], ans = A[0];
        
        for(int i = 1; i < A.length; i++)
        {
            sum = sum + A[i];
            
            int ceilValue = (int)Math.ceil(sum / (i+1.0));
            
            ans = Math.max(ans, ceilValue);
        }
        
        return (int)ans;
    }
}