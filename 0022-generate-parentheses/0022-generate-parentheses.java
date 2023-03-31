class Solution {
    public List<String> generateParenthesis(int n) {
        
        return Approach2(n);
    }
    
    public List<String> Approach1(int n) 
    {
        List<String> ans = new ArrayList<String>();
        
        int open = n;
        int close = n;
        String str = "";
        
        BackTrack(ans, "", open, close);
        
        return ans;
    }
    
    public static void BackTrack(List<String> ans, String str, int open, int close)
    {
        if(open == 0 && close == 0)
        {
            ans.add(str);
            return;
        }
        
        // We always have opening choice, once we added the open, decrement its count
        if(open != 0)
        {
            BackTrack(ans, str +"(", open - 1, close);
        }
        
        // Closing bracket only occurs when close is > open 
        if(close > open)
        {
            BackTrack(ans, str + ")", open, close - 1);
        }
    }
    
    public List<String> Approach2(int n) 
    {
        List<String> ans = new ArrayList<String>();
        
        int open = 0;
        int close = 0;
        String str = "";
        
        BackTrack2(ans, "", open, close, n);
        
        return ans;
    }
    
    public static void BackTrack2(List<String> ans, String str, int open, int close, int n)
    {
        if(open == n && close == n)
        {
            ans.add(str);
            return;
        }
        
        if(open < n)
        {
            BackTrack2(ans, str +"(", open + 1, close, n);
        }
        
        // Closing bracket only occurs when open is > close 
        if(close < open)
        {
            BackTrack2(ans, str + ")", open, close + 1, n);
        }
    }
}