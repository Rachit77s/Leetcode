class Solution {
    public int missingNumber(int[] nums) {
     
        return XORApproach(nums);
        // return TrickyApproach(nums);
    }
    
    public int XORApproach(int[] A)
    {
        int xor1 = A[0];
        for(int i = 1; i < A.length; i++)
            xor1 = xor1 ^ A[i];
        
        int xor2 = 0;
        for(int i = 1; i <= A.length; i++)
            xor2 = xor2 ^ i;
        
        return xor1 ^ xor2;
    }
    
    public int TrickyApproach(int[] A)
    {
        int i = 0;
        int n = A.length;
        
        while(i < n)
        {
            while(A[i] > 0 && A[i] != A[A[i] - 1])
            {
                int temp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = temp;
            }
            
            i++;
        }
        
        for (i = 0; i < n; i++)
        {
            if (A[i] != i + 1)
            {
                return i + 1;
            }
        }
        
        return 0;
    }
}