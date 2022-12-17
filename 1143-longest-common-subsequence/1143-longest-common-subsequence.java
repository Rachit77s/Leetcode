class Solution {
    private int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        
//         dp = new Integer[text1.length()][text2.length()];
        
//         return Helper(text1, text2, 0, 0);
        
        return LongestCommonSubsequenceIterative(text1, text2);
        // return TopDownHelper(A, B);
    }

    public int TopDownHelper(String A, String B)
    {
        dp = new int[A.length() + 1][B.length() + 1];

        for(int i = 0; i <= A.length(); i++)
        {
            for(int j = 0; j <= B.length(); j++)
            {
                dp[i][j] = -1;
            }
        }

        return LongestCommonSubsequence(A, A.length(), B, B.length());
    }

    public int LongestCommonSubsequence(String A, int la, String B, int lb)
    {
        // Base Case
        if(la == 0 || lb == 0)
            return 0;

        if(dp[la][lb] != -1)
            return dp[la][lb];

        if(A.charAt(la - 1) == B.charAt(lb - 1))
        {
            dp[la][lb] = 1 + LongestCommonSubsequence(A, la - 1, B, lb - 1);
        }
        else
        {
            dp[la][lb] = Math.max(LongestCommonSubsequence(A, la - 1, B, lb), 
                                  LongestCommonSubsequence(A, la, B, lb - 1));
        }

        return dp[la][lb];
    }

    public int LongestCommonSubsequenceIterative(String A, String B)
    {
        int la = A.length();
        int lb = B.length();
        dp = new int[A.length() + 1][B.length() + 1];

        for(int i = 0; i <= A.length(); i++)
        {
            for(int j = 0; j <= B.length(); j++)
            {
                dp[i][j] = -1;
            }
        }

        for(int i = 0; i <= A.length(); i++)
        {
            for(int j = 0; j <= B.length(); j++)
            {
                if(i == 0 || j == 0)
                {
                    dp[i][j] = 0;
                }
                // Last chars are equal, get the diagonal elements
                else if(A.charAt(i - 1) == B.charAt(j - 1))
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[la][lb];
    }
    
    public int Helper(String text1, String text2, int i, int j) 
    {
        if(i == text1.length())
            return 0;
        
        if(j == text2.length())
            return 0;
        
//         if (dp[i][j] != null)
//             return dp[i][j];
        
        if(text1.charAt(i) == text2.charAt(j))
            return dp[i][j] =  1 + Helper(text1, text2, i+1, j+1);
        else
            return dp[i][j] =  Math.max(Helper(text1, text2, i+1, j), Helper(text1, text2, i, j+1));
    }
}