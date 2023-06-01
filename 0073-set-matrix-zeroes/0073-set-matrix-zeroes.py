class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
#         HashSet<Pair<Integer, Integer>> set = new HashSet<>();
        
#         for(int i = 0; i < matrix.length; i++)
#         {
#             for(int j = 0; j < matrix[0].length; j++)
#             {
#                 if(matrix[i][j] == 0)
#                     set.add(new Pair<>(i,j));
#             }
#         }
        
        
#         Iterator<Pair<Integer, Integer>> iterator = set.iterator();
        
#         while (iterator.hasNext()) 
#         {
#             Pair<Integer, Integer> pair = iterator.next();
#             int row = pair.getKey();
#             int col = pair.getValue();
            
#             // Make row 0
#             for(int c = 0; c < matrix[0].length; c++)
#             {
#                 matrix[row][c] = 0;
#             }
            
#             // Make col 0, iterate row by row
#             for(int r = 0; r < matrix.length; r++)
#             {
#                 matrix[r][col] = 0;
#             }
#         }
        
        R = len(matrix)
        C = len(matrix[0])
        rows, cols = set(), set()
        
        for i in range(R):
            for j in range(C):
                if(matrix[i][j] == 0):
                    rows.add(i)
                    cols.add(j)
                    
        for i in range(R):
            for j in range(C):
                if i in rows or j in cols:
                    matrix[i][j] = 0