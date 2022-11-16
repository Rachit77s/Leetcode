class Solution {
    public int longestPalindrome(String[] words) {
        
        // return longestPalindromeComments(words);
        return Helper(words);
    }
    
    public int longestPalindromeComments(String[] words) {
        int counter[][] = new int[26][26];
        int ans = 0;
        for (String w: words) {
            int a = w.charAt(0) - 'a', b = w.charAt(1) - 'a';
            if (counter[b][a] > 0) {
                ans += 4; 
                counter[b][a]--; 
            }
            else counter[a][b]++;
        }
        for (int i = 0; i < 26; i++) {
            if (counter[i][i] > 0) {
                ans += 2;
                break;
            }
        }
        return ans;
    }
    
    // https://www.youtube.com/watch?v=jjtLUDYKa_U
    public int Helper(String[] A)
    {
        /*
            1. Create a map and store every word frequency.
            2. Iterate over the map, get the string and reverse it.
            3. Check if reverse string is in the map or not.
            4. If present, take min occurrence of string and its reversed string and 
                add it to the ans.
            5. Take special care of the edge case of aa/bb/cc/xx/yy etc.
               At the end, multiply the count with 4
               
        */
        
        int ans = 0;
        // Flag to track the odd occurrence of already a palindrome string
        boolean flag = false;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String word: A) 
        {
            if(map.containsKey(word))
                map.put(word, map.get(word) + 1);
            else
                map.put(word, 1); 
        }
        
        for(Map.Entry<String, Integer> item : map.entrySet())
        {
            String initialStr = item.getKey();
            int val = item.getValue();
            
            // Reverse string
            StringBuilder sb = new StringBuilder(initialStr);
            sb.reverse();
            String reversedString = sb.toString();
            
            if(map.containsKey(reversedString))
            {
                // Edge case of aa/bb/cc etc already palindrome
                // case 2: both character are same, e.g. aa
                // we can put it on both side
                if(initialStr.equals(reversedString))
                {
                    // aa:3   bb:3    aabbbbaa
                    // Take only even occurrence of already palindrome string
                    int count = map.get(initialStr);
                    ans = ans + count / 2;
                    
                    // Check if odd occurrence is there.
                    // We can add odd occurrence only once in the ans string.
                    // odd frequency we can use it in middle hence extra 2 length
                    if(count % 2 == 1)
                        flag = true;
                    
                     map.replace(initialStr, map.get(initialStr) - count);  
                }
                else
                {
                    // Take min of the occurrences
                    int min = Math.min(map.get(initialStr), map.get(reversedString));
                    ans = ans + min;
                    
                    // Reduce the map count
                    map.put(initialStr, map.get(initialStr) - min);
                    map.put(reversedString, map.get(reversedString) - min);
                    
                    // if(map.get(reverse)==0) map.remove(reverse);
                }
            }
        }
        
        // As pair is lcca or tyyt
        ans = ans * 4;
        
        // If already a palindrome, contribute 2 in the ans
        if(flag == true)
            ans = ans + 2;
        
        return ans;
    }
}