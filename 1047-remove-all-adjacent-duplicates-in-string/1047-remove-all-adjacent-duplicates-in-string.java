class Solution {
    public String removeDuplicates(String s) {
        
        return M1(s);
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
}