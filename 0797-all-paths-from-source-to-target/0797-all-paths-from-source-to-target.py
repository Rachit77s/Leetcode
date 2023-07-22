class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        
        def dfs(currNode, path):
            if currNode == len(graph) - 1:
                ans.append(path)
            else:
                for nextNode in graph[currNode]:
                    dfs(nextNode, path + [nextNode])
            
        ans = []
        dfs(0, [0])
        return ans
            
            