class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        row_counts = defaultdict(int)
        count = 0

        
        for row in grid:
            #print(row)
            #print(tuple(row))
            row_counts[tuple(row)] += 1
        
        # By using zip(*grid) in the code, it allows iterating over the columns of the grid rather than the rows. 
        for column in zip(*grid):
            #print(column)
            count += row_counts[column]
            
        return count