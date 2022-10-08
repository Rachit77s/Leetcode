class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        
        return Diagonal(mat);
    }
    
    // https://leetcode.com/problems/diagonal-traverse/discuss/97711/Java-15-lines-without-using-boolean
    public int[] Diagonal(int[][] A) 
    {
        if (A == null || A.length == 0) 
            return new int[0];

        int row = 0;
        int col = 0;
        int pos = 0; 
        int m = A.length;
        int n = A[0].length;
        int output [] = new int[m * n];
        
        for (pos = 0; pos < m * n; pos++)
        {
            output[pos] = A[row][col];
            
            // The direction is always up when the sum of row & col is even
            if ((row + col) % 2 == 0) {
                // The direction is always up when the sum of row & col is even

                // For last column, go down
                if (col == n-1) { row++; }                

                // For first row & non-last columns, go right
                else if (row == 0) { col++; }

                // For not first row & non-last columns, go up and to the right
                else { row--; col++; }

            } else {
                // The direction is always down when the sum of row & col is odd

                // For last row, go right
                if (row == m-1) { col++; } 

                //  For non-last row & first column, go down
                else if (col == 0) { row++; }

                // For non-last row & non-first column, go down and to the left
                else { row++; col--; }
            }
        }
        
        return output;
    }
}

// 00 01 02
// 10 11 12
// 20 21 22    