class Solution {
public:
    bool dfs(string s,unordered_set<string> &us){
        for(int i=1;i<s.length();i++){
            string prf=s.substr(0,i),suf=s.substr(i);
            if(us.find(prf)!=us.end() && ((us.find(suf)!=us.end()) || dfs(suf,us))){
                return true;
            }
        }
        return false;
    }
    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        unordered_set<string> us;
        for(auto w:words) us.insert(w);
        vector<string> res;
        for(auto w:words){
            if(dfs(w,us)) res.push_back(w);
        }
        return res;
    }
};