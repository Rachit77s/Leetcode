class Solution {
    public int orangesRotting(int[][] grid) {
        
        return RottenOrangesHelper(grid);
    }
    
    class Coordinates
    {
        public int X;
        public int Y;
        
        public Coordinates(int i, int j)
        {
            this.X = i;
            this.Y = j;
        }
    }

    int[] globalRows = new int[] { -1, 0, 1,  0 };
    int[] globalCols = new int[] {  0, 1, 0, -1 };
    Queue<Coordinates> queue; 

    public int RottenOrangesHelper(int[][] A)
    {
        int minTime = 0;
        queue = new LinkedList<>();

        int[][] timeToRotten = GenerateRottenMatrix(A);

        // Keep poping nodes and processing until Queue is empty.
        // Answer should be the max number of BFS.
        // if all component have at least 1 rotten orange Otherwise -1.
        while(!queue.isEmpty())
        {
            Coordinates poppedNode = queue.remove();

             // Traverse the neighbour nodes of the popped element.
            for (int i = 0; i < 4; i++)
            {
                int nr = poppedNode.X + globalRows[i];
                int nc = poppedNode.Y + globalCols[i];

                // Things to keep in mind :
                // 1. check boundary conditions.
                // 2. Nodes should be unvisited. ( i.e. visited[i][j] == INT_MIN)
                // 3. Cell should contain an Orange
                if(nr >= 0 && nr < A.length && nc >= 0 && nc < A[0].length 
                    && A[nr][nc] == 1)
                {
                    // Get the Prev cell value of the popped cell X&Y and add + 1 time.
                    timeToRotten[nr][nc] = timeToRotten[poppedNode.X][poppedNode.Y] + 1;

                    // Update the time
                    minTime = timeToRotten[nr][nc];

                    // Make this cell with new coordinates as rotten.
                    A[nr][nc] = 2;

                    // Push the new coord. neighbour after processing the Queue.
                    queue.add(new Coordinates(nr, nc));
                }
            }
        }

        // Iterate given question input to see if there is any 1 present.
        // If 1 is present then return -1, else, return the min time.
        for (int i = 0; i < A.length; i++)
        {
            for (int j = 0; j < A[0].length; j++)
            {
                if (A[i][j] == 1)
                {
                    return -1;
                }

                //minTime = Math.Max(minTime, timeToRotten[i, j]);
            }
        }

        return minTime;
    }

    public int[][] GenerateRottenMatrix(int[][] A)
    {
        int[][] timeToRotten = new int[A.length][A[0].length];

        // Push all the rotten oranges for the BFS and create timeToRotten matrix.
        for(int i = 0; i < A.length; i++)
        {
            for(int j = 0; j < A[0].length; j++)
            {
                if(A[i][j] == 2)
                {
                    // Push all the rotten oranges for the BFS.
                    queue.add(new Coordinates(i, j));

                    // initialise the rotten oranges as 0 (0 time , as they are already rotten).
                    timeToRotten[i][j] = 0;
                }
                else
                {
                    timeToRotten[i][j] = Integer.MIN_VALUE;
                }
            }
        }

        return timeToRotten;
    }
}