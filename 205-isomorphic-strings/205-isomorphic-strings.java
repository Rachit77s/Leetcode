class Solution {
    public boolean isIsomorphic(String s, String t) {

        return Mapping(s, t);
    }
    
    public boolean WrongApproach(String s, String t)
    {
                
        // Checking that only the chars count is equal won't give us the answer
        // It will fail satisfying the ordering condition, consider edge case
        
        /*
            Replace s to make it like t
            Edge Case: Order also matters
            ex1:
            s = abaab
            t = xyxyy 
          O/P = xyxxy

            ex2
            s = "bbbaaaba"
            t = "aaabbbba"
          O/P = "aaabbbab"
        */
        
        int[] sArr = new int[26];
        int[] tArr = new int[26];
        
        for(int i = 0; i < s.length(); i++)
        {
            sArr[s.charAt(i) - 'a']++;
        }
            
        for(int i = 0; i < t.length(); i++)
        {
            tArr[t.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < s.length(); i++)
        {
            if(sArr[s.charAt(i) - 'a'] != tArr[t.charAt(i) - 'a'])
                return false;
        }
        
        return true;
        // This me thod gives wrong output
    }
    
    public boolean Mapping(String s, String t)
    {
        if (s == null || t == null) 
            return false;
        
        if (s.length() != t.length()) 
            return false;
        
        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++)
        {
          //   s = "bbbaaaba"
          //   t = "aaabbbba" 
          // O/P = "aaabbbab" Not isomorphic string
            
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            // No two characters should map to the same character
            // In foo bar,  if o is mapped to a and o is mapped to r
            if(mapST.containsKey(c1) && mapST.get(c1) != c2)
                return false;
            
            // No two characters should map to the same character
            if(mapTS.containsKey(c2) && mapTS.get(c2) != c1)
                return false;
            
            mapST.put(c1, c2);
            mapTS.put(c2, c1);
        }
        
        return true;
    }
    
    public boolean IndexMethod(String s, String t)
    {
        // https://leetcode.com/problems/isomorphic-strings/discuss/57802/Java-solution-using-HashMap
        
        if (s == null || t == null) 
            return false;
        
        if (s.length() != t.length()) 
            return false;
        
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();
        
        
        for(int i = 0; i < s.length(); i++)
        {
            int indexS = mapS.getOrDefault(s.charAt(i), -1);
            int indexT = mapT.getOrDefault(t.charAt(i), -1);
            
            if(indexS != indexT)
                return false;
            
            mapS.put(s.charAt(i), i);
            mapT.put(t.charAt(i), i);
        }
        
        return true;
    }
}


