class Solution {
    public int minDistance(String word1, String word2) {
        
        return TopDownHelper(word1, word2);
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
            return L1;
        
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