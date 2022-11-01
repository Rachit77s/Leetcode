class Solution {
    public int[] findBall(int[][] grid) {
        
        return Helper1(grid);
    }
    
    // https://www.youtube.com/watch?v=Kyg-Rs37dTE
    // Comments: https://leetcode.com/problems/where-will-the-ball-fall/discuss/988576/JavaC%2B%2BPython-Solution-with-Explanation
    public int[] Helper1(int[][] grid)
    {
        if (grid == null || grid.length == 0) 
            return new int[0];
        
        int[] ans = new int[grid[0].length];
        
        // Each loop computes the result for when be drop a ball in column i.
        for (int i = 0; i < grid[0].length; ++i) 
        {
            int currRow = 0;
            int currCol = i;
            
            while(currRow < grid.length)
            {
                // Move to right
                // We go to the right if the current value and the value to the right are both equal to 1.
                if(grid[currRow][currCol] == 1 && currCol + 1 < grid[0].length && 
                   grid[currRow][currCol + 1] == 1)
                {
                    currRow++;
                    currCol++;
                }
                // We go to the left if the current value and the value to the left are both equal to -1.
                else if(grid[currRow][currCol] == -1 && currCol - 1 >= 0 && 
                   grid[currRow][currCol - 1] == -1)
                {
                    currRow++;
                    currCol--;
                }
                // If we can't move to the left, and we can't move to the right, then the ball is stuck because there is no other way to move.
                else
                    break;
            }
            
            // Store -1 if the ball got stuck.
            ans[i] = currRow == grid.length ? currCol : -1;   
        }
        
        return ans;
    }
    
    // Pepcoding: https://www.youtube.com/watch?v=qCKXRsIItG8
    public int[] Helper2(int[][] grid) 
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