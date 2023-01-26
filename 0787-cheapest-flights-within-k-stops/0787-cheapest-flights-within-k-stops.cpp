class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        #define ppi pair<int, int> 
        vector<ppi> adj[n];
        for(auto v:flights)
        adj[v[0]].push_back({v[1], v[2]});
        queue<ppi> q;
        q.push({src, 0});
        vector<int> dist(n, 1e9);
        int stops=0;
        while(stops<=k && !q.empty())
        {
            int sz=q.size();
            while(sz--)
            {
                auto [u, d]=q.front();
                q.pop();
                for(auto [v, w]:adj[u])
                {
                    if(dist[v]>d+w)
                    {
                        dist[v]=d+w;
                        q.push({v, dist[v]});
                    }
                }
            }
            stops++;
        }
        if(dist[dst]==1e9)
        return -1;
        return dist[dst];
    }
};