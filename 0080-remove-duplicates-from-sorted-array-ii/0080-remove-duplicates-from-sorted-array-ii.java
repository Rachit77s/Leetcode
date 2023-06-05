class Solution {
    public int removeDuplicates(int[] A) {
        int i = 2;
        for (int j = 2; j < A.length; j++)
            if (A[j] != A[i-2])
                A[i++] = A[j];
        return i;
    }
}