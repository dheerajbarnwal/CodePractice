class Trie {
    
    class TrieNode{
        TrieNode[] child = new TrieNode[26];
        boolean isWord;
        TrieNode(){
            for(int i=0;i<26;i++){
                child[i] = null;
            }
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode crawl = root;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(crawl.child[index] == null){
                crawl.child[index] = new TrieNode();
            }
            crawl = crawl.child[index];
        }
        crawl.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode crawl = root;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(crawl.child[index]==null){
                return false;
            }
            crawl = crawl.child[index];
        }
        return crawl.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode crawl = root;
        for(int i=0;i<prefix.length();i++){
            int index = prefix.charAt(i)-'a';
            if(crawl.child[index]==null){
                return false;
            }
            crawl = crawl.child[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */