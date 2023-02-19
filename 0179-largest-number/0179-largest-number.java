class Solution {
    public String largestNumber(int[] nums) {
        
        return LargestNumber(nums);
    }
    
    // Techdose: https://www.youtube.com/watch?v=qEIGhVtZ-sg
    // CodeBashers: https://www.youtube.com/watch?v=h1n-CYIyZ5k
    // TC: O(length(longestString) * NLogN)
    public String LargestNumber(int[] A)
    {
        String[] str = new String[A.length];
        
		for(int i = 0; i < A.length; i++)
		    str[i] = String.valueOf(A[i]);
        
        // We need to sort the array in desc order
        Arrays.sort(str, (a,b) -> {
            // Compare their sums
            String AB = a + b;
            String BA = b + a;
            
            // We need reverse order for desc, so BA with AB
            return BA.compareTo(AB);
            
            // Normal order 
            // return AB.compareTo(BA);
            
            // This is reverse order, we have changed sign -1 and +1
            // return AB.compareTo(BA) > 0 ? -1 :1;
            
            // AB.BA gives 30 3 34 5 9 
            // BA.AB gives 9 5 34 3 30
        });
        
        // for(String item : str)
        //     System.out.print(item + " ");
        
        // Edge case of 0
        if(str[0].equals("0"))
            return "0";
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < str.length; i++)
            sb.append(str[i]);
        
    // if(sb.charAt(0) == '0')
        //  return "0";
        
        return sb.toString();
    }
    
    // Techdose: https://www.youtube.com/watch?v=qEIGhVtZ-sg
    public String Helper(int[] A) 
    {
          
        String[] arr = new String[A.length];
        
		for(int i = 0; i < A.length; i++)
		    arr[i] = String.valueOf(A[i]);
			
		// Comparator to decide which string should come first in concatenation
// 		Comparator<String> comp = new Comparator<String>(){
// 		    @Override
// 		    public int compare(String str1, String str2){
// 		        String AB = str1 + str2;
// 				String BA = str2 + str1;
// 				return AB.compareTo(BA) > 0 ? -1 : 1;
// 		    }
// 	     };
		
// 		Arrays.sort(arr, comp);
    
//         for(String item : arr)
//             System.out.print(item + " ");
        
//         String res = "";
//         for(int i=0; i<arr.length;i++)
//              res += arr[i];

//         if(res.charAt(0) == '0')
//             return "0";

//         return res;
        
        StringBuilder stringBuilder = new StringBuilder();
        
        Arrays.sort(arr, (String a, String b) -> 
        {
            String AB=a+b;
            String BA=b+a;
            
            // We need reverse order, so BA with AB
            return BA.compareTo(AB);
            
            // Normal order 
            // return AB.compareTo(BA);
            
            // This is reverse order, we have changed sign -1 and +1
            // return AB.compareTo(BA) > 0 ? -1 :1;
            
            // AB.BA gives 30 3 34 5 9 
            // BA.AB gives 9 5 34 3 30
        });
        
        
        for(String item : arr)
            System.out.print(item + " ");

        for(int i = 0;i < arr.length; i++)
            stringBuilder.append(arr[i]);

        // Edge case
    // if(res.charAt(0) == '0')
    //       return "0";
        
        if (stringBuilder.length() == 0)
            return "0";
        
    
        return stringBuilder.toString();
    }
}