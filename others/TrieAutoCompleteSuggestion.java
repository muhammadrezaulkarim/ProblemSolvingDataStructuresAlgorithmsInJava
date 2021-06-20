import java.util.*;

public class TrieAutoCompleteSuggestion {

public static List<List<String>> autocompleteSuggestion(
List<String> repository, String customerQuery) {

Node root = new Node();
root.val = '-';
root.isTerminal = false;

for (String word : repository) {
insertTrie(word, root);
}

List<List<String>> res = new ArrayList<>();

// Search only the number of entered letters is greater equal to 2
for (int i = 1; i < customerQuery.length(); i++) {
String searchStr = customerQuery.substring(0, i + 1);

System.out.println("query: " + searchStr);

List<String> list = new ArrayList<String>();
bfsSearch(root, searchStr, list, false, "");

// sort the returned words alphabetically
Collections.sort(list);

List<String> newList = new ArrayList<String>();

// return only the first 3 words
for (int j = 0; j < 3; j++) {
if (j >= list.size()) {
break;
}

newList.add(list.get(j));
}

res.add(newList);

}

return res;

}

public static void bfsSearch(Node node, String query, List<String> list,
boolean flag, String prefixStr) {
// as soon as the prefix matches,
// copy all the words starting at that prefix

if (prefixStr.equals(query)) {
flag = true;
}

if (flag && node.isTerminal) {
list.add(prefixStr);
}

for (int j = 0; j < node.children.size(); j++) {
Node child = node.children.get(j);

bfsSearch(child, query, list, flag, prefixStr + child.val);

}

}

public static void insertTrie(String word, Node root) {
Node currentNode = root;

int pos = 0;
boolean found = false;

while (pos < word.length()) {
found = false;
char c = word.charAt(pos);

for (int j = 0; j < currentNode.children.size(); j++) {
if (currentNode.children.get(j).val == c) {
currentNode = currentNode.children.get(j);

found = true;
break;
}
}

if (!found) {
Node newNode = new Node();
newNode.val = c;

if (pos == word.length() - 1)
newNode.isTerminal = true;
else
newNode.isTerminal = false;

currentNode.children.add(newNode);

// make the new node current node
currentNode = newNode;

}

pos++;
}

}

static class Node {
char val;
boolean isTerminal;
ArrayList<Node> children = new ArrayList<Node>();

}

public static void main(String[] args) {
TrieAutoCompleteSuggestion ob = new TrieAutoCompleteSuggestion();

ArrayList<String> list = new ArrayList<String>();

list.add("te");
list.add("a");
list.add("ab");
list.add("test");
list.add("test2");

System.out.println(ob.autocompleteSuggestion(list, "test"));
System.out.println(ob.autocompleteSuggestion(list, "ab"));
}

}
