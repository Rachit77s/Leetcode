class Solution {
    public int firstUniqChar(String s) {
        
        return OptimizedApproach(s);
        //return BetterApproach(s);
    }
    
    public int OptimizedApproach(String A)
    {
        int[] countArr = new int[26];
        HashSet<Character> set = new HashSet<>();
        
        for(int i = 0; i < 26; i++)
            countArr[i] = -1;
        
        for(int i = 0; i < A.length(); i++)
        {
            char ch = A.charAt(i);
            
            if(set.contains(ch))
                countArr[ch - 'a'] = -1;
            else
            {
                set.add(ch);
                countArr[ch - 'a'] = i;
            }
                
        }
        
        int minIndex = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++) 
        {    
            if(countArr[i] != -1) 
                minIndex = Math.min(minIndex, countArr[i]);
        } 
        
        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
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
    
        // T.C : O(N)   S.C.: O(1)
    public int BetterApproachGFG(String s) 
    {
        //Make a count array of the maximum number of characters(256).
        int noOfChars = 256;
        int[] arr = new int[256];
        int ans = Integer.MAX_VALUE;
        
        // Initialize all the elements in this array to -1 or absent.
        for(int i = 0; i < noOfChars; i++)
        {
            arr[i] = -1;
        }
        
        // Update all the repeating characters to -2 and
        // Non-repeating characters contains the index where they occurred.
        for(int i = 0; i < s.length(); i++)
        {
            // I/P: "geeksforgeeks"
            // O/P: 'f'

            // str[i] -'a' ==> 103 (g) and 'a' = 97            
            if(arr[s.charAt(i) - 'a'] == -1)
            {
                arr[s.charAt(i) - 'a'] = i;
            }
            else
            {
                arr[s.charAt(i) - 'a'] = -2;
            }
        }

            // In the end all the repeating characters will be changed to -2 and all non-repeating characters will contain the index where they occur.
            // Now we can just loop through all the non-repeating characters and find the minimum index or the first index.
    
        for(int i = 0; i < noOfChars; i++)
        {
            // If this character is not -1 or -2 then it means that this character occurred only once
            // So find the min index of all characters that occur only once, that's our first index
            if(arr[i] >= 0)
            {
                ans = Math.min(ans, arr[i]);
            }
        }
        
        // if ans remains Integer.MAX_VALUE, it means there are no characters that repeat only once or the string is empty
        if(ans == Integer.MAX_VALUE)
        {
            return -1;
        }
        else
        {
            return ans;
        }
    }
}