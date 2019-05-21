package algorithm.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        String[] strs = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "xwyz"};
        List<String> result = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            String str = strs[digits.charAt(i) - '2'];
            char[] chars = str.toCharArray();
            if (result.size() == 0) {
                for (char c :chars) result.add(String.valueOf(c));
            } else {
                List<String> tmp = new ArrayList<>();
                for (char c : chars) {
                    for (String lc : result) {
                        tmp.add(lc + c);
                    }
                }
                result = tmp;
            }
        }
        return result;
    }

    // 深度优先搜索的递归实现
    public static String[] strs = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "xwyz"};

    public List<String> letterCombinations1(String digits) {
        List<String> result = new ArrayList<>();
        depthFirstRecursive(digits, 0, result, new StringBuilder());
        return result;
    }

    private void depthFirstRecursive(String digits, int idx, List<String> result, StringBuilder tmp) {
        if (idx == digits.length()) {
            result.add(tmp.toString());
            return ;
        }
        char[] chars = strs[digits.charAt(idx) - '2'].toCharArray();
        for (char c : chars) {
            depthFirstRecursive(digits, idx + 1, result, new StringBuilder(tmp.toString()).append(c));
        }
    }

    @Test
    public void test() {
        System.out.println(letterCombinations1("23"));
    }
}
