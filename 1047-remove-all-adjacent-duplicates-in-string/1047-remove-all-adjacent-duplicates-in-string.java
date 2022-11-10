class Solution {
    public String removeDuplicates(String s) {
        
        return M3(s);
        // return M2(s);
        // return M1(s);
    }
    
    public String M1(String s) 
    {
        if(s == null)
            return "";
        
        Stack<Character> stk = new Stack<>();
        boolean isRemoved = false;
        
        for(char ch : s.toCharArray())
        {
            while(!stk.isEmpty() && stk.peek() == ch)
            {
                stk.pop();
                isRemoved = true;
            }
                
            if(isRemoved == false)            
                stk.push(ch);
            
            isRemoved = false;
        }
        
        char[] ch = new char[stk.size()];
        int index = stk.size() - 1;
        while(!stk.isEmpty())
        {
            char c = stk.pop();
            
            ch[index] = c;
            index--;
        }
        
        return new String(ch);
    }
    
    public String M2(String S)
    {
        Stack<Character> stack = new Stack<>();
        for(char s : S.toCharArray())
        {
            if(!stack.isEmpty() && stack.peek() == s)
                stack.pop();
            else
                stack.push(s);
        }
        
        StringBuilder sb = new StringBuilder();
        for(char s : stack) 
            sb.append(s);
        
        return sb.toString();
    }
    
    public String M3(String s) 
    {
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) 
        {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) 
            {
                sb.deleteCharAt(sb.length() - 1);
            } 
            else 
            {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}