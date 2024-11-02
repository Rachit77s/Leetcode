class MyCalendarTwo:

    def __init__(self):
        self.nonoverlapping = []
        self.overlapping = [] # contains 2 overlapped events

    def book(self, startTime: int, endTime: int) -> bool:
        
        # check for triple booking as overlapping already has 2 overlapping
        for s, e in self.overlapping:
            if endTime > s and e > startTime:
                return False
        
        for s, e in self.nonoverlapping:
            if endTime > s and e > startTime:
                self.overlapping.append((max(s,startTime), min(e,endTime)))
                
        self.nonoverlapping.append((startTime, endTime))
        return True
                
                
# Your MyCalendarTwo object will be instantiated and called as such:
# obj = MyCalendarTwo()
# param_1 = obj.book(startTime,endTime)