class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        return MemoizationApproach(s, wordDict);
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
    
public boolean MemoizationApproach(String s, List<String> wordDict) 
{
        // create the memoization array to save results and avoid repeat computations
        Boolean[] dp = new Boolean[s.length()];

        // convert the list into set for faster lookup
        Set<String> wordSet = new HashSet<>(wordDict);

        // recursion with memoization
        return helper(s, 0, wordSet, dp);
    }

    private boolean helper(String s, int startIdx, Set<String> wordSet, Boolean[] dp) 
    {
        // in case we've reached the end of string, return true
        if (startIdx == s.length()) 
            return true;
        
        // else if we've already computed on current substring before
        if (dp[startIdx] != null) 
            return dp[startIdx]; // auto-unboxing

        boolean res = false;
        
        // iterate through all indices after startIdx, explore every possible word
        for (int i = startIdx + 1; i <= s.length(); i++) 
        {
            String currWord = s.substring(startIdx, i);
            
            // skip if this is not a word in the input dictionary
            if (!wordSet.contains(currWord)) 
                continue;

            // recursively call upon the rest of string
            if (helper(s, i, wordSet, dp)) 
            {
                res = true;
                break;
            }
        }
        
        // add result to memo and return the result
        dp[startIdx] = res;
        
        return res;
    }

}