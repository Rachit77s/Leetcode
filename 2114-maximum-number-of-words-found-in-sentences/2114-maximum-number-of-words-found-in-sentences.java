class Solution {
    public int mostWordsFound(String[] sentences) {
        
        int ans = 0;
        int count = 0;
        
        for (String item : sentences) 
        {
            count = 1;
            for(int i = 0; i < item.length(); i++)
            {
                if(item.charAt(i) == ' ')
                    count++;
            }
                
            ans = Math.max(ans, count);
        }
        
        
        return ans;
    }
}