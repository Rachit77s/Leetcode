class Solution {
    public int minDeletionSize(String[] strs) {
        
        int cols = strs[0].length();
        int count = 0;
        
        for(int column = 0; column < strs[0].length(); column++)
        {
            char character = strs[0].charAt(column);
            
            for(int word = 0; word < strs.length; word++)
            {
                if(strs[word].charAt(column) < character){
                    count++;
                    break;
                }
                character = strs[word].charAt(column);
            }
        }

        return count;

    }
}

// cba
// daf
// ghi