class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        return AnagramHelper(s, p);
    }
    
    public List<Integer> AnagramHelper(String largerString, String smallerAnagramString)
    {
        List<Integer> ans = new ArrayList<Integer>();
        
        if(smallerAnagramString.length() > largerString.length())
            return ans;

        int[] hashOfLarger = new int[26];
        int[] hashOfSmaller = new int[26];

        for (int i = 0; i < smallerAnagramString.length(); i++)
        {
            hashOfLarger[largerString.charAt(i)- 'a']++;
            hashOfSmaller[smallerAnagramString.charAt(i) - 'a']++;
        }

        // Initial Comparison: Compare the frequency of each char of the array
        if(CompareTwoHashArrays(hashOfLarger, hashOfSmaller))
        {
            ans.add(0);
        }

        // We have already compared till initial length, 
        // hence start from A.Length
        int left = 0;
        int right = smallerAnagramString.length();
        while(right < largerString.length())
        {
            // Increase the sliding window
            hashOfLarger[largerString.charAt(right) - 'a']++;
            right++;

            // Decrease the older element count i.e. 
            // window of Length of anagramString
            hashOfLarger[largerString.charAt(left) - 'a']--;
            left++;

            // Further Comparison: Compare the frequency of each element of the array
            if(CompareTwoHashArrays(hashOfLarger, hashOfSmaller))
                ans.add(left);
        }

        return ans;
    }

    public boolean CompareTwoHashArrays(int[] arrOfA, int[] arrOfB)
    {
        for(int i = 0; i < 26; i++)
        {
            if(arrOfA[i] != arrOfB[i])
                return false;
        }

        return true;
    }
    
    public List<Integer> Helper(String s, String p)
    {
        List<Integer> ans = new ArrayList<Integer>();
        
        if(p.length() > s.length())
            return ans;
        
        int[] cntS = new int[26];
        int[] cntP = new int[26];
        
        for(int i = 0; i < p.length(); i++)
        {
            cntP[p.charAt(i) - 'a']++;
            
            cntS[s.charAt(i) - 'a']++;
        }
            
        
        if(IsAnagram(cntS, cntP))
            ans.add(0);
        
        int left = 0;
        int right = p.length();
        
        while(right < s.length())
        {
            cntS[s.charAt(right) - 'a']++;
            right++;
            
            cntS[s.charAt(left) - 'a']--;
            left++;
            
            if(IsAnagram(cntS, cntP))
                ans.add(left);
        }
        
        return ans;
    }
    
    public boolean IsAnagram(int[] cntS, int[] cntP)
    {
        for(int i = 0; i < 26; i++)
        {
            if(cntS[i] != cntP[i])
                return false;
        }
        
        return true;
    }
}