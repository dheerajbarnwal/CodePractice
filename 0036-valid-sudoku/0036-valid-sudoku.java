class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<9;i++){
            int a[] = new int[10];
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(a[board[i][j]-'0']==1){
                    return false;
                }
                a[board[i][j]-'0']=1;
            }
        }
        
        for(int i=0;i<9;i++){
            int a[] = new int[10];
            for(int j=0;j<9;j++){
                if(board[j][i]=='.'){
                    continue;
                }
                if(a[board[j][i]-'0']==1){
                    return false;
                }
                a[board[j][i]-'0']=1;
            }
        }
        
        for(int k=0;k<9;k++){
            int si = (k/3)*3;
            int sj = (k%3)*3;
            int a[] = new int[10];
            for(int i=si;i<si+3;i++){
                for(int j=sj;j<sj+3;j++){
                    //System.out.println(i + " " + j);
                    if(board[i][j]=='.'){
                        continue;
                    }
                    if(a[board[i][j]-'0']==1){
                        return false;
                    }
                    a[board[i][j]-'0']=1;
                }
            }
        }
        return true;
    }
    
}