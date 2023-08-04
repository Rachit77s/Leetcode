class Solution {
    public int orangesRotting(int[][] grid) {
        
        return RottenOranges(grid);
    }
    
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;

    int[] DIRx = new int[] { -1, 0, 1,  0 };
    int[] DIRy = new int[] {  0, 1, 0, -1 };

    public int RottenOranges(int[][] A)
    {
        if(A.length == 0)
            return 0;

        int R = A.length;
        int C = A[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int ans = 0;

        // Push all the rotten oranges for the BFS i.e. Multi-source BFS
        for(int i = 0; i < R; i++)
        {
            for(int j = 0; j < C; j++)
            {
                if(A[i][j] == ROTTEN)
                    queue.add(new int[] {i, j, 0}); // r, c , time
            }
        }

        // Keep poping nodes and processing until Queue is empty.
        // Answer should be the max number of BFS.
        // if all component have at least 1 rotten orange Otherwise -1.
        while(!queue.isEmpty())
        {
            int[] curr = queue.remove();
            int r = curr[0];
            int c = curr[1];
            int timeInMinutes = curr[2];

            // We are 100% sure the last cell will give the last time to rotten
            // In BFS, we are finding the further fresh orange from the rotten orange, 
            // Hence the last level is the max time it will take.
            ans = timeInMinutes;

            // Check all valid neighbouring oranges
            // S.C.: is O(1) as we are calling for every row and col and it will only go in 4 directions
            for(int[] neighbour : GetAllValidNeighbours(A, r, c))
            {
                int nr = neighbour[0];
                int nc = neighbour[1];

                // Make this new cell with new coordinates as rotten.
                A[nr][nc] = ROTTEN;

                // Push the new coord. neighbour after processing the Queue.
                queue.add(new int[] {nr, nc, timeInMinutes + 1});
            }
        }

        // Iterate given question input to see if there is any 1 present.
        // If 1 is present then return -1, else, return the min time.
        for (int i = 0; i < R; i++)
        {
            for (int j = 0; j < C; j++)
            {
                if (A[i][j] == FRESH)
                {
                    return -1;
                }
            }
        }

        return ans;

    }

    public List<int[]> GetAllValidNeighbours(int[][] A, int currRow, int currCol)
    {
        List<int[]> neighbour = new ArrayList<>();

        for(int i = 0; i < 4; i++)
        {
            int nr = currRow + DIRx[i];
            int nc = currCol + DIRy[i];

            if(nr >= 0 && nr < A.length && nc >= 0 && nc < A[0].length 
               && A[nr][nc] == FRESH)
            {
                neighbour.add(new int[]{nr, nc});
            }
        }

        return neighbour;
    }
    
}