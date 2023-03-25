class Solution {
    public int longestValidParentheses(String s) {
        
        return UnderstandableApproach(s);
        // return Help(s);
        // return Helper(s);
    }
    
    // https://www.scaler.com/help_requests/662642/?ref=join-call-now
    public int UnderstandableApproach(String s)
    {
        // 51:00
        // We cannot figure out which opening bracket is invalid
        // But we can always say which closing bracket will be invalid
        // So we will find the invalid index
        // We will find invalid index from the left
        // As well as from the right
        
        // Scan from the left & add the invalid index in set
        // Scan from the right & add the invalid index in set
        HashSet<Integer> invalidIndexSet = new HashSet<>();
        
        int balCount = 0;
        
        // Scan from the left for opening bracket
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            
            if(ch == '(')
                balCount += 1;
            else
            {
                // We found a valid pair
                if(balCount > 0)
                    balCount -= 1;
                else
                    // Opening with no closing bracket
                    invalidIndexSet.add(i); // Add invalid index
            }
        }
        
        balCount = 0;
        // Scan from the right for closing bracket
        for(int i = s.length() - 1; i >= 0; i--)
        {
            char ch = s.charAt(i);
            
            if(ch == ')')
                balCount += 1;
            else
            {
                // We found a valid pair
                if(balCount > 0)
                    balCount -= 1;
                else
                    // Opening with no closing bracket
                    invalidIndexSet.add(i); // Add invalid index
            }
        }
        
        
        int maxAns = 0;
        int ans = 0;
        for(int i = 0; i < s.length(); i++)
        {
            // At invalid index, set ans to 0
            if(invalidIndexSet.contains(i))
                ans = 0;
            else
                ans += 1;
            
            maxAns = Math.max(maxAns, ans);
        }
        
        return maxAns;
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