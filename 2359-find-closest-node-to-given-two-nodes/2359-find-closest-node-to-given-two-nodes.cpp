class Solution {
public:
    int closestMeetingNode(vector<int>& edges, int node1, int node2) {
        unordered_set<int> st, tst;
        int ptr = max(node1, node2);
        int tptr= min(node1, node2);
        while(ptr != -1 || tptr != -1){
            if(st.find(ptr) != st.end()) ptr = -1;
            if(tst.find(tptr) != tst.end()) tptr = -1;
            st.insert(ptr);
            tst.insert(tptr);
            //important to check ptr first as smaller should be reported first in case of tie
            if(tst.find(ptr) != tst.end()) return ptr;  
            if(st.find(tptr) != st.end() ) return tptr;
            if(ptr != -1) ptr = edges[ptr];
            if(tptr != -1) tptr = edges[tptr];
        }
        return -1;
    }
};