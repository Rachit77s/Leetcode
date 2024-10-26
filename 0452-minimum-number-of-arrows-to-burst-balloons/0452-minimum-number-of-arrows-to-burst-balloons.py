class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        START = -1
        END = 0
        
        '''
        Idea is to use Sweep Line algo.
        First we need to track the inProgressEvents and burstEvents.
        If any event is ongoing(START) we will keep in inProgressEvents.
        If we come at END of the event we will keep it in burstEvent.
        Also, how to know that this ballon is burst, for this we need to keep track of it
        So we need to keep track of all the events, we can use index for that.
        
        Algo:
        1. If we come across a START event, add it to the inProgressEvent set.
        2. If we come across a END event, we will first check in the burstEvent that
            if this current event is present in burst or not, if it is present we 
            dont fire any arrow and continue. 
            This is done because we should not burst a already busted event.
            [1,6] [2,8]
            Here we would have already bursted 6 & 8 nby firing arrow at 6.
            Hence we don't check we will again burst 8 which is already bursted at 6.
            
        3. Else fire the arrow and increment it, and reset inProgressEvent 
            and also add this end event to burst.
        
        '''
        
        # We need to process starting points first before ending points
        events = []
        
        for index,(lx,rx) in enumerate(points):
            events.append([lx, START, index])
            events.append([rx, END, index])
            
        events.sort()
        
        arrows = 0
        currentBalloonsInProgress = set()
        burstBalloons = set()
        
        for x, etype, b_id in events:
            if etype == END:
                if b_id in burstBalloons:
                    continue
                    
                arrows += 1
                burstBalloons |= currentBalloonsInProgress
                currentBalloonsInProgress = set()
            else:
                currentBalloonsInProgress.add(b_id)
                
        return arrows
        
        # calendar 1,2,3  
        # meeting room 1,2,3