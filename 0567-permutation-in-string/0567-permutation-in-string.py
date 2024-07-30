class Solution {
    public boolean checkInclusion(String s1, String s2) {
        return Helper(s1, s2);
    }
    
    public boolean Helper(String s1, String s2)
    {
        int n = s1.length(), m = s2.length();
        
        if(n > m) 
            return false;
        
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        
        for(int i = 0; i < n; i++) {
            hash1[s1.charAt(i) - 'a']++;
            hash2[s2.charAt(i) - 'a']++;
        }
        
        if(compareHash(hash1, hash2))
            return true;
        
        
        int left = 0;
        int right = s1.length();
        
        while(right < s2.length()) {
            hash2[s2.charAt(right) - 'a']++;
            
            hash2[s2.charAt(left) - 'a']--;
            
            if(compareHash(hash1, hash2))
                return true;
            
            left++;
            right++;
        }
        
        return false;

    }
    
    public boolean compareHash(int[] hash1, int[] hash2) {
        for(int i = 0; i < 26; i++) {
            if(hash1[i] != hash2[i])
                return false;
        }
        
        return true;
    }
}