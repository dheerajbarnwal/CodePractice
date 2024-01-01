class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = s.length;
        int c=g.length;
        int i=0;
        int ans=0;
        for(int j=0;j<n && i<c;){
            //System.out.println(j+" "+i);
            if(s[j]>=g[i]){
                ans++;
                j++;
                i++;
            }else{
                j++;
            }
        }
        return ans;
    }
}