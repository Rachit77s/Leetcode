class Solution {
    private Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        
        dp = new Integer[text1.length()][text2.length()];
        
        return Helper(text1, text2, 0, 0);
    }
    
    public int Helper(String text1, String text2, int i, int j) 
    {
        if(i == text1.length())
            return 0;
        
        if(j == text2.length())
            return 0;
        
        if (dp[i][j] != null)
            return dp[i][j];
        
        if(text1.charAt(i) == text2.charAt(j))
            return dp[i][j] =  1 + Helper(text1, text2, i+1, j+1);
        else
            return dp[i][j] =  Math.max(Helper(text1, text2, i+1, j), Helper(text1, text2, i, j+1));
    }
}