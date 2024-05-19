import java.util.HashMap;
import java.util.Map;

public class TrieLeetcode208 {

    private class TrieNode {
        private Map<Character, TrieNode> children = new HashMap<>();
        private char value;
        private boolean isTerminal;
    }

    private TrieNode root = null;

    public TrieLeetcode208() {
        root = new TrieNode();
        root.value = '-';
        root.isTerminal = false;
    }

    public void insert(String word) {
        TrieNode currentNode = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = currentNode.children.get(ch);

            if (node == null) {
                node = new TrieNode();
                node.value = ch;

                currentNode.children.put(ch, node); // make sure to add this new node
            }

            currentNode = node;
        }

        currentNode.isTerminal = true; // very important line to represent a terminal word
    }

    public boolean search(String word) {
        TrieNode currentNode = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            TrieNode node = currentNode.children.get(ch);

            if (node == null)
                return false;

            currentNode = node;
        }

        return currentNode.isTerminal;
    }

    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;

        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            TrieNode node = currentNode.children.get(ch);

            if (node == null)
                return false;

            currentNode = node;
        }

        return true;
    }

    public static void main(String[] args) {
        TrieLeetcode208 trie = new TrieLeetcode208();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // return True
        System.out.println(trie.search("app")); // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app")); // return True
    }
}
/*
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to
 * efficiently store and retrieve keys in a dataset of strings. There are
 * various applications of this data structure, such as autocomplete and
 * spellchecker.
 * 
 * Implement the Trie class:
 * 
 * Trie() Initializes the trie object.
 * void insert(String word): Inserts the string word into the trie.
 * boolean search(String word): Returns true if the string word is in the trie
 * (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix): Returns true if there is a previously
 * inserted string word that has the prefix prefix, and false otherwise.
 * 
 * 
 * Example 1:
 * 
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 * 
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple"); // return True
 * trie.search("app"); // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app"); // return True
 * 
 * 
 * Constraints:
 * 
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist only of lowercase English letters.
 * At most 3 * 104 calls in total will be made to insert, search, and
 * startsWith.
 */
