class Solution {
    public String defangIPaddr(String address) {
        
        
        if(address.length() <= 0)
            return address;
        
        StringBuilder str = new StringBuilder();
        
        int i = 0;
        while(i < address.length())
        {
            while(i < address.length() && address.charAt(i) != '.')
            {
                str.append(address.charAt(i));
                i++;
            }
                
            if(i < address.length() && address.charAt(i) == '.')
                str.append("[.]");
            
            i++;
        }
        
        return str.toString();
    }
}