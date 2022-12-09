class Solution {
    public int longestValidParentheses(String s) {
        
        return Helper(s);
    }
    
    public int Helper(String A)
    {
        int ans = 0;
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        
        for(int i = 0; i < A.length(); i++)
        {
            char ch = A.charAt(i);

            if(ch == '(')
                stk.push(i);
            else
            {
                stk.pop();
                
                if(stk.isEmpty())
                    stk.push(i);
                else
                {
                    int length = i - stk.peek();
                    ans = Math.max(ans, length);
                }
            }
        }

        return ans;
    }

}