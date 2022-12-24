class Solution {
    public int numTilings(int N) {
        if(N<1){
            throw new IllegalArgumentException();
        }
        if(N<3){
            return N;
        }
        int a=1;
        int b=1;
        int c=2;
        int M=1000000007;
        for(int i=3;i<=N;i++){
            int cur=(((c<<1)%M)+a)%M;
            a=b;
            b=c;
            c=cur;
        }
        return c;
    }
}