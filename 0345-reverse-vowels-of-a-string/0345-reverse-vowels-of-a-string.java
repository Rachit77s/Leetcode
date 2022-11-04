class Solution {
    public String reverseVowels(String s) {
        
        return Helper(s);
        // return LCComment(s);
    }
    
    public String Helper(String s) 
    {
        if(s == null || s.length() == 0) 
            return s;
        
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        
        while(start < end)
        {
            while(start < end && !vowels.contains(chars[start] + ""))
                start++;
         
            while(start < end && !vowels.contains(chars[end] + ""))
                end--;
            
            // SWAP   
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            
            start++;
            end--;
        }
        
        return new String(chars);
    }
    
    public String LCComment(String s) 
    {
        
        if(s == null || s.length()==0) return s;
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        while(start<end){

            while(start<end && !vowels.contains(chars[start]+"")){
                start++;
            }

            while(start<end && !vowels.contains(chars[end]+"")){
                end--;
            }

            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
        return new String(chars);
        
//         HashSet<Character> set = new HashSet<>();
//         int i = 0;
//         int j = s.length() - 1;
        
//         while(i < j)
//         {
//             if(set.contains(s.charAt(i)) && set.contains(s.charAt(j)))
//             {
//                 // SWAP
//                 char ch = s.charAt(i);
//                 s.charAt(i) = s.charAt(j);
//                 s.charAt(j) = ch;
//             }
            
//             i++;
//             j--;
//         }
        
        
//         return "";
    }
}