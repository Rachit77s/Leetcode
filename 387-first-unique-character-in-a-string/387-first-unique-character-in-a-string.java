class Solution {
    public int firstUniqChar(String s) {
        
        
        return BetterApproach(s);
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