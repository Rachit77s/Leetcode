class Solution {
    public String longestCommonPrefix(String[] strs) {
        
//         int minLength = Integer.MAX_VALUE;
//         String baseStr = "";
//         int baseStrIdx = -1;
//         for(int i = 0; i < strs.length; i++)
//         {
//             if(minLength > strs[i].length())
//             {
//                 minLength = strs[i].length();
//                 baseStr = strs[i];
//                 baseStrIdx = i;
//             }
//         }
 
//         String prefix = baseStr;
        
//         for(int arrayIdx = 0; arrayIdx < strs.length; arrayIdx++)
//         {
//             String tempStr = strs[arrayIdx];
            
//             if(tempStr == baseStr)
//                 continue;
            
//             String currPrefix = "";
//             for(int strIdx = 0; strIdx < minLength; strIdx++)
//             {
//                 if(tempStr.charAt(strIdx) == baseStr.charAt(strIdx))
//                 {
//                     currPrefix += baseStr.charAt(strIdx);
//                 }
//             }
            
//             if(currPrefix.length() < prefix.length())
//             {
//                 prefix = currPrefix;
//             }
//         }
        
//         // strs = ["flower","flow","flight"]
//         // Output: "fl"
        
//         return prefix;
        
        
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
        
        return sb.toString();
    }
}