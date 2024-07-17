package Factset;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    TrieNode[] children;
    boolean isEOW;
    Map<Integer, Integer> countMap;

    public TrieNode() {
        children = new TrieNode[26];
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }

        this.isEOW = false;
        this.countMap = new HashMap<>();
    }

    //insert
    public void insert(TrieNode root, String word, int lineNumber) {
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int index = word.charAt(i) - 'a';
            if (root.children[index] == null) {
                root.children[index] = new TrieNode();
            }
            root = root.children[index];
        }
        root.isEOW = true;
        root.countMap.put(lineNumber, countMap.getOrDefault(lineNumber, 0) + 1);
    }

    //find
    public boolean find(TrieNode root, String word) {
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int index = word.charAt(i) - 'a';
            if (root.children[index] == null) {
                return false;
            }
            root = root.children[index];
        }
        if (root.isEOW) {
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                System.out.println("lineNumber : " + entry.getKey() + " Number of occurences : " + entry.getValue());
            }
        }
        return root.isEOW;
    }
}

public class FactSet {


    public static void main(String[] args) {

        Map<String, Map<Integer,Integer>> wordCountMapping = new HashMap<>();

    }
}
