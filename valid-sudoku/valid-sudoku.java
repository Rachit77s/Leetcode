class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                char value = board[i][j];
                
                if (value != '.')
                {
                    if(set.contains(value + " at row " + i) ||
                       set.contains(value + " at column " + j) ||
                       set.contains(value + " at block " + i/3 + "-" + j/3))
                    {
                        return false;
                    }
                    else
                    {
                        set.add(value + " at row " + i);
                        set.add(value + " at column " + j);
                        set.add(value + " at block " + i/3 + "-" + j/3);
                    }
                }
            }
        }
        
        return true;
    }
}