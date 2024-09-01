class Solution:
    def construct2DArray(
        self, original: list[int], m: int, n: int
    ) -> list[list[int]]:
        # Check if it is possible to form an m x n 2D array
        if m * n != len(original):
            # If not, return an empty 2D array
            return []

        # Initialize the result 2D array with m rows and n columns
        result_array = [[0] * n for _ in range(m)]

        # Fill the 2D array with elements from the original array
        for i in range(len(original)):
            row, col = divmod(i, n)  # quotient, remainder of i / n
            result_array[row][col] = original[i]

        return result_array