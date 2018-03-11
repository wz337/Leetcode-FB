//Time: O(N) N is the length of the string we are searching
//Space: O(M ^ N) -> O(26 ^ N)
//M is the total number of different letters that you have. In this case, it is 26.
//N is the depth, which is the length of the string we are searching.
class WordDictionary {    
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
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
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
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, 0, root);
    }
    
    private boolean search(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isWord;
        }
        if (word.charAt(index) == '.') { 
            for (TrieNode child : node.children) {
                //As long as there is one child node leads us to the word, then return true.
                //Remember the &&
                // if (child != null) { 
                // WRONG! If the first child gives you false, it will return false immediately. 
                //     return search(word, index + 1, child);
                // }
                if (child != null && search(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            int j = word.charAt(index) - 'a';
            return node.children[j] != null && search(word, index + 1, node.children[j]);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
