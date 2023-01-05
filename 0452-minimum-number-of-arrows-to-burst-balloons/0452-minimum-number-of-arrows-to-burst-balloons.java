class Solution {
    public int findMinArrowShots(int[][] points) {
        //Arrays.sort(points, (a,b)->Integer.compare(a[0],b[0]));
        
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0]==b[0])
                    return Integer.compare(a[1],b[1]);
                return Integer.compare(a[0],b[0]);
            }
        });
        
        int min =points[0][1];
        int ans=1;
        for(int i=1;i<points.length;i++){
            if(points[i][0]<=min){
                min=Math.min(min,points[i][1]);
                continue;
            }else{
                min=points[i][1];
                ans++;
            }
        }
        return ans;
    }
}