class Solution {
    public int hammingDistance(int x, int y) {
        
        int diff = x ^ y; //xor for the difference of x and y，same=0，diff=1
        return countOne(diff);
    }
    
    private int countOne(int num){
        int count = 0;
        while(num != 0){
            num = num & (num - 1);
            count++;
        }
        return count;
    }
}