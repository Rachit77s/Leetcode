class Solution {
    public int missingNumber(int[] nums) {
     
        return CyclicSort(nums);
        // return XORApproach(nums);
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
    
    // Kunal: https://www.youtube.com/watch?v=JfinxytTYFQ
    public int CyclicSort(int[] A)
    {
        int i = 0;
        int n = A.length;
        
        // Range o to n this means every element will be at its own index
        // Idx: 0 1 2
        // ele: 0 1 2   <-- array

        
        while(i < n)
        {
            int correctIndex = A[i];
            // Check index out of bound
            if(A[i] < n && A[i] != A[correctIndex])
            {
                // SWAP
                int temp = A[i];
                A[i] = A[correctIndex];
                A[correctIndex] = temp;
            }
            else
                i++;
        }
        
        // Search for missing number
        for(int index = 0; index < n; index++)
        {
            if(A[index] != index)
                return index;
        }
        
        // Edge case
        return n;
    }
}