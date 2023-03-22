class Solution {
    public int findMinArrowShots(int[][] points) {
        
        return ReadableApproach(points);
    }
    
    // https://www.youtube.com/watch?v=zBCglI35CSQ
    // https://www.youtube.com/watch?v=fvBhjAp0j9c
    public int ReadableApproach(int[][] points)
    {
        // edge cases
        if(points == null || points.length == 0)
            return 0;
        
        // Edge case of infinity, hence, use compare for sorting
        // Sort the points based on the ending position
        Arrays.sort(points, (a, b)->(Integer.compare(a[1], b[1])));
        
        // Sort on basis of end point
        // If two ballons are overlapping, then we shoot them with 1 arrow,
        // and we don't update the end point i.e. ignore these 2 intervals
        // because once we have shot them, they are no more in consideration.
        // And we will look out from the next interval onwards.
        
        // Burst the first ballon
        int arrow = 1;
        int prevEnd = points[0][1];
        
        for(int i = 1; i < points.length; ++i)
        {
            int currStart = points[i][0];
            
            // There is overlapping, so ballon burst already considered.
            if(prevEnd >= currStart)
            {
                // Both intervals gets destroyed, hence, no need to update end interval
                // Ignore these destroyed intervals.
                continue;
            }
            // No overlapping
            else if(currStart > prevEnd)
            {
                arrow++;
                prevEnd = points[i][1];
            }
        }
        
        return arrow;
    }
    
    public int LCComments(int[][] points)
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