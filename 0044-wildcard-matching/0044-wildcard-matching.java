class Solution {

    // boolean [][]dp;
    
    int[][] dp;
    
    public boolean isMatch(String s, String p) {
        

        // return BottomUp(s, p);
        
        if (TopDownHelper(s, p) == 1)
            return true;
        
        return false;
    }
    
    public int TopDownHelper(String s, String p) 
    {
        dp = new int[s.length() + 1][p.length() + 1];
        
        // for (int i = 0; i < s.length() + 1; i++)
        //     Arrays.fill(dp[i], -1);
        
        for (int i = 0; i < s.length() + 1; i++) 
        {
            for (int j = 0; j < p.length() + 1; j++) 
            {
                dp[i][j] = -1;
            }
        }
        
        return IsMatchTopDown(s, s.length(), p, p.length());
    }
    
    // Pass the length of the string
    // l = 0 string is null
    public int IsMatchTopDown(String s, int ls, String p, int lp)
    {
        if(ls == 0 && lp == 0)
            return 1;
        
        if(lp == 0)
            return 0;
        
        // Tricky case: If string is empty, then
        // check if pattern has all the starts,
        // if yes, return true.
        if(ls == 0)
        {
            // Iterate the patter to check for all stars
            for(int i = 0; i < lp; i++)
            {
                if(p.charAt(i) != '*')
                    return 0;
            }
            
            return 1;
        }
        
        if(dp[ls][lp] != -1)
            return dp[ls][lp];
        
        // Case 1: Last char is a lowercase
        // Last char matches
        if(s.charAt(ls - 1) == p.charAt(lp - 1))
        {
            return dp[ls][lp] = IsMatchTopDown(s, ls - 1, p, lp - 1);
        }
        // Case 2: Last char is a "."
        else if(p.charAt(lp - 1) == '?')
        {
            return dp[ls][lp] = IsMatchTopDown(s, ls - 1, p, lp - 1);
        }
        // Case 3: Last char is a "*"
        else if(p.charAt(lp - 1) == '*')
        {
            /*
                Option1: * matches with 0 char
                s = abba
                p = a*
                IsMatchTopDown(s, ls, p, lp - 1)
                
                Option2: * matches with 1 or more char
                s = abba
                p = xb*
                IsMatchTopDown(s, ls - 1, p, lp)
            */
            
            return dp[ls][lp] = (IsMatchTopDown(s, ls, p, lp - 1) == 1 ||
                         IsMatchTopDown(s, ls - 1, p, lp) == 1) ? 1 : 0;
        }
        else
        {
            return dp[ls][lp] = 0;
        }
        
        // return dp[ls][lp];
    }
    
    public boolean BottomUp(String s, String p)
    {
        boolean[][] dp2 = new boolean[s.length()+1][p.length()+1];
        
        int ls = s.length();
        int lp = p.length();
        
        // Base case: s & p both are 0
        dp2[0][0] = true;
        
        // When the string is empty, check the pattern for *
        for (int i = 1; i <= lp ; i++) 
        {
            if (p.charAt(i-1) == '*') 
                dp2[0][i] = true;
            else
                break;
        }
        
        for (int i = 1; i <= ls; i++) 
        {
            for (int j = 1; j <= lp; j++) 
            {
                if (s.charAt(i-1) == p.charAt(j-1) || 
                    p.charAt(j-1) == '?')
                {
                    dp2[i][j] = dp2[i-1][j-1];
                }
                else if (p.charAt(j-1) == '*') 
                {   
                     dp2[i][j] = dp2[i][j-1] | dp2[i-1][j];
                } 
            }
        }
        
        return dp2[s.length()][p.length()];
    }
}