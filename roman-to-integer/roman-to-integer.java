class Solution {
    public int romanToInt(String s) {
        
        // https://www.youtube.com/watch?v=3jdxYj3DD98
        if (s == null || s.length() == 0)
		    return -1;
        
 
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        // Largest to smallest from left to right is the normal order.
        // But if we encounter smaller value before larger value then we will subtract smaller value.
            
        int sum = 0;
        for(int i = 0; i < s.length(); i++)
        {
            // If we encounter smaller value first, then subtract this value
            if(i+1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i+1)))
                sum -= map.get(s.charAt(i));
            else
                sum += map.get(s.charAt(i));
        }
        
        return sum;
    }
}
