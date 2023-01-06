class Solution {
    public int maxIceCream(int[] costs, int coins) {
        
        return HelperI(costs, coins);
    }
    
    public int HelperI(int[] A, int coins) 
    {
        Arrays.sort(A);
        int ans = 0;
        
        for(int i = 0; i < A.length; i++)
        {
            if(coins >= A[i])
            {
                coins -= A[i];
                ans++;
            }
        }
        
        return ans;
    }
}