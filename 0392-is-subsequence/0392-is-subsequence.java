class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int j = 0;
        int i = 0;
        int cnt = 0;
        
        if (s.length() > t.length()) 
            return false;
        
        if (s.length() == 0) 
            return true;
        
        while(i < s.length() && j < t.length())
        {
            if(s.charAt(i) == t.charAt(j))
            {
                i++;
                cnt++;
            }
              
            j++;    
        }
        
        if(cnt != s.length())
            return false;
        
        return true;
    }
}

// "ahbgdc"
// abc