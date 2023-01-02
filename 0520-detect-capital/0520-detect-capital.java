class Solution {
    public boolean detectCapitalUse(String word) {
        
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