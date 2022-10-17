class Solution {
    public boolean checkIfPangram(String sentence) {
        
        return Helper(sentence);
    }
    
    public boolean Helper(String A) 
    {
        if(A.length() <= 0)
            return false;
        
        int[] count = new int[26];
        Arrays.fill(count, 0);

        for(int i = 0; i < A.length(); i++)
        {
            count[A.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < 26; i++)
        {
            if(count[i] == 0)
                return false;
        }
        
        return true;
    }
}