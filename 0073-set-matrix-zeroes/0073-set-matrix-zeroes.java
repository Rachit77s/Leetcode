class Solution {
    public void setZeroes(int[][] A) {
        
        List < Integer > row = new ArrayList < > ();
        List < Integer > col = new ArrayList < > ();

        int n = A.length;
        int m = A[0].length;
        
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) 
          {
            if (A[i][j] == 0) {
              row.add(i);
              col.add(j);
            }
          }
        }

        for (int r = 0; r < row.size(); r++) {
          int rowIdx = row.get(r);

          // Iterate whole column
          for (int c = 0; c < m; c++)
            A[rowIdx][c] = 0;
        }

        for (int c = 0; c < col.size(); c++) {
          int colIdx = col.get(c);

          // Iterate whole row
          for (int r = 0; r < n; r++)
            A[r][colIdx] = 0;
        }

        // return A;
        
    }
}


/*
    Output
    [[0,0,0,0],[0,4,5,2],[0,3,1,5]]
    Expected
    [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

*/