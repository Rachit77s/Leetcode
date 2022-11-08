class Solution {
    public String makeGood(String s) {
        
        return M2(s);
        // return M1(s);
    }
    
    public String M1(String s) 
    {
        Stack<Character> stack = new Stack();
        
        for(int i = 0; i < s.length(); i++)
        {
            // ASCII value of a is 97 and A is 65 , 97-65 = 32
            if(!stack.isEmpty() && Math.abs(stack.peek() - s.charAt(i)) == 32)
                stack.pop();
            else
                stack.push(s.charAt(i));
        }
        
        char[] ans = new char[stack.size()];
        int index = stack.size() - 1;
        
        while(!stack.isEmpty())
        {
            char ch = stack.pop();
            ans[index] = ch;
            index--;
        }
        
        return new String(ans);
    }
    
    public String M2(String s) 
    {
        Stack<Character> stack = new Stack();
        
        for(char c: s.toCharArray())
        {
            // ASCII value of a is 97 and A is 65 , 97-65 = 32
            if(!stack.isEmpty() && ((stack.peek() - 'a' == c - 'A') || (stack.peek() - 'A' == c - 'a')))
                stack.pop();
            else
                stack.push(c);
        }
        
        char[] ans = new char[stack.size()];
        int index = stack.size() - 1;
        
        while(!stack.isEmpty())
        {
            char ch = stack.pop();
            ans[index] = ch;
            index--;
        }
        
        return new String(ans);
    }
}