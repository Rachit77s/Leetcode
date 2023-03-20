class Solution {
    public int firstMissingPositive(int[] nums) {
        
        return Helper(nums);
    }
    
    
    public int Helper(int[] A) 
    {
        int i = 0;
        int n = A.length;
        
        while(i < n)
        {
            int correctIndex = A[i] - 1;
            
            // Check for +ve numbers only
            if(A[i] > 0 && A[i] <= n && 
               A[i] != A[correctIndex])
            {
                Swap(A, i, correctIndex);
            }
            else
                i++;
        }
        
        for (int index = 0; index < n; index++) 
        {
            if (A[index] != index + 1) {
                return index + 1;
            }
        }

        // case 2
        return n + 1;
    }

    static void Swap(int[] arr, int first, int second) 
    {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}