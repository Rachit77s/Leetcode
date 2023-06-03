class Solution:
    def numOfMinutes(self, n: int, headID: int, manager: List[int], informTime: List[int]) -> int:
        graph = defaultdict(list)
        for i in range(len(manager)):
            graph[manager[i]].append(i)
        
        def dfs(u):
            ans = 0
            for v in graph[u]:
                ans = max(dfs(v) + informTime[u], ans)
            return ans
        
        return dfs(headID)