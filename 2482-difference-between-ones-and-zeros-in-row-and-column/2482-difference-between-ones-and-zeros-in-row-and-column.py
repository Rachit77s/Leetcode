class Solution:
    def onesMinusZeros(self, grid: List[List[int]]) -> List[List[int]]:
        row = len(grid)  # Get the number of rows in the grid
        col = len(grid[0])  # Get the number of columns in the grid

        diff = [[0] * col for _ in range(row)]  # Create a matrix to store differences

        r = [0] * row  # Create a list to store counts of ones in each row
        c = [0] * col  # Create a list to store counts of ones in each column

        # Calculate counts of ones in rows and columns
        for i in range(row):
            for j in range(col):
                r[i] += grid[i][j]  # Sum the elements in each row
                c[j] += grid[i][j]  # Sum the elements in each column

        # Calculate the difference between the count of ones and zeros in rows and columns
        for i in range(row):
            for j in range(col):
                # Calculate the difference using the formula: 2 * (count of ones in row i + count of ones in column j) - (total row count + total column count)
                diff[i][j] = 2 * (r[i] + c[j]) - row - col

        return diff  # Return the matrix containing differences