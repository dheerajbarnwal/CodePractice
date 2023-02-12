class Solution {
    int s = 0;
    Map<Integer,List<Integer>> adjList;
    long ans = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length;
        s = seats;
        adjList = new HashMap<>();
        
        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            if(!adjList.containsKey(u)){
                adjList.put(u,new ArrayList<Integer>());
            }
            if(!adjList.containsKey(v)){
                adjList.put(v,new ArrayList<Integer>());
            }
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        find(0, -1);
        return ans;
    }

    int find(int node, int par) {
        int curr = 1;
        if(!adjList.containsKey(node)){
            return curr;
        }
        for (int adj : adjList.get(node)) {
            if (adj != par) {
                curr += find(adj, node);
            }
        }
        if (node != 0) {
            ans += Math.ceil((double)curr / s);
        }
        return curr;
    }
}
