class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> st = new Stack<>();
        int n = rooms.size();
        int vis[] = new int[n];

        for (int i = 0; i < rooms.get(0).size(); i++) {
            st.push(rooms.get(0).get(i));
        }
        vis[0]=1;
        while (!st.isEmpty()) {
            int j = st.pop();

            if (vis[j] == 0) {
                for (int i = 0; i < rooms.get(j).size(); i++) {
                    st.push(rooms.get(j).get(i));
                }
            }

            vis[j] = 1;
        }
        
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                return false;
            }
        }
        
        return true;
    }
}
