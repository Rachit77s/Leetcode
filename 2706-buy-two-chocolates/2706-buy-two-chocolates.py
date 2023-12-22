class Solution:
    def buyChoco(self, prices: List[int], money: int) -> int:
        # Number of Chocolates
        n = len(prices)

        # Array to store the frequency of prices
        freq = [0] * 101
        for p in prices:
            freq[p] += 1
        
        # Assume minimum and second minimum to be zero.
        # Since prices[i] cannot be 0, the 0 value implies
        # They haven't been computed yet.
        minimum = 0
        second_minimum = 0
        for price in range(1, 101):
            if freq[price] > 1:
                minimum = price
                second_minimum = price
                break
            elif freq[price] == 1:
                minimum = price
                break
        
        # If the second minimum is not found, then find it
        if second_minimum == 0:
            for price in range(minimum + 1, 101):
                if freq[price] > 0:
                    second_minimum = price
                    break
        
        # Minimum Cost
        min_cost = minimum + second_minimum

        # We can buy chocolates only if we have enough money
        if min_cost <= money:
            # Return the Amount of Money Left
            return money - min_cost
    
        # We cannot buy chocolates. Return the initial amount of money
        return money