class Solution:
    def numBusesToDestination(self, routes: List[List[int]], S: int, T: int) -> int:
        if S==T:
            return 0
        graph=collections.defaultdict(list)
        for i,stops in enumerate(routes):
            for s in stops:
                graph[s].append(i)
        que=graph[S]
        visited=set()
        steps=0
        while que:
            tmp=[]
            for bus in que:
                if bus in visited:
                    continue
                visited.add(bus)
                for stop in routes[bus]:
                    if stop==T:
                        return steps+1
                    for bus2 in graph[stop]:
                        if bus2 not in visited:
                            tmp.append(bus2)
            que=tmp
            steps+=1
        return -1
        