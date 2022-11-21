class Solution {
    
    public int nearestExit(char[][] maze, int[] entrance) {
        int dirs[][] = {{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(entrance);
        int m = maze.length;
        int n=maze[0].length;
        
        int ans=0;
        maze[entrance[0]][entrance[1]]='+';
        while(!q.isEmpty()){
            int size = q.size();
            ans++;
            for(int i=0;i<size;i++){
                int[] cell = q.poll();
                
                for(int j=0;j<4;j++){
                    int newx = cell[0]+dirs[j][0];
                    int newy = cell[1]+dirs[j][1];
                    if(newx<0 || newx>=m || newy<0 || newy>=n){
                        continue;
                    }
                    if(maze[newx][newy]=='+'){
                        continue;
                    }
                    if(newx==0 || newx==m-1 || newy==0 || newy==n-1){
                        return ans;
                    }
                    if(maze[newx][newy]=='.'){
                        maze[newx][newy]='+';
                        q.add(new int[]{newx,newy});
                    }
                }
            }
        }
        return -1;
    }
}