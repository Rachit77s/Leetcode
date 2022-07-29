class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        // Pick 0th index string and store it in a prefix array.
        // And compare this stored prefix string next strings present in the array.
        // Now compare each character of prefix string with each character of the string present in the array.
        // If at any point characters don't match then break to handle edge case.
        // Else append that character in to the prefix array.
        // Increment i and do steps 1-3 till the length of that string.
        
        String[] prefix = new String[strs.length];
        prefix[0] = strs[0];
        
        for(int i = 1; i < strs.length; i++)
        {
            prefix[i] = GetCommonPrefix(prefix[i-1], strs[i]);
        }
        
        return prefix[prefix.length - 1];
        
    }
    
    public String GetCommonPrefix(String A, String B)
    {
        int n = A.length();
        if(A.length() > B.length())
            n = B.length();
        else
            n = A.length();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++)
        {
            if(A.charAt(i) == B.charAt(i))
                sb.append(A.charAt(i));
            else
                break;  
        }
        
        // If we don't use break then for ["cir", "car"] the output would be "cr" instead of "c". 
        
        return sb.toString();
    }
}