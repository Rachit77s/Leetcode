class Solution {
    public int maxSizeSlices(int[] slices) {
        
        return maxSizeSlicesHelper(slices);
        // return BruteForceHelper(slices);
    }
    
    // Babbar Paid Course
    public int BruteForceHelper(int[] A) 
    {
        int totalSlice = A.length;
        
        // Option1: Include the 1st element of the array, so we can't take last element
        int option1Include = BruteForce(A, 0, A.length - 2, totalSlice / 3);
        
        // Option2: Don't Include the 1st element of the array
        int option2Exclude = BruteForce(A, 1, A.length - 1, totalSlice / 3);
        
        return Math.max(option1Include, option2Exclude);
    }
    
    public int BruteForce(int[] A, int start, int end, int slicesLeft) 
    {
        // Base Case
        if(slicesLeft == 0 || start > end)
            return 0;
        
        // Take  current element and skip adjacent one
        int include = A[start] + BruteForce(A, start + 2, end, slicesLeft - 1);
        int exclude = BruteForce(A, start + 1, end, slicesLeft);
        
        return Math.max(include, exclude);
    }
    
    public int maxSizeSlicesHelper(int[] slices) {
        int m = slices.length, n = m / 3;
        int[] slices1 = Arrays.copyOfRange(slices, 0, m-1);
        int[] slices2 = Arrays.copyOfRange(slices, 1, m);
        return Math.max(maxSum(slices1, n), maxSum(slices2, n));
    }

    int maxSum(int[] arr, int n) { // max sum when pick `n` non-adjacent elements from `arr`
        int m = arr.length;
        int[][] dp = new int[m+1][n+1]; // dp[i][j] is maximum sum which we pick `j` elements from linear array `i` elements
        // Case j = 0 (pick 0 elements): dp[i][0] = 0
        // Case i = 0 (array is empty): dp[0][j] = 0
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (i == 1) { // array has only 1 element
                    dp[i][j] = arr[0]; // pick that element
                } else {
                    dp[i][j] = Math.max(
                        dp[i-1][j],             // don't pick element `ith`
                        dp[i-2][j-1] + arr[i-1] // pick element `ith` -> dp[i-2][j-1] means choose `j-1` elements from array `i-2` elements
                                                //   because we exclude adjacent element `(i-1)th`
                    );
                }
            }
        }
        return dp[m][n];
    }
}