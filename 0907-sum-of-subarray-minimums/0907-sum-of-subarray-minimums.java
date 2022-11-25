class Solution {
int mod=(int)Math.pow(10,9)+7;
    public class Pair{
        int e;
        int c;
        public Pair(int e, int c){
            this.e = e;
            this.c = c;
        }
    }
    public int sumSubarrayMins(int[] arr) {
        
        int n =arr.length;
        int[] left = getLeftMin(arr, n);
        int[] right = getRightMin(arr, n);
        long sum=0;
        for(int i=0; i<arr.length; i++){
            sum = (sum+ (long)arr[i]*left[i]*right[i])%mod;
        }
        return (int)sum;
        
    }
    
    
    public int[] getLeftMin(int[] arr, int n) {
        int[] a = new int[n];
        Stack<Pair> s = new Stack<>();
        for(int i = 0; i< n; i++){
            int count = 1;
            while(!s.isEmpty() && s.peek().e > arr[i]){
                count+=s.peek().c;
                s.pop();
            }
            s.push(new Pair(arr[i], count));
            a[i] = count;
        }
        return a;   
    }
    
    public int[] getRightMin(int[] arr, int n) {
        int[] a = new int[n];
        Stack<Pair> s = new Stack<>();
        for(int i = n-1; i>=0; i--){
            int count = 1;
            while(!s.isEmpty() && s.peek().e >= arr[i]){
                count+=s.peek().c;
                s.pop();
            }
            s.push(new Pair(arr[i], count));    
            a[i] = count;  
        }
        return a;
    }
}