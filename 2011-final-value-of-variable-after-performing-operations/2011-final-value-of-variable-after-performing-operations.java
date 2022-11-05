class Solution {
    public int finalValueAfterOperations(String[] operations) {
        
        int ans = 0;
        
        for(int i = 0; i < operations.length; i++)
        {
            if(operations[i].contains("++"))
                ans++;
            else
                ans--;
        }
        
        return ans;
    }
}