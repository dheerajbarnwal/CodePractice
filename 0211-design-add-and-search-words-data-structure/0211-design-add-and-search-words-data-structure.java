class WordDictionary {
    
    class TrieNode{
        TrieNode[] child = new TrieNode[26];
        boolean isWord;
    }
    /** Initialize your data structure here. */
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.child[c -'a']==null)
                curr.child[c-'a'] = new TrieNode();
            curr = curr.child[c-'a'];
            
        }
        curr.isWord=true;
        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word,0,root);
    }
    
    public boolean search(String word,int k, TrieNode node){
        if(k==word.length()){
            return node.isWord;
        }
        
        if(word.charAt(k)!='.'){
            return (node.child[word.charAt(k)-'a']!=null) && search(word,k+1,node.child[word.charAt(k)-'a']);
        }else{
            for(int i=0;i<26;i++){
                if(node.child[i]!=null && search(word,k+1,node.child[i])){
                    return true;
                }
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */