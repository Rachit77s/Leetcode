public class Solution {
    public bool IsPalindrome(int x) {
        
        string str = x.ToString();
        return IsStringPalindrome(str, 0, str.Length - 1);
    }
    
    public bool IsStringPalindrome(string str, int start, int end)
    {
        if(start >= end)
            return true;
        
        return (str[start] == str[end]) && IsStringPalindrome(str, start+1, end-1);
    }
}