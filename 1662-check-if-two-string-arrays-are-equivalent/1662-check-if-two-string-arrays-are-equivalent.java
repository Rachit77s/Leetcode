class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
     
        int[] arr = new int[26];
        
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        for (String item : word1) 
        {   
            sb1.append(item);
        }
        
        for (String item : word2) 
        {   
            sb2.append(item);
        }
        
        return sb1.compareTo(sb2) == 0;
        // return true;
    }
}