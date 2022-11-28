class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        
        return M2(matches);
        // return M1(matches);
    }
    
    public List<List<Integer>> M2(int[][] matches) 
    {

        Map<Integer, Integer> losingPlayers = new HashMap<>();

        for(int[] m : matches )
        {
            losingPlayers.putIfAbsent(m[0],0);
            losingPlayers.put(m[1], losingPlayers.getOrDefault(m[1], 0) + 1);
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());

        for( Map.Entry<Integer, Integer> e: losingPlayers.entrySet() )
        {
            if( e.getValue() == 0 ){
                result.get(0).add(e.getKey());
            }else if( e.getValue() == 1 ) {
                result.get(1).add(e.getKey());                
            }
        }

        Collections.sort(result.get(0));
        Collections.sort(result.get(1));

        return result;

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