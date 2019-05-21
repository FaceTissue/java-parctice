package dataStructure;

import org.junit.Test;

public class LongestCommonPrefix {
    // 水平扫描法
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    // 单个字符水平扫描
    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 0; i < prefix.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != prefix.charAt(i)) {
                    return prefix.substring(0, i);
                }
            }
        }
        return prefix;
    }

    // 分治法
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) return strs[l];
        else {
            int mid = (l + r) / 2;
            String leftCommonPrefix = longestCommonPrefix(strs, l, mid);
            String rightCommonPrefix = longestCommonPrefix(strs, mid + 1, r);
            return commonPrefix(leftCommonPrefix, rightCommonPrefix);
        }
    }

    private String commonPrefix(String l, String r) {
        int n = Math.min(l.length(), r.length());
        for (int i = 0; i < n; i++) {
            if (l.charAt(i) != r.charAt(i)) {
                return l.substring(0, i);
            }
        }
        return l.substring(0, n);
    }

    // 二分查找法
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) minLen = Math.min(minLen, str.length());
        int iMin = 1, iMax = minLen;
        while (iMin <= iMax) {
            int mid = (iMax + iMin) / 2;
            if (isCommonPrefix(strs, mid)) iMin = mid + 1;
            else iMax = mid - 1;
        }
        return strs[0].substring(0, iMin);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for (String str : strs) {
            if (!str.startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }

    // 字典树Trie
    public String longestCommonPrefix4(String q, String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        Trie tire = new Trie();
        for (String str : strs) tire.insert(str);
        return tire.searchLongestPrefix(q);
    }

    class TrieNode {
        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd;

        private int size;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
            size++;
        }

        public int getLinks() {
            return size;
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char curr = word.charAt(i);
                if (!node.containsKey(curr)) {
                    node.put(curr, new TrieNode());
                }
                node = node.get(curr);
            }
            node.setEnd();
        }

        private TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char curr = word.charAt(i);
                if (node.containsKey(curr)) {
                    node = node.get(curr);
                } else {
                    return null;
                }
            }
            return node;
        }

        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        private String searchLongestPrefix(String word) {
            TrieNode node = root;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char curr = word.charAt(i);
                if (node.containsKey(curr) && node.getLinks() == 1 && !node.isEnd()) {
                    sb.append(curr);
                    node = node.get(curr);
                } else {
                    return sb.toString();
                }
            }
            return sb.toString();
        }
    }

    @Test
    public void test() {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix4(strs[0], strs));
    }
}
