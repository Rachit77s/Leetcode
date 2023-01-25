class Solution {
    public List<List<String>> partition(String s) {
        
        return Helper(s);
    }
    
    public List<List<String>> Helper(String s) 
    {
        // Edge case
        if(s == null || s.length() == 0) 
            return new ArrayList<>();
        
        List<List<String>> ans = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        
        PartitionHelper(s, 0, ans, tempList);
        return ans;
    }
    
    public void PartitionHelper(String str, int index, List<List<String>> ans, List<String> tempList)
    {
        if(index == str.length())
        {
            ans.add(new ArrayList<>(tempList));
            return;
        }
        
        for(int i = index; i < str.length(); i++)
        {
            // Only do backtracking when current string is palindrome
            // If substring is Palindrome, then go for it
            if(IsPalindrome(str, index, i))
            {
                // Important go till i+1 idx since last idx is exclusive
                String subStr = str.substring(index, i + 1);
                
                tempList.add(subStr);   // choose
                PartitionHelper(str, i + 1, ans, tempList);
                
                tempList.remove(tempList.size() - 1); // unchoose
            }
        }
    }
    
    public boolean IsPalindrome(String str, int start, int end)
    {
        while(start <= end)
        {
            if(str.charAt(start++) != str.charAt(end--))
                return false;
        }
        
        return true;
    }
}