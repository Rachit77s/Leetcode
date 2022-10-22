class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        return Helper(s, p);
    }
    
    public List<Integer> Helper(String s, String p)
    {
        List<Integer> ans = new ArrayList<Integer>();
        
        if(p.length() > s.length())
            return ans;
        
        int[] cntS = new int[26];
        int[] cntP = new int[26];
        
        for(int i = 0; i < p.length(); i++)
        {
            cntP[p.charAt(i) - 'a']++;
            
            cntS[s.charAt(i) - 'a']++;
        }
            
        
        if(IsAnagram(cntS, cntP))
            ans.add(0);
        
        int left = 0;
        int right = p.length();
        
        while(right < s.length())
        {
            cntS[s.charAt(right) - 'a']++;
            right++;
            
            cntS[s.charAt(left) - 'a']--;
            left++;
            
            if(IsAnagram(cntS, cntP))
                ans.add(left);
        }
        
        return ans;
    }
    
    public boolean IsAnagram(int[] cntS, int[] cntP)
    {
        for(int i = 0; i < 26; i++)
        {
            if(cntS[i] != cntP[i])
                return false;
        }
        
        return true;
    }
}