class Solution {
    public int findDuplicate(int[] nums) {
        
        return CyclicSort(nums);
    }
    
    // Kunal: https://www.youtube.com/watch?v=JfinxytTYFQ
    public int CyclicSort(int[] A)
    {
        int i = 0;
        int n = A.length;
        
        // Range 1 to n this means every element will be at its index - 1
        // CorrectIndex = elementValue - 1
        
        // Idx: 0 1 2
        // ele: 1 2 3   <-- array

        
        while(i < n)
        {
            // Since range is [1, n]
            int correctIndex = A[i] - 1;
            
            if(A[i] != A[correctIndex])
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
            if(A[index] != index + 1)
                return A[index];
        }
        
        // Edge case
        return -1;
    }
}