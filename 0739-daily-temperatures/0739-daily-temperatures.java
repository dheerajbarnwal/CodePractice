class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        
        int ans[] = new int[n];
        
        Stack<Integer> st = new Stack<>();
        ans[n-1]=0;
        st.push(n-1);
        
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && temp[i]>=temp[st.peek()]){
                ans[i]+=ans[st.pop()];
            }
            if(!st.isEmpty()){
                ans[i]+=1;
            }else{
                ans[i]=0;
            }
            st.push(i);
        }
        return ans;
    }
}