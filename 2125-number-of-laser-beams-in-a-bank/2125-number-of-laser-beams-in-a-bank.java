class Solution {
    public int numberOfBeams(String[] bank) {
        int m=bank.length;
        int n=bank[0].length();
        int[] c= new int[m];
        
        for(int i=0;i<m;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(bank[i].charAt(j)=='1'){
                    count++;
                }
            }
            c[i]=count;
        }
        int ans=0;
        int prev=c[0];
        for(int i=1;i<m;i++){
            if(c[i]>0){
                ans+=(prev*c[i]);
                prev=c[i];
            }
        }
        return ans;
    }
}