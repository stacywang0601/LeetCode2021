public class Leet211 {
    class WordDictionary {
        class Trie {
            Trie[] children = new Trie[26];
            boolean isLeaf = false;
        }

        Trie root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new Trie();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            if (root == null) return;
            Trie node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Trie();
                }
                node = node.children[c - 'a'];
            }
            node.isLeaf = true;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return search(word.toCharArray(), 0, root);
        }

        private boolean search(char[] arr, int start, Trie node) {
            if (node == null) return false;
            if (start == arr.length) return node.isLeaf;

            char c = arr[start];
            if (c == '.') {
                for (int i = 0; i < 26; i++) {
                    if (search(arr, start + 1, node.children[i])) return true;
                }
                return false;
            }

            return search(arr, start + 1, node.children[c - 'a']);
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
