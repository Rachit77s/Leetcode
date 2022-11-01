class Solution {
    public int[] findBall(int[][] grid) {
        
        return Helper(grid);
    }
    
    // Pepcoding: https://www.youtube.com/watch?v=qCKXRsIItG8
    public int[] Helper(int[][] grid) 
    {
        int row = grid.length;
        int col = grid[0].length;
        int[] ans = new int[col];
        
        // Column iterate
        for(int j = 0; j < col; j++)
        {
            int currPos = j;
            int nextPos = -1;
            
            // row
            for(int i = 0; i < row; i++)
            {
                nextPos = currPos + grid[i][currPos];
                
                // If ball is out of bounds for left and right column
                if (nextPos < 0 || nextPos >= col || grid[i][currPos] != grid[i][nextPos])
                {
                    currPos = -1;
                    break;
                }
                    
                currPos = nextPos;
            }
            
            ans[j] = currPos;
        }
        
        return ans;
    }
}