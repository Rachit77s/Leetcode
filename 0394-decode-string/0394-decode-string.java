class Solution {
    public String decodeString(String s) {
        
        return Helper(s);
    }
    
    public String Helper(String s)
    {
        // Keep track of counts
        Stack<Integer> countsStk = new Stack<>();
        Stack<String> resultStk = new Stack<>();
        
        String ans = "";
        int index = 0;
        
        while(index < s.length())
        {
            char ch = s.charAt(index);
            
            if(ch >= '0' && ch <= '9')
            {
                // Number can be large like 3650[ab]
                int count = 0;
                
                while(Character.isDigit(s.charAt(index)))
                {
                    count = count * 10 + s.charAt(index) - '0';
                    index += 1;
                }
                    
                countsStk.push(count);
            }
            else if(ch == '[')
            {
                resultStk.push(ans);
                ans = "";
                index += 1;
            }
            else if(ch == ']')
            {
                StringBuilder sb = new StringBuilder(resultStk.pop());
                int cnt = countsStk.pop();
                
                for(int i = 0; i < cnt; i++)
                    sb.append(ans);
                
                ans = sb.toString();
                index += 1;
            }
            else
            {
                // Add onto the string 
                ans += ch;
                index += 1;
            }   
        }
        
        return ans;
    }
    
}
