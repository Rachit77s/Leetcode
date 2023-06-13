class Solution {
    public int equalPairs(int[][] grid) {
        
        int n = grid.length;
        int count = 0;
        
        HashMap<String, Integer> rowMap = new HashMap<>();
        HashMap<String, Integer> colMap = new HashMap<>();
        
        for(int i = 0; i < grid.length; i++)
        {
            StringBuilder sb = new StringBuilder();
            
            // Iterate row
            for(int col = 0; col < grid.length; col++)
            {
                sb.append(grid[i][col] + "_");
            }
            
            String rowString = sb.toString();
            rowMap.put(rowString, 1 + rowMap.getOrDefault(rowString, 0));
        }
        
        for(int j = 0; j < grid.length; j++)
        {
            StringBuilder sb = new StringBuilder();
            
            // Iterate row
            for(int i = 0; i < grid.length; i++)
            {
                sb.append(grid[i][j] + "_");
            }
            
            String rowString = sb.toString();
            colMap.put(rowString, 1 + colMap.getOrDefault(rowString, 0));
        }
        
        for(Map.Entry<String, Integer> item : rowMap.entrySet())
        {
            String rowHash = item.getKey();
            
            if(colMap.containsKey(rowHash))
            {
                count += rowMap.get(rowHash) * colMap.get(rowHash);
            }
        }
        
        return count;
    }
}