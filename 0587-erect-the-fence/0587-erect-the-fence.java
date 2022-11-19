class Solution {
//      let p1=(x1,y1)，   p2=(x2,y2)，   p3=(x3,y3)  
//      to get vector: 
//      p12=(x2-x1,y2-y1)    
//      p23=(x3-x2,y3-y2)    
//      when cross product p12 and p23    
//      cross product = p12   x   p23   =   (x2-x1)*(y3-y2)-(y2-y1)*(x3-x2)     
//      cross product>0， p1->p2->p3   is anticlockwise，  
//      cross product<0， p1->p2->p3   is clockwise，  
//      cross product==0，p1->p2->p3   on the same line.
    public int[][] outerTrees(int[][] points) {
        int len = points.length;
        if(len <= 1) return points;
        int[] bl = points[0];
        for(int[] p : points){
            if(p[1]<bl[1] || p[1]==bl[1] && p[0]<bl[0])
                bl = p;
        }
        sort(points, bl);
        Stack<int[]> st = new Stack();
        st.push(points[0]);
        st.push(points[1]);
        for(int i=2; i<len; i++){
            int[] cur = points[i];
            int[] last = st.pop();
            while(crossProduct(st.peek(), last, cur)<0)
                last = st.pop();
            st.push(last);
            st.push(cur);
        }
        int[][] res = new int[st.size()][2];
        int idx = 0;
        while(!st.isEmpty())
            res[idx++] = st.pop();
        return res;
    }
    public void sort(int[][] points, int[] p){
        Arrays.sort(points, (a,b)->{
            int cp = crossProduct(a, p, b);
            if(cp == 0) return dist(a, p)-dist(b, p);
            return cp;
        });
        int[] q = points[points.length-1];
        int i=points.length-2;
        for(; i>=0; i--){
            if(crossProduct(points[i], p, q)!=0)
                break;
        }
		// we need to reverse the last collinear points to avoid losing anyone of them
        int l = ++i;
        int h = points.length-1;
        while(l<h){
            int[] temp = points[l];
            points[l++] = points[h];
            points[h--] = temp;
        }
    }
    public int dist(int[] a, int[] b){
        return (a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]);
    }
    public int crossProduct(int p1[], int[] p2, int[] p3){
        int[] firstVector = new int[]{p2[0]-p1[0], p2[1]-p1[1]};
        int[] secondVector = new int[]{p3[0]-p2[0], p3[1]-p2[1]};
        return firstVector[0]*secondVector[1] - firstVector[1]*secondVector[0];
    }
}