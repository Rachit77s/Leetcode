class Solution {
    public int findMinArrowShots(int[][] points) {
        return Helper(points);
    }
    
    public int Helper(int[][] points)
    {
//         Arrays.sort(points, (a,b) -> {
//            return a[0] - b[0]; 
//         });
        
//         // for(int i = 0; i < points.length; i++)
//         // {
//         //     System.out.print(points[i][0] + "-" + points[i][1] +" ");
//         // }
        
//         int merge = 0;
//         for(int i = 1; i < points.length; i++)
//         {
//             int prevEnd = points[i-1][1];
//             int nextStart = points[i][0];
            
//             if(prevEnd == nextStart)
//             {
//                 merge++;
//                 // i++;
//             }
//             else if(prevEnd > nextStart)
//             {
//                 merge++;
//                 i++;
//             }
//             else
//                 merge++;
//         }
        
//         return merge;
        
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] l, int[] r) {
                return l[1] < r[1] ? -1 : 1;
            }
        });
        int res = 1;
        var min_right_side = points[0][1];
        var len = points.length;
        for (int i = 1; i < len; ++i) {
            if (points[i][0] > min_right_side) {
                ++res;
                min_right_side = points[i][1];
            }
        }
        return res;
    }
}