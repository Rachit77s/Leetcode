class Solution {
    public List<String> generateParenthesis(int n) {
        
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
}