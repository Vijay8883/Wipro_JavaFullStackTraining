package DAY13Assignments;


/*
 * Day 13 Task 2:Trie for Prefix Checking Implement a trie data structure in C#
 * that supports insertion of strings and provides a method to check if a given
 * string is a prefix of any word in the trie.
 * 
 * A trie is an efficient information retrieval data structure that can be used
 * for prefix checking. Here’s how you can implement a trie in Java:
 * 
 */
class TrieNode {
    private TrieNode[] children;
    private boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26]; // Assuming only lowercase English letters
        isEndOfWord = false;
    }

    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }

    public void setEndOfWord() {
        isEndOfWord = true;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEndOfWord();
    }

    // Returns if there is any word in the trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char currentChar = prefix.charAt(i);
            if (!node.containsKey(currentChar)) {
                return false;
            }
            node = node.get(currentChar);
        }
        return true;
    }
}

/*
 * In this implementation:
 * 
 * TrieNode class represents each node in the trie with an array of child nodes
 * and a boolean flag to mark the end of a word. Trie class provides insert
 * method to add words to the trie and startsWith method to check if a given
 * string is a prefix of any word in the trie. You can create an instance of
 * Trie and use the insert method to add words. Then, you can use the startsWith
 * method to check if a given string is a prefix.
 */ 
