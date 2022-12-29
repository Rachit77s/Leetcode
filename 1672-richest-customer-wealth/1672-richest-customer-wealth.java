class Solution {
    public int maximumWealth(int[][] accounts) {
        
        int row = accounts.length;
        int col = accounts[0].length;
        
        int ans = Integer.MIN_VALUE;
        
        for(int i = 0; i < row; i++)
        {
            int sum = 0;
            for(int j = 0; j < col; j++)
            {
                sum +=  accounts[i][j];
            }
             
            ans = Math.max(ans, sum);
        }
        
        return ans;
    }
}