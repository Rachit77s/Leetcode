class Solution {
    public void setZeroes(int[][] A) {
        
        // Alisha: https://www.youtube.com/watch?v=djt9mwch-Xo
        List < Integer > row = new ArrayList < > ();
        List < Integer > col = new ArrayList < > ();

        int n = A.length;
        int m = A[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;
        
        
        // Check if 1st row is zero
        for(int c = 0; c < m; c++)
        {
            if(A[0][c] == 0)
                firstRowZero = true;
        }
        
        // Check if 1st col is zero
        for(int r = 0; r < n; r++)
        {
            if(A[r][0] == 0)
                firstColZero = true;
        }
        
        // Iterate over the inner 3x3 matrix, and assign 
        // 0th row and 0th col as 0 if we come across a 0
        for(int i = 1; i < n; i++)
        {
            for(int j = 1; j < m; j++)
            {
                if(A[i][j] == 0)
                {
                    // Mark corresponding 0th row and 0th col as 0
                    A[0][j] = 0;
                    A[i][0] = 0;
                }
            }
        }
        
        
        // Mark entire row as 0 in the inner matrix
        for(int j = 1; j < m; j++)
        {
            // Check if the curr col is 0, then mark its subsequent rows as 0
            if(A[0][j] == 0)
            {
                for(int i = 1; i < n; i++)
                {
                    A[i][j] = 0;
                }
            }
        }
        
        // Mark entire col as 0 in the inner matrix
        for(int i = 1; i < n; i++)
        {
            // Check if the curr row is 0, then mark its subsequent col as 0
            if(A[i][0] == 0)
            {
                for(int j = 1; j < m; j++)
                {
                    A[i][j] = 0;
                }
            }
        }
        
        // Mark first row as 0
        if(firstRowZero)
        {
            for(int j = 0; j < m; j++)
            {
                A[0][j] = 0;
            }
        }
        
        // Mark first col as 0
        if(firstColZero)
        {
            for(int i = 0; i < n; i++)
            {
                A[i][0] = 0;
            }
        }
    }
}


/*
    Output
    [[0,0,0,0],[0,4,5,2],[0,3,1,5]]
    Expected
    [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

*/