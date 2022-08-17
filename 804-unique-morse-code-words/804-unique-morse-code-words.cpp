class Solution {
public:
    int uniqueMorseRepresentations(vector<string>& words) {
        string list[26] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        map<string,int> hash;
        string code = "";
        int res = 0;
        for(auto word: words) {
            code = "";
            for(char c: word) {
                code += list[c - 'a'];
            }
            if(hash[code] == 0) res++;
            hash[code]++;
        }
        return res;
    }
};