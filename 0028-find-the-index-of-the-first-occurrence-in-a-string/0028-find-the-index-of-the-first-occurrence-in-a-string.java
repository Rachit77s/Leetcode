class Solution {
    public int strStr(String haystack, String needle) {
        
        return Helper(haystack, needle);     
    }
    
    public int Helper(String haystack, String needle)
    {
        if (needle.length() == 0)
            return 0;
        if (haystack.length() == 0)
            return -1;
        
        int n = haystack.length();
        int m = needle.length();
        
        String A = haystack;
        String B = needle;
        
        for(int i = 0; i < n; i++)
        {
            if(i + needle.length() > haystack.length())
                break;
            
            for(int j = 0; j < m; j++)
            {
                if(B.charAt(j) != A.charAt(i+j))
                    break;
                
                if(j == m-1)
                    return i;
            }
        }
        
        return -1;
    }
}