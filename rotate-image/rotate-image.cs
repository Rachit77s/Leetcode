public class Solution {
    public void Rotate(int[][] matrix) {
        
        //Transpose: i,j becomes j,i   Row becomes column & column becomes row
         //
        
        // Transform
	for(int i = 0; i < matrix.Length; i++)
	{
		for (int j = i; j < matrix[i].Length; j++)
		{
			int temp = matrix[i][j];
			matrix[i][j] = matrix[j][i];
			matrix[j][i] = temp;
		}
	}
	// Swap
	for(int i = 0; i < matrix.Length; i++)
	{
		int start = 0;
		int end = matrix[i].Length - 1;
		while (end > start)
		{
			int temp = matrix[i][start];
			matrix[i][start] = matrix[i][end];
			matrix[i][end] = temp;
			end--;
			start++;
		}
	}
        
    }
    
    public void Rotate(int[][] matrix, int start, int end)
    {
        // while(start<end)
        // {
        //     int temp = matrix[i][j];
        //     matrix[i][j] = 
        //     matrix
        //     start++;
        //     end--;
        // }
    }
}