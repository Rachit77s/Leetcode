class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        n = len(grid)
        count = 0

        for i in range(n):
            for j in range(n):
                # Compare the row (i-th row) and column (j-th column) for equality
                if grid[i] == [row[j] for row in grid]:
                    count += 1

        return count