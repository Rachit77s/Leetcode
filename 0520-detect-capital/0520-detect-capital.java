class Solution {
    public boolean detectCapitalUse(String word) {
        
        return ApproachI(word);
    }
    
    public boolean ApproachI(String word)
    {
        int len = word.length();
        
        if (word == null || len == 0) 
            return false;
        
        boolean hasCapital = false;
        int count = 0;
        
        // 1. check whether the word is capitalized or not.
        if (word.charAt(0)-'Z' <= 0) 
        {
            hasCapital = true;
            count++;
        }
        
        // 2. check other letters
        for (int i = 1; i < len; i++) 
        {
            if (word.charAt(i)-'Z' <= 0) 
                count++;
        }
        
        // 3. (1) no uppercase (2) Capitalize (3) All uppercases
        return count == 0 || (hasCapital && (count == 1 || count == len));
    }
    
    public boolean ApproachII(String word)
    {
        int count = 0;
        int idx = -1;
        
        for(int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);
            
            if(ch >= 'A' && ch <= 'Z')
            {
                count++;
                idx = i;
            }
        }
        
        if(count == word.length())
            return true;
        else if(count >= 1 && idx != 0)
            return false;
        
        return true;
    }
}

// FlaG

// Beebom
// YahoOoo
// MULK
// MilkMan