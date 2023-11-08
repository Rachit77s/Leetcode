class Solution:
    def isReachableAtTime(self, sx: int, sy: int, fx: int, fy: int, t: int) -> bool:
        xDistance = abs(sx - fx)
        yDistance = abs(sy - fy)
        
        # Calculate the minimum distance required to reach the target
        minDist = min(xDistance, yDistance) + abs(yDistance - xDistance)
        
        # If the minimum distance is 0, it's not possible to reach within 1 second
        if minDist == 0:
            return t != 1
        
        # Check if the given time is greater than or equal to the minimum distance
        return t >= minDist