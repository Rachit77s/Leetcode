class Solution {
    
    int emptyZeroCount = 1;
    int ans = 0;
    
    public int uniquePathsIII(int[][] grid) {
        
        return ApproachI(grid);
    }
    
    public int ApproachI(int[][] A)
    {
        int start_x = 0;
        int start_y = 0;
        int zero = 0; // Count the 0's
        
        for (int i = 0; i < A.length; i++) 
        {
            for (int j = 0; j < A[i].length; j++)
            {
                if(A[i][j] == 1)
                {
                    start_x = i;
                    start_y = j;
                }
                else if(A[i][j] == 0)
                    emptyZeroCount++;
            }
        }
        
        int countZero = 0;
        DFS(A, start_x, start_y, countZero);
        
        return ans;
    }
    
    public void DFS(int[][] A, int x, int y, int count)
    {
        if (x < 0 || x >= A.length || y < 0 || y >= A[0].length || A[x][y] == -1) 
            return;
        
        if(A[x][y] == 2)
        {
            if(emptyZeroCount == count)
                ans++;
            
            return;    
        }
        
        A[x][y] = -1;
        
        DFS(A, x-1, y, count+1);
        DFS(A, x, y+1, count+1);
        DFS(A, x+1, y, count+1);
        DFS(A, x, y-1, count+1);
        
        A[x][y] = 0;
    }
}