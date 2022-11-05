class TrieNode{
    HashMap<Character,TrieNode> child = new HashMap<>();
    String word=null;
}
class Solution {
    int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    int m,n;
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(int i=0;i<words.length;i++){
            TrieNode node = root;
            for(Character c: words[i].toCharArray()){
                if(node.child.containsKey(c)){
                     node = node.child.get(c);
                }else{
                    TrieNode newNode = new TrieNode();
                    node.child.put(c,newNode);
                    node = newNode;
                }
            }
            node.word = words[i];
        }
        m=board.length;
        n = board[0].length;
        List<String> ans = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(root.child.containsKey(board[i][j])){
                    backtrack(i,j,root,board,ans);
                }
            }
        }
        return ans;
    }
    
    void backtrack(int row, int col, TrieNode root, char[][] board, List<String> ans){
        char currChar = board[row][col];
        TrieNode currNode = root.child.get(currChar);
        if(currNode.word!=null){
            ans.add(currNode.word);
            currNode.word=null;
        }
        board[row][col]='*';
        for(int d=0;d<4;d++){
            int newRow = row+dir[d][0];
            int newCol = col + dir[d][1];
            if(newRow<0 || newRow>=m || newCol<0 || newCol>=n){
                continue;
            }
            if(currNode.child.containsKey(board[newRow][newCol])){
                backtrack(newRow,newCol,currNode,board,ans);
            }
        }
        board[row][col]=currChar;
        
    }
}