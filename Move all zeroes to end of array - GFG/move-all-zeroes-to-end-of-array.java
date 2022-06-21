// { Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().pushZerosToEnd(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    void pushZerosToEnd(int[] A, int n) {
        // code here
        int left = 0;
        int right = 0;
        
        // while(left < right)
        // {
        //     while(left <= n-1 && A[left] != 0)
        //         left++;
                
        //     while(right >= 0 && A[right] == 0)
        //         right--;
                
        //     if(left >= right)
        //         break;
                
        //     if(A[left] == 0 && A[right] != 0)
        //     {
        //         int temp = A[right];
        //         A[right] = A[left];
        //         A[left] = temp;
        //         left++;
        //         right--;
        //         continue;
        //     }
        // }
        
        while(right < n)
        {
            if (A[right] != 0) 
            {
                int temp = A[right];
                A[right] = A[left];
                A[left] = temp;
                left++;
            }
            
            right++;
        }
    }
}