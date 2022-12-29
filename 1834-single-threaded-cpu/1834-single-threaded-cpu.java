class Solution {
    public int[] getOrder(int[][] tasks) {
        
        return ApproachI(tasks);
    }
    
    // https://leetcode.com/problems/single-threaded-cpu/discuss/1164102/Java%3A-sort-by-time-and-use-PQ
    // https://leetcode.com/problems/single-threaded-cpu/discuss/1164703/JAVA-oror-MIN-HEAP-oror-Sorting-oror-Readable-Code
    public int[] ApproachI(int[][] tasks) 
    {
        // 1. Sort by start time but preserve the original index.
        // 2. Use a minHeap and Push all tasks whose start time is ≤ the current time into heap h. 
        // 3. Iterate each task, and we increase the ans time, and if the 
        // curr task starting time is smaller or equal to cur, we add into the pq
        // 4. Check if pq is empty, if yes, we update current time by ith task starting time
        // 5. If pq is not empty, we update the result
        // 6. clean the minHeap
        // 7. return result
        
        
        // Contains all the tasks, start time, end time and the index
        int[][] arr = new int[tasks.length][3]; 
        
        for(int i = 0; i < tasks.length; i++)
            arr[i] = new int[]{tasks[i][0], tasks[i][1], i};
        
        // Sort arr by start time
        Arrays.sort(arr, (a, b) -> {
            if(a[0] != b[0]) 
                return a[0]-b[0];
            else 
                return a[1] - b[1];//least duration come first
        });
        
        // Create heap by pq and sort by duration and start time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
           if(a[1] != b[1])
               return a[1] - b[1];
            else
                return a[2] - b[2];//least start time come first
        });
        
        int[] ans = new int[tasks.length];
        int ansIndex = 0; // for maintaining ans index
        int time = 0;
        
        //There are 2 situations:
        //1:no task can be executed E.g. t = 0, [1,2], queue={}, then t = next start time
        //2:there are task start time <= t, add task into queue, then 
        // Pick the task with least duration and update t = t + duration
        int i = 0;
        while(i < arr.length)
        {
            //add task into heap
            while(i < arr.length && time >= arr[i][0])
            {
                pq.add(arr[i]);
                i++;
            }
                
    //Situation 1: no task can be executed at time t, update time t = next task's start time
            if(pq.isEmpty())
                time = arr[i][0];
            
            //Situation 2:pick task, execute task and update t = t + duration
            if(!pq.isEmpty())
            {
                int[] curr = pq.poll();
                ans[ansIndex] = curr[2]; // add index(arr[2]) to ans
                ansIndex++;
                time += curr[1];
            }
        }
        
        //Finsh the rest of task in queue
        while(!pq.isEmpty())
        {
            int[] curr = pq.poll();
            ans[ansIndex] = curr[2];
            ansIndex++;
        }
        return ans;
    }
}