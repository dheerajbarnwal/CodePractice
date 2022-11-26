class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;
        Stack<Integer> st = new Stack<>();
        int n=arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        for(int i=0;i<n;i++){
            int temp=1;
            while(!st.isEmpty() &&arr[i]<=arr[st.peek()]){
                temp+=left[st.pop()];
            }
            left[i] = temp;
            st.push(i);
        }
        
        st.clear();
        
        
        for(int i=n-1;i>=0;i--){
            int temp=1;
            while(!st.isEmpty() &&arr[i]<arr[st.peek()]){
                temp+=right[st.pop()];
            }
            right[i] = temp;
            st.push(i);
        }
        
        int ans=0;
        
        for(int i=0;i<n;i++){
            // int temp = (((left[i]+right[i]-1)*(left[i]+right[i]))/2) - (((left[i]-1)*left[i])/2) - (((right[i]-1)*right[i])/2);
            long temp = left[i]*right[i];
            ans+= (temp*arr[i])%MOD;
            ans%=MOD;
        }
        return ans;
    }
}