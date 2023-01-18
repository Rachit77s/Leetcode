class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String M1Ans =  M1HelperCommonPrefix(strs);
        String M2Ans =  M2(strs);
        String M3Ans =  M3(strs);
        
        if(M1Ans.equals(M2Ans) && M2Ans.equals(M3Ans) &&
           M3Ans.equals(M1Ans))
            return M1Ans;
        
        return "";
    }
    
// Slight Modification from prefix array to prefix string
		// T.C.: O(N * M)
    public String M1HelperCommonPrefix(String[] strs) 
    {
        // Pick 0th index string and store it in a prefix array.
        // And compare this stored prefix string next strings present in the array.
        // Now compare each character of prefix string with each character of the 
        // string present in the array.
        // If at any point characters don't match then break to handle edge case.
        // Else append that character in to the prefix array.
        // Increment i and do steps 1-3 till the length of that string.

        String prefix = strs[0];

        for(int i = 1; i < strs.length; i++)
        {
            prefix = GetCommonPrefix(prefix, strs[i]);
        }
        
        return prefix;
    }

    public String GetCommonPrefix(String A, String B) 
    {
        int n = A.length();

        if(A.length() > B.length())
            n = B.length();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++)
        {
            if(A.charAt(i) != B.charAt(i))
                break;
            else
                sb.append(A.charAt(i));

            // If we don't use break then for ["cir", "car"] 
            // the output would be "cr" instead of "c". 
        }

        return sb.toString();
    }

    
    public String M2(String[] strs) 
	{
        String prefix = strs[0];

				// Iterate the entire string array starting from 2nd element
        for(int index=1; index < strs.length; index++)
				{
            while(strs[index].indexOf(prefix) != 0)
						{
								// Keep removing the last element until we have the PREFIX
                prefix = prefix.substring(0,prefix.length() - 1);
            }
        }

        return prefix;
    }
    
    public String M3(String[] strs) 
	{
        if (strs == null || strs.length == 0)
            return "";
        
        Arrays.sort(strs);

        String firstString = strs[0];
        String lastString = strs[strs.length - 1];

        // int index = 0;
				
				// i < endLength
//         while(index < firstString.length())
//         {
//             if (firstString.charAt(index) == lastString.charAt(index))
//                 index++;
//             else
//                 break;
//         }

//         return index == 0 ? "" : firstString.substring(0, index);

// 		if(index == 0)
// 				return "";

// 		return firstString.substring(0, index);
        
        StringBuilder sb = new StringBuilder();
        
        /* find the minimum length from first and last string */
        int endLength = Math.min(strs[0].length(), strs[strs.length-1].length());   
        
        for (int index = 0; index < endLength; index++) 
        {
            if (firstString.charAt(index) == lastString.charAt(index))
                sb.append(firstString.charAt(index));
             else 
                break;
        }
        
        return sb.toString();

    }
}