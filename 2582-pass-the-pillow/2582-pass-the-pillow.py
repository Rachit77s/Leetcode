class Solution:
    def passThePillow(self, n, time):
        # Calculate the number of complete rounds of pillow passing
        full_rounds = time // (n - 1)

        # Calculate the remaining time after complete rounds
        extra_time = time % (n - 1)

        # Determine the position of the person holding the pillow
        # If full_rounds is even, the pillow is moving forward.
        # If full_rounds is odd, the pillow is moving backward.
        if full_rounds % 2 == 0:
            return extra_time + 1  # Position when moving forward
        else:
            return n - extra_time  # Position when moving backward