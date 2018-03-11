//Time: O(l)
//Space Complexity: O(n^l) when every prefix is different 
//l represents the length of the word, and n represents the different character. 26 in this case
//用空间换时间

class Trie {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        String word;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (node.children[j] == null) {
                node.children[j] = new TrieNode();
            }
            node = node.children[j];
        }
        node.isWord = true;
        node.word = word;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(word, 0, root);
    }
    
    private boolean search(String word, int index, TrieNode node) {
        if (word.length() == index) {
            return node.isWord;
        }
        int j = word.charAt(index) - 'a';
        return node.children[j] != null && search(word, index + 1, node.children[j]);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix, 0, root);
    }
    
    private boolean searchPrefix(String prefix, int index, TrieNode node) {
        if (prefix.length() == index) {
            return true;
        }
        int j = prefix.charAt(index) - 'a';
        return node.children[j] != null && searchPrefix(prefix, index + 1, node.children[j]);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
