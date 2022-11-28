class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        
        return M1(matches);
    }
    
    public List<List<Integer>> BruteForce(int[][] matches) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> zeroMatch = new ArrayList<>();
        List<Integer> oneMatch = new ArrayList<>();
        
        for(int i = 0; i < matches.length; i++)
        {
            int cnt = 0;
            
            for(int j = 0; j < matches.length; j++)
            {
                if(matches[i][0] == matches[j][1])
                    cnt++;
            }
            
            if(cnt == 0)
                zeroMatch.add(matches[i][0]);
            else if(cnt == 1)
                oneMatch.add(matches[i][0]);
        }
        
        ans.add(zeroMatch);
        ans.add(oneMatch);
        
        return ans;
    }
    
    public List<List<Integer>> M1(int[][] matches) 
    {
        
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < matches.length; i++)
        {
            map.put(matches[i][0], 0);
        }
        
        for(int i = 0; i < matches.length; i++)
        {
            int key = matches[i][1];
            
            if(map.containsKey(key))
                map.put(key, map.get(key) + 1);
            else
                map.put(matches[i][1], 1);
        }
        
        List<Integer> tempList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            int mapKey = entry.getKey();
            int value = entry.getValue();
            
            if(value == 0)
                tempList.add(mapKey);
        }
        
        Collections.sort(tempList);
        
        ans.add(tempList);
        
        tempList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            int mapKey = entry.getKey();
            int value = entry.getValue();
            
            if(value == 1)
                tempList.add(mapKey);
        }
        
        Collections.sort(tempList);
        ans.add(tempList);
        
        return ans;
    }
}


// [2,3],[1,3],[5,4],[6,4]]

// [1,3] [2,3] [5,4] [6,4]

//  [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]