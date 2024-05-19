import java.util.*;

public class TrieAutoCompleteSuggestion {
    private class TrieNode {
        private Map<Character, TrieNode> children = new HashMap<>();
        private char value;
        private boolean isTerminal;
    }

    private TrieNode root = null;

    public TrieAutoCompleteSuggestion() {
        root = new TrieNode();
        root.value = '-';
        root.isTerminal = false;
    }

    public List<String> autocompleteSuggestion(
            List<String> repository, String prefix) {

        for (String word : repository) {
            insert(word);
        }

        List<String> suggestions = suggest(prefix);

        Collections.sort(suggestions);

        return suggestions;
    }

    public List<String> suggest(String prefix) {
        List<String> suggestionsList = new ArrayList<>();

        TrieNode currentNode = root;

        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            TrieNode node = currentNode.children.get(ch);

            if (node == null)
                return suggestionsList; // empty list

            currentNode = node;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(prefix); // important to add this line

        // traverse and return all words rooted at this specific node currentNode
        suggestionHelper(currentNode, suggestionsList, sb);

        return suggestionsList;
    }

    public void suggestionHelper(TrieNode node, List<String> list, StringBuilder sb) {
        // add only when a word is detected
        if (node.isTerminal) {
            list.add(sb.toString());
        }

        for (TrieNode child : node.children.values()) {
            sb.append(child.value); // add the character

            suggestionHelper(child, list, sb);

            sb.setLength(sb.length() - 1); // delete the character added before the call
        }

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

    public static void main(String[] args) {
        TrieAutoCompleteSuggestion ob = new TrieAutoCompleteSuggestion();

        ArrayList<String> list = new ArrayList<String>();

        list.add("hello");
        list.add("dog");
        list.add("hell");
        list.add("cat");
        list.add("a");
        list.add("hel");
        list.add("help");
        list.add("helps");
        list.add("helping");

        // System.out.println(ob.autocompleteSuggestion(list, "a"));
        System.out.println(ob.autocompleteSuggestion(list, "hel"));
    }

}

/*
 * Time Complexity: O(N*L) where N is the number of words in the trie and L is
 * the length of the longest word in the trie.
 * Auxiliary Space: O(N*L+N * ALPHABET_SIZE)
 */
