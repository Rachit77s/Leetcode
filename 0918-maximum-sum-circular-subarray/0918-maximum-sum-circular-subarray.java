class Solution {
    public int maxSubarraySumCircular(int[] A) {
        
        return KadaneWithInversion(A);
    }

    
    public int KadaneWithInversion(int[] A)
    {

        int n = A.length;
        
        int kadaneSum = Kadane(A);
        
        // Make all the elements in the array -ve
        int totalSum = 0;
        for(int i=0; i<A.length;i++){
            totalSum += A[i];
            A[i] *= -1;
        }
        
        int negativeKadaneSum = Kadane(A);
        
        if(totalSum+negativeKadaneSum == 0) 
            return kadaneSum;
        
        return  Math.max(kadaneSum, totalSum+negativeKadaneSum);
    }
    
    private int Kadane(int[] A)
    {
        int n = A.length;
        int currSum = A[0];
        int globalSum = A[0];
        
        for(int i = 1; i < n; i++)
        {
            currSum += A[i];
            
            if(currSum < A[i]) 
                currSum = A[i];
            
            globalSum = Math.max(globalSum, currSum);
        }
        
        return globalSum;
    }
}