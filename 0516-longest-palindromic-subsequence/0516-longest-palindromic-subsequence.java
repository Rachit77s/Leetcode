class Solution {
    
    int[][] dp;
    
    public int longestPalindromeSubseq(String s) {
        
        return LCSHelper(s);
    }

    public int LCSHelper(String A)
    {
        if(A == null)
            return 0;
            
        dp = new int[A.length() + 1][A.length() + 1];

        StringBuilder input1 = new StringBuilder(A);
        // append a string into StringBuilder input1
        // input1.append(input);
        // reverse StringBuilder input1
        input1.reverse();

        String reverse = input1.toString();


        for(int i = 0; i <= A.length(); i++)
        {
            for(int j = 0; j <= reverse.length(); j++)
            {
                dp[i][j] = -1;
            }
        }

        return LCS(A, A.length(), reverse, reverse.length());
    }

    public int LCS(String A, int i, String B, int j)
    {
        if(i <= 0 || j <= 0)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        if(A.charAt(i-1) == B.charAt(j-1))
            return dp[i][j] = 1 + LCS(A, i - 1, B, j - 1);
        else
            return dp[i][j] = Math.max(LCS(A, i, B, j - 1), LCS(A, i - 1, B, j));
    }
}