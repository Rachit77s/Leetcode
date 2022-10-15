class Solution {
    public int longestPalindrome(String s) {
        return Helper(s);
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
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) 
        {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            
            if(value % 2 == 1)
            {
                // encountering 2nd time
                if(flag == true)
                {
                    ans = ans + value - 1;
                }
                else
                {
                    ans = ans + value;
                    flag = true;
                }
            }
            else
                ans = ans + value;
        }
        
        return ans;
    }
}

// "xyxyxyzzzz"
//  xyzzxzzyx
// x:3 y:3 z: 4

// "abbbbbbaaccx"