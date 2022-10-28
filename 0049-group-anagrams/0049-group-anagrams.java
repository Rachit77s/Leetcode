class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        return Helper2(strs);
        // return Helper(strs);
    }
    
    public List<List<String>> Helper(String[] strs) 
    {
        /*
            To sort a string:
            String test= "edcba";
            char[] ar = test.toCharArray();
            Arrays.sort(ar);
            String sorted = String.valueOf(ar);
        */
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
            
            // Alternate
            // if (!map.containsKey(str)) {
            //     map.put(str, new ArrayList<>());
            // }
            // map.get(str).add(s1);
        }

        for (Map.Entry<String, List<String>> entry : outerMap.entrySet()) 
            ans.add(entry.getValue());

        return ans;
    }
    
    // Time Complexity: O(n * klog(k)) since we are sorting k characters n times in the loop.
    
    // Time Complexity is O(m*n) or O( sum of all chars in strs)
    public List<List<String>> Helper2(String[] strs) 
    {
        if(strs == null || strs.length == 0) 
            return Collections.emptyList();
        
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s: strs)
        {
            int[] frequencyArr = new int[128];   
            
            for(int i = 0; i < s.length(); i++)
                frequencyArr[s.charAt(i) - 'a']++;
            
            String key = Arrays.toString(frequencyArr);
            
            List<String> tempList = map.getOrDefault(key, new LinkedList<String>());
            tempList.add(s);
            map.put(key,tempList);
        }
        
        return new LinkedList<>(map.values());
    }
}