class Solution {
    public int firstUniqChar(String s) {
        
        return OptimizedApproach(s);
        //return BetterApproach(s);
    }
    
    public int OptimizedApproach(String A)
    {
        int[] countArr = new int[26];
        HashSet<Character> set = new HashSet<>();
        
        for(int i = 0; i < 26; i++)
            countArr[i] = -1;
        
        for(int i = 0; i < A.length(); i++)
        {
            char ch = A.charAt(i);
            
            if(set.contains(ch))
                countArr[ch - 'a'] = -1;
            else
            {
                set.add(ch);
                countArr[ch - 'a'] = i;
            }
                
        }
        
        int minIndex = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++) 
        {    
            if(countArr[i] != -1) 
                minIndex = Math.min(minIndex, countArr[i]);
        } 
        
        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }
    
    public int BetterApproach(String A)
    {
        int[] countArr = new int[26];
        
        for(int i = 0; i < A.length(); i++)
            countArr[A.charAt(i) - 'a']++;
        
        for(int i = 0; i < A.length(); i++)
            if(countArr[A.charAt(i)  - 'a'] == 1)
                return i;
        
        return -1;
    }
}