class Solution {
    public int minDistance(String word1, String word2) {
        
        int m = word1.length();
        int n = word2.length();
        
        int[][] cost = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++)
            cost[i][0] = i;
        for(int i = 1; i <= n; i++)
            cost[0][i] = i;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(word1.charAt(i) == word2.charAt(j))
                    cost[i + 1][j + 1] = cost[i][j];
                else {
                    int a = cost[i][j];
                    int b = cost[i][j + 1];
                    int c = cost[i + 1][j];
                    cost[i + 1][j + 1] = a < b ? (a < c ? a : c) : (b < c ? b : c);
                    cost[i + 1][j + 1]++;
                }
            }
        }
        return cost[m][n];
        
        // return TopDownHelper(word1, word2);
    }
    
    public int TopDownHelper(String s1, String s2) 
    {
        int L1 = s1.length();
        int L2 = s2.length();
        
        int[][] dp = new int[L1 + 1][L2 + 1];
        
        for(int i = 0; i <= L1; i++)
        {
            for(int j = 0; j <= L2; j++)
            {
                dp[i][j] = -1;
            }
        }
        
        return EditDistanceTopDown(s1, s2, L1, L2, dp);
    }
    
    public int EditDistanceTopDown(String s1, String s2, int L1, int L2, int[][] dp) 
    {
        if(L1 == 0)
            return L2;
        
        if(L2 == 0)
            return 0;
        
        if(dp[L1][L2] != -1)
            return dp[L1][L2];
        
        if(s1.charAt(L1 - 1) == s2.charAt(L2 - 1))
        {
            return EditDistanceTopDown(s1, s2, L1 - 1, L2 - 1, dp);
        }
        else
        {
            dp[L1][L2] = 1 + 
                Math.min(EditDistanceTopDown(s1, s2, L1 - 1, L2 - 1, dp),
                Math.min(EditDistanceTopDown(s1, s2, L1, L2 - 1, dp),
                        EditDistanceTopDown(s1, s2, L1 - 1, L2, dp)));
        }
        
        return dp[L1][L2];
    }
}