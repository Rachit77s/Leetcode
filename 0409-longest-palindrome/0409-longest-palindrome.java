class Solution {
    public int longestPalindrome(String s) {
        
        return Optimized(s);
        // return Helper(s);
    }
    
    public int Helper(String s) 
    {
        int ans = 0;
        boolean flag = false;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                Integer count = map.get(s.charAt(i));
                map.put(s.charAt(i), count + 1);
            }
            else
                map.put(s.charAt(i), 1);
        }
        
        // We need to count odd occurrences
        // For 1st time, if odd comes, increase the count as it is.
        // From 2nd time onwards, if odd comes do count - 1 as we have considered 1 odd sequence
        for (Map.Entry<Character, Integer> entry : map.entrySet()) 
        {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            
            if(value % 2 == 1)
            {
                // encountering 2nd time
                if(flag == true)
                    ans = ans + value - 1;
                else
                {
                    ans = ans + value;
                    flag = true;
                }
            }
            else
            {
                ans = ans + value;
            }      
        }
        
        return ans;
    }
    
    // Comments: https://leetcode.com/problems/longest-palindrome/discuss/89604/Simple-HashSet-solution-Java
    public int Optimized(String s) 
    {
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            if(set.contains(s.charAt(i)))
            {
                // All even no chars will be removed at the end
                set.remove(s.charAt(i));
                count++;
            }
            else
                set.add(s.charAt(i));
        }
        
        // Only odd character will remain in the set at the end
        if(!set.isEmpty())
            return count * 2 + 1; // include that 1 odd sequence

        return count * 2; // All even chars were there in the string
    }
}

// "xyxyxyzzzz"
//  xyzzxzzyx
// x:3 y:3 z: 4

// "abbbbbbaaccx"