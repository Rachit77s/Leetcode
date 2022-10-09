class Solution {
    public String addStrings(String num1, String num2) {
        
        return RecursionHelper(num1, num2);
    }
    
    String ans = "";
    public String RecursionHelper(String num1, String num2) 
    {
        ans = "";
        Add(num1, num2, 0, num1.length() - 1, num2.length() - 1);
        
        return new StringBuilder(ans).reverse().toString();
    }
    
    public void Add(String num1, String num2, int carry, int i, int j) 
    {
        if(i < 0 && j < 0 && carry == 0)
        {
            return;
        }
        
        int first = 0;
        int second = 0;
        
        if (i >= 0) {
            first = num1.charAt(i) - '0';
            }
        if (j >= 0) {
            second = num2.charAt(j) - '0'; 
        }
        
        int sum = first + second + carry;
        int lastDigit = sum % 10;
        carry = sum / 10;
        
        ans += lastDigit;
        
        Add(num1, num2, carry, i-1, j-1);
    }
}