class Solution {
    public boolean isValid(String s) {
        
        return CheckParanthesisUsingMap(s);
        // return CheckParanthesis(s);
    }
    
    public boolean CheckParanthesis(String A)
    {
        Stack<Character> stk = new Stack<>();
        
        for(int i = 0; i < A.length(); i++)
        {
            if(A.charAt(i) == '(')
                stk.push(')');
            else if(A.charAt(i) == '{')
                stk.push('}');
            else if(A.charAt(i) == '[')
                stk.push(']');
            // Below is the edge case Ex i/p: }
            else if(stk.isEmpty() || A.charAt(i) != stk.pop())
                return false;
        }
        
        if(!stk.isEmpty())
            return false;
        
        return true;
    }
    
    public boolean CheckParanthesisUsingMap(String A)
    {
        if (A.length() % 2 != 0) 
            return false;
        
        HashMap<Character, Character> map = new HashMap<>();
        
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        Stack<Character> stack = new Stack<Character>();
        
        for (int idx = 0; idx < A.length(); idx++)
        {
            Character ch = A.charAt(idx);
            
            if (ch == '(' || ch == '{' || ch == '[') 
            {
                stack.push(ch);
                continue;
            }
            else if(stack.size() == 0 || map.get(ch) != stack.pop())
                return false;
        }
        
        if(stack.size() == 0)
            return true;
        
        return false;
    }
}