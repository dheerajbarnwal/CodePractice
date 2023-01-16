class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        int flag=0;
        for(int i=0;i<n;i++){
            
            if(newInterval[0]>intervals[i][1]){
                ans.add(intervals[i]);
                continue;
            }
            if(intervals[i][0]>newInterval[1]){
                if(flag==0){
                    ans.add(newInterval);
                    flag=1;
                }
                ans.add(intervals[i]);
                continue;
            }
            if(newInterval[0]<=intervals[i][1]){
                newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
                newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
            }
            
        }
        if(flag==0)
            ans.add(newInterval);
        
        int[][] arr = new int[ans.size()][2];

        //Converting List to Array
        for(int i=0;i<ans.size();i++){
            arr[i]=ans.get(i);
        }
        return arr;
    }
}