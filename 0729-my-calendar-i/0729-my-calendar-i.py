class MyCalendar:

    
    '''
        Condition of No Overlapping:
        I/P:[10,15)  NewIntervalToInsert: a. [0,5)   b.[16,18)
        
        (10>=5) || (16>15)
        
             s1 e1                            s2 e2     s2 e2 
        I/P:[10,20)  NewIntervalToInsert: a. [0,5)   b.[22,25)
        
        (s1 >= e2) || (s2 >= e1)
        
        
        Overlap Condition:
        
             s1 e1                            s2 e2      s2 e2
        I/P:[10,20)  NewIntervalToInsert: a. [6,12)   b.[16,22)
        
        (e2 > s1) && (e1 > s2)
        
        
    '''
    
    def __init__(self):
        self.calendar = []
        

    def book(self, start: int, end: int) -> bool:
        for s1, e1 in self.calendar:
            if end > s1 and e1 > start:
                return False
            
        self.calendar.append((start, end))
        return True
        


# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(start,end)