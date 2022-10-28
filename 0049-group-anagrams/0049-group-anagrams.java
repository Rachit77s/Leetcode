class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        return Helper(strs);
    }
    
    public List<List<String>> Helper(String[] strs) 
    {
        List<List<String>> ans = new ArrayList<>();
        
        if (strs == null || strs.length == 0)
            return ans;
        
        HashMap<String, List<String>> outerMap = new HashMap<>();
        
        for (String str : strs)
        {
            char[] arr = str.toCharArray();

            // Sort the chars, we are sorting to group the similar chars in Dictionary
            Arrays.sort(arr);
            
            // Make new string based on sorted chars
            String keyWord = new String(arr);
            
            if(outerMap.containsKey(keyWord))
                outerMap.get(keyWord).add(str);
            else
            {
                outerMap.put(keyWord, new ArrayList<>());
                outerMap.get(keyWord).add(str);
            }
        }

        for (Map.Entry<String, List<String>> entry : outerMap.entrySet()) 
            ans.add(entry.getValue());

        
        return ans;
    }
}