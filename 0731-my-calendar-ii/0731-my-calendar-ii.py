from sortedcontainers import SortedDict
class MyCalendarTwo:
    
    # Alisha : https://www.youtube.com/watch?v=_7B_HzJUE6E
    
    def __init__(self):
        self.events = SortedDict()
        # The maximum number of overlapped bookings allowed.
        self.maxOverlap = 2

    def book(self, start: int, end: int) -> bool:
        
        # add the current event in sorted dictionary
        self.events[start] = self.events.get(start, 0) + 1
        self.events[end] = self.events.get(end, 0) - 1
        
        currOverlap = 0

        # Calculate the prefix sum of bookings.
        for count in self.events.values():
            currOverlap += count
            
            if currOverlap > self.maxOverlap:
                # remove the added event & return false
                self.events[start] -= 1
                self.events[end] += 1
                return False
                
        
        return True
        
# Your MyCalendarTwo object will be instantiated and called as such:
# obj = MyCalendarTwo()
# param_1 = obj.book(startTime,endTime)