class MyCalendarTwo:

    def __init__(self):
        self.overlaps = []
        self.calendar = []

    def book(self, start, end):
        for i, j in self.overlaps:
            if start < j and end > i:
                return False
        for i, j in self.calendar:
            if start < j and end > i:
                self.overlaps.append((max(start, i), min(end, j)))
        self.calendar.append((start, end))
        return True
    
    
        '''
            s2   e2
            s1   e1
            
               5    12 
            
        `` base   10      20
        
            10   20
                         50  60
            10       40
         5     15
         
        '''
        
# Your MyCalendarTwo object will be instantiated and called as such:
# obj = MyCalendarTwo()
# param_1 = obj.book(startTime,endTime)