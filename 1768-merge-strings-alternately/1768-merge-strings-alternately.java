class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        int n = word1.length();
        int m = word2.length();
        
        StringBuilder sb = new StringBuilder();
        
        int i = 0;
        while(i < n || i < m)
        {
            if(i < n)
                sb.append(word1.charAt(i));
            
            if(i < m)
                sb.append(word2.charAt(i));
            
            i++;
        }
        
        return sb.toString();
    }
}