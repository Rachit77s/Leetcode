class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        return DPApproach(s, wordDict);
        // return RecursiveHelper(s, wordDict);
        // return NeetcodeSolution(s, wordDict);
    }
    
    public boolean RecursiveHelper(String s, List<String> wordDict) 
    {
        HashSet<String> set = new HashSet<>(wordDict);
        return RecursiveApproach(s, 0, set);
    }
    
    // TC: O(2^n)
    public boolean RecursiveApproach(String s, int index, HashSet<String> set) 
    {
        if(index == s.length())
            return true;
        
        // substring(int begIndex, int endIndex)
        // beginIndex :  the begin index, inclusive.
        // endIndex :  the end index, exclusive.

        
        // For loop because we need to check for every char by including it.
        // If we don't use a loop, it will just exit after checking the first char.
        for(int i = index + 1; i <= s.length(); i++)
        {
            String subStr = s.substring(index, i);
            
            // System.out.print(subStr);
            
            if(set.contains(subStr) && RecursiveApproach(s, i, set) == true)
                return true;
        }
        
        return false;
    }
    
    // Neetcode
    public boolean NeetcodeSolution(String s, List<String> wordDict) 
    {
        
        boolean[] memo = new boolean[s.length()+1];
        memo[s.length()] = true;
        
        HashSet<String> wordSet = new HashSet<>(wordDict);
        
        for (int i=s.length()-1 ; i>=0; i--) {
            for (String word: wordSet) {
                if (i + word.length()<=s.length() && s.indexOf(word, i)==i) {
                    memo[i] = memo[i + word.length()];
                }
                
                if (memo[i]) {
                    break;
                }
            }
        }
        return memo[0];
    }
    
    public boolean DPApproach(String s, List<String> wordDict) 
    {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);

        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++)
            {
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}