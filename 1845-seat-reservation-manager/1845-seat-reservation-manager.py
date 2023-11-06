from sortedcontainers import SortedSet

class SeatManager:
    def __init__(self, n):
        # Set marker to the first unreserved seat.
        self.marker = 1

        # Sorted set to store all unreserved seats.
        self.available_seats = SortedSet()

    def reserve(self):
        # If the sorted set has any element in it, then,
        # get the smallest-numbered unreserved seat from it.
        if self.available_seats:
            seat_number = self.available_seats.pop(0)
            return seat_number

        # Otherwise, the marker points to the smallest-numbered seat.
        seat_number = self.marker
        self.marker += 1
        return seat_number
        

    def unreserve(self, seat_number):
        # Push the unreserved seat in the sorted set.
        self.available_seats.add(seat_number)
        


# Your SeatManager object will be instantiated and called as such:
# obj = SeatManager(n)
# param_1 = obj.reserve()
# obj.unreserve(seatNumber)