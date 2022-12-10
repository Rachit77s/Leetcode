class Solution {
    public int maxProduct(int[] nums) {
        
        /*
            Ask yourself following questions in a DP problem:

            1. What is the element of choice?
            2. Can we solve the problem using Recursion?
            3. What is the Recursion Relation?
            4. What is the Base Case?
            5. Does the problem has Overlapping Subproblems?

                a. What is the size of the DP array or what is the number of states?
                b. What does DP[i] denotes?
                c. What is the DP expression?
                d. What is the final answer state?


            7 Steps of DP:-

            1. What is the element of choice?
                Can we solve the problem using Recursion?
                What is the Recursion Relation?
                Verify if it has Optimal Substructure and Overlapping Subproblems
            2.  What is the DP state? i.e. dp[i] ?
            3.  What is the DP expression?
            4.  What does the DP table contains or it's capacity?
            5.  What is the DP code base condition?
            6.  Write the DP code
            7.  Figure out the TC and SC.
            8.  Optimization in SC

        */

        return Approach2(nums);
        // return Approach1(nums);
    }

    // https://www.youtube.com/watch?v=hJ_Uy2DzE08&ab_channel=KnowledgeCenter
    public int Approach1(int[] A)
    {
        // Element of choice is we are continuining previous index subarray or 
        // another choice is, we are starting a new subarray from current index.
        // Choice is Continue previous subarray or else start a new subarray from present index.

        // Smallest min value(-ve) multiplied by a -ve value will give the largest possible value. 
        // Since we can have -ve numbers as well, hence, we need to have a maxProd as well as minProd at every index.

        // All -ve numbers [-1, -2, -3]
        //                  -1  2   -6

        // Index              0 1  2   3
        // Array              4 2 -5   1
        // maxProdEndingHere  4 8  -5  1
        // minProdEndingHere  4 2 -40 -40


        // Index              0 1  2  3
        // Array              2 3  -2  4
        // maxProdEndingHere  2 6  -2  4
        // minProdEndingHere  2 2 -12 -48

        int ans = A[0];
        int maxProdEndingHere = A[0];
        int minProdEndingHere = A[0];

        for(int i = 1; i < A.length; i++)
        {
            // Save max prod before hand
            int temp = maxProdEndingHere;

            maxProdEndingHere = Math.max(A[i], Math.max(A[i] * maxProdEndingHere, A[i] * minProdEndingHere));

            // As max gets changed during iteration, get its previous value stored in temp.
            minProdEndingHere = Math.min(A[i], Math.min(A[i] * temp, A[i] * minProdEndingHere));

            ans = Math.max(ans, maxProdEndingHere);
        }

        return ans;
    }

    // https://www.youtube.com/watch?v=tHNsZHXnYd4&ab_channel=Yogesh%26Shailesh%28CodeLibrary%29
    public int Approach2(int[] A)
    {
        // Element of choice is we are continuining previous index subarray or 
        // another choice is, we are starting a new subarray from current index.
        // Choice is Continue previous subarray or else start a new subarray from present index.

        // Smallest min value(-ve) multiplied by a -ve value will give the largest possible value. 
        // Since we can have -ve numbers as well, hence, we need to have a maxProd as well as minProd at every index.


        int ans = A[0];
        int maxProdEndingHere = A[0];
        int minProdEndingHere = A[0];

        for(int i = 1; i < A.length; i++)
        {
            // Swap because if -ve number is multiplied with maxProd then it will decrease the maxProd, hence making it minProd.
            // And if -ve number is multiplied with minProdEndingHere it will increase the minProd, hence making it maxProd.
            if(A[i] < 0)
            {
                int temp = maxProdEndingHere;
                maxProdEndingHere = minProdEndingHere;
                minProdEndingHere = temp;
            }
                //Swap(maxProdEndingHere, minProdEndingHere);

            maxProdEndingHere = Math.max(A[i], A[i] * maxProdEndingHere);
            minProdEndingHere = Math.min(A[i], A[i] * minProdEndingHere);

            ans = Math.max(ans, maxProdEndingHere);
        }

        return ans;
    }

    private void Swap(int a, int b) {
        int temp = b;
        b = a;
        a = temp;
    }

}