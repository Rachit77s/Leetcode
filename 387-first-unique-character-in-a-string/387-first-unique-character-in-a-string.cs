public class Solution {
    public int FirstUniqChar(string s) {
        
        return FirstNonRepeatingChar(s);
    }
    
    // T.C : O(N)   S.C.: O(1)
    public int FirstNonRepeatingChar(string s) 
    {
        //Make a count array of the maximum number of characters(256).
        int noOfChars = 256;
        int[] arr = new int[256];
        int ans = int.MaxValue;
        
        // Initialize all the elements in this array to -1 or absent.
        for(int i = 0; i < noOfChars; i++)
        {
            arr[i] = -1;
        }
        
        // Update all the repeating characters to -2 and
        // Non-repeating characters contains the index where they occurred.
        for(int i = 0; i < s.Length; i++)
        {
            // I/P: "geeksforgeeks"
            // O/P: 'f'

            // str[i] -'a' ==> 103 (g) and 'a' = 97            
            if(arr[s[i] - 'a'] == -1)
            {
                arr[s[i] - 'a'] = i;
            }
            else
            {
                arr[s[i] - 'a'] = -2;
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
                ans = Math.Min(ans, arr[i]);
            }
        }
        
        // if ans remains Integer.MAX_VALUE, it means there are no characters that repeat only once or the string is empty
        if(ans == int.MaxValue)
        {
            return -1;
        }
        else
        {
            return ans;
        }
    }
}