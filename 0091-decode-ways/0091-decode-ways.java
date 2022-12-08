class Solution {
    public int numDecodings(String s) {
        
        /*
            Ask yourself following questions in a DP problem:

            1. What is the element of choice?
            2. Can we solve the problem using Recursion?
            3. What is the Recursive Relation?
            4. What is the Base Case?
            5. Does the problem has Overlapping Subproblems?

                a. What is the size of the DP array or what is the number of states?
                b. What does DP[i] denotes?
                c. What is the DP expression?
                d. What is the final answer state?


            7 Steps of DP:-

            1. What is the element of choice?
                Can we solve the problem using Recursion?
                What is the Recursive Relation?
                Verify if it has Optimal Substructure and Overlapping Subproblems
            2.  What is the DP state? i.e. dp[i] ?
            3.  What is the DP expression?
            4.  What does the DP table contains or it's capacity?
            5.  What is the DP code base condition?
            6.  Write the DP code
            7.  Figure out the TC and SC.
            8.  Optimization in SC

        */
        
        return BottomUpI(s);
        // return TopDownDPHelper(s);
        // return BruteForce(s, 0);
    }
    
    public int BruteForce(String s, int i)
    {
        // Element of choice is
        // Read it as a single digit
        // Read it as a double digit
        
        // TopDown(n-1);
        // dp[n] = dp[n-1] + dp[n-2];
        
        if(i >= s.length())
            return 1;
        else if(s.charAt(i) == '0')
            return 0;
        else if(i == s.length() - 1)
            return 1;
        // We can take 2 digits
        // If char is 1 or char is 2 then check its 2nd digit is from 0 to 6
        else if(s.charAt(i) == '1' || 
           (s.charAt(i) == '2' && (s.charAt(i+1) >= '0' && s.charAt(i+1) <= '6')))
            return BruteForce(s, i+1) + BruteForce(s, i+2);
        else
            return BruteForce(s, i+1);   // We can take only 1 digit
    }
    
    public int TopDownDPHelper(String s) 
    {
        if(s == null || s.length() == 0 || s.charAt(0) =='0') 
            return 0;
        
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        
        return TopDownDP(s, dp,0);
    }
    
    private int TopDownDP(String s, int[] dp, int index)
    {
        if(index == s.length())
            return 1;
        
        if(dp[index] != -1)
            return dp[index];
        
        if(s.charAt(index) == '0') 
            dp[index] = 0;
        else if(index + 1 < s.length() && (s.charAt(index) == '1' || 
               (s.charAt(index) == '2' && s.charAt(index+1) < '7')))
            dp[index] = TopDownDP(s, dp, index + 1) + TopDownDP(s, dp, index + 2);
        else
            dp[index] = TopDownDP(s, dp, index + 1);
        
        return dp[index];
    }
    
    public int BottomUpI(String s) 
    {
           if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
               dp[i] += dp[i-1];  
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
    
    public int BottomUpII(String s) 
    {
        // If we fix the last element, then we have 2 choices
        // single digit , 2 digit
        return 1;
    }
    
    public int numDecodingsBottomUp(String s) 
    {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        // dp[chars.length] = chars[chars.length - 1] == '0' ? 0 : 1;
        dp[chars.length - 1] = chars[chars.length - 1] == '0' ? 0 : 1;
        
        for (int i = chars.length - 2; i >= 0; i--) 
        {
            char current = chars[i];
            char next = chars[i + 1];
            
            if (current >= '1' && current <= '9') {
                dp[i] = dp[i + 1];
            }
            if ((next == '1' && current >= '0' && current <= '9') ||
                    (next == '2' && current >= '0' && current <= '6')) {
                dp[i] += i >= 2 ? dp[i + 2] : 1;
            }
        }
        
        return dp[0];
    }
}