from typing import Dict, List
from collections import deque, defaultdict, OrderedDict, Counter
from heapq import heapify, heappush, heappop
from bisect import bisect_left, bisect_right
from functools import lru_cache
from itertools import combinations, permutations, groupby
from math import gcd
import re
import sys
inf = float('inf')
sys.setrecursionlimit(10**9)
MOD = 10**9+7


class UnionFind:
    def __init__(self, n):
        self.par = [i for i in range(n)]

    def find(self, a):
        if self.par[a] == a:
            return a
        self.par[a] = self.find(self.par[a])
        return self.par[a]

    def union(self, a, b):
        a, b = self.find(a), self.find(b)
        if a > b:
            a, b = b, a
        if a == b:
            return False
        self.par[b] = a
        return True


class Solution:
    def findCriticalAndPseudoCriticalEdges(self, n: int, edges: List[List[int]]) -> List[List[int]]:
        # save the edge id
        edges = [(u, v, w, i) for i, (u, v, w) in enumerate(edges)]
        edges.sort(key=lambda x: x[2])

        # Do not use this edge
        def find_mst_not_use_this_edge(not_use):
            unionFind = UnionFind(n)
            res = 0
            for i, (u, v, w, _) in enumerate(edges):
                # do not use this edge
                if i == not_use:
                    continue
                if unionFind.union(u, v) == True:
                    res += w

            return res if all(unionFind.find(i) == 0 for i in range(n)) else inf

        # Need to use this edge
        def find_mst_need_use_this_edge(need_use):
            # use this edge first
            unionFind = UnionFind(n)
            res = edges[need_use][2]
            unionFind.union(edges[need_use][0], edges[need_use][1])
            # And then create mst
            for i, (u, v, w, _) in enumerate(edges):
				# alread use this edge
                if i == need_use:
                    continue
                if unionFind.union(u, v) == True:
                    res += w

            return res if all(unionFind.find(i) == 0 for i in range(n)) else inf
        # Normal MST value
        base = find_mst_not_use_this_edge(-1)
        cri = []
        p_cri = []
        for i in range(len(edges)):
            v = find_mst_not_use_this_edge(i)
            # If MST value is increased, it means all MST use this edge.
            if v != base:
                cri.append(edges[i][3])
            else:
                v = find_mst_need_use_this_edge(i)
                # If MST value is not changed, it means at least one MST which use this edge exists
                if v == base:
                    p_cri.append(edges[i][3])

        return [cri, p_cri]