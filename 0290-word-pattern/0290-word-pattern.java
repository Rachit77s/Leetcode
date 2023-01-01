class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        return ApproachIII(pattern, s);
        // return ApproachII(pattern, s);
        // return ApproachI(pattern, s);
    }
    
    public boolean ApproachI(String pattern, String s)
    {
        HashMap<Character, String> map = new HashMap();
        HashMap<Character, Integer> charMap = new HashMap();
        HashMap<String, Integer> strMap = new HashMap();
        
        String[] str = s.split(" ");
        
        if(pattern.length() != str.length)
            return false;
        
        for(int i = 0; i < str.length; i++)
        {
            if(map.containsKey(pattern.charAt(i)))
            {
                String temp = map.get(pattern.charAt(i));
                
                if(!temp.equals(str[i]))
                    return false;
            }
            else
                map.put(pattern.charAt(i), str[i]);
        }
        
        for(int i = 0; i < str.length; i++)
        {
            if(charMap.containsKey(pattern.charAt(i)))
            {
                int cnt = charMap.get(pattern.charAt(i));
                charMap.put(pattern.charAt(i), cnt+1);
            }
            else
                charMap.put(pattern.charAt(i), 1);
            
            if(strMap.containsKey(str[i]))
            {
                int cnt2 = strMap.get(str[i]);
                strMap.put(str[i], (cnt2+1));
            }
            else
                strMap.put(str[i], 1);
        }
        
        for(int i = 0; i < str.length; i++)
        {
            int cnt1 = charMap.get(pattern.charAt(i));
            int cnt2 = strMap.get(str[i]);   
                                   
            if(cnt1 != cnt2)
                return false;
        }
        
        return true;
    }
    
    public boolean ApproachII(String pattern, String s)
    {
        if (pattern == null || pattern.isEmpty()) 
            return false;
        
        String[] words = s.split(" ");
        
        if (pattern.length() != words.length) 
            return false;

        Map<Character, String> charToWord = new HashMap<>(words.length);
        Map<String, Character> wordToChar = new HashMap<>(words.length);

        for (int i = 0; i < words.length; ++i) 
        {
            char ch = pattern.charAt(i);
            String word = words[i];
            
            if(charToWord.containsKey(ch) && !charToWord.get(ch).equals(word))
                return false;
            
            if(wordToChar.containsKey(word) && !wordToChar.get(word).equals(ch))
                return false;
            
            charToWord.put(ch, word);
            wordToChar.put(word, ch);
        }
        
        return true;
    }
    
    public boolean ApproachIII(String pattern, String str)
    {
         String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }
}