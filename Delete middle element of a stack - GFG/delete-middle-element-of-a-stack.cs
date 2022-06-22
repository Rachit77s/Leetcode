// { Driver Code Starts
//Initial Template for C#


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DriverCode
{

    class GFG
    {
        static void Main(string[] args)
        {
            int testcases;// Taking testcase as input
            testcases = Convert.ToInt32(Console.ReadLine());
            while (testcases-- > 0)// Looping through all testcases
            {
                int N = Convert.ToInt32(Console.ReadLine());
                int[] arr = new int[N];
                string elements = Console.ReadLine().Trim();
                elements = elements + " " + "0";
                arr = Array.ConvertAll(elements.Split(), int.Parse);
                Stack<int> s = new Stack<int>();
                for(int i=0;i<N;i++){
                    s.Push(arr[i]);
                }
                new Solution().deleteMid(s, N);
                while(s.Count>0){
                    Console.Write(s.Peek()+" ");
                    s.Pop();
                }
                Console.Write("\n");
          }

        }
    }
    
}// } Driver Code Ends


//User function Template for C#



class Solution
{
    //Function to delete middle element of a stack.
    public void deleteMid(Stack<int>s,int sizeOfStack){
        // code here
        if(sizeOfStack == 0)
            return;
            
        int mid = sizeOfStack/2 + 1;
        
        DelMid(s, mid);
    } 
    
    public void DelMid(Stack<int>s,int sizeOfStack)
    {
        // code here
        if(sizeOfStack == 1)
        {
            s.Pop();
            return;
        }
        
        int temp = s.Pop();
            
        DelMid(s, sizeOfStack - 1);
        
        s.Push(temp);
        
    } 
}
