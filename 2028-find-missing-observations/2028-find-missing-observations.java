class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        
        int size = rolls.length;
        int sum = 0;

        for(int num : rolls)
            sum += num;

        int x = 0;

        int divideLength = size + n;
        int missingSum = (mean * divideLength) - sum;

        if (missingSum < n || missingSum > 6*n) 
            return new int[0];
        
        // int[] ans = new int[n];
        // int index = 0;
        // while(missingSum != 0)
        // {
        //     int tempAns = Math.min(missingSum - n + 1, 6);
        //     ans[index] = tempAns;
        //     missingSum -= tempAns;
        //     index += 1;
        //     n -= 1;
        // }

        /*
            After this we only have to distribute missingSum to n elements.
            So i used below method:-
            Assign missingSum/n to every element of new array.
            If missingSum%n is not zero then after assigning missingSum/nto every element 
            we will left with missingSum%n.So assign 1 to missingSum%n elements of new array .
        */
        
        int[] ans = new int[n];
        
        int partialSumToAssign = missingSum / n;
        int remainder = missingSum % n;
        
        Arrays.fill(ans, partialSumToAssign);
        
        for(int i = 0; i < remainder; i++)
            ans[i] += 1;

        return ans;
    }
}