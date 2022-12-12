class Solution {
    public int climbStairs(int n) {
        int f =1;
        int s =1;
        int temp=0;
        for(int i=2;i<=n;i++){
            temp=f;
            f=s;
            s=temp+s;
        }
        return s;
    }
}