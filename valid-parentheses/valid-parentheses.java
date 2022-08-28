class Solution {
    public boolean isValid(String s) {
        
        return CheckParanthesis(s);
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
}