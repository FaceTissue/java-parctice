package methodThinking.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30.串联所有单词的子串
 */
public class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        int one_word = words[0].length();
        int word_num = words.length;
        if (s.length() < one_word * word_num) return res;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        Map<String, Integer> tmp_map = new HashMap<>();
        for (int i = 0; i < one_word; i++) {
            tmp_map.clear();
            int l = i, r = i, count = 0;
            while (r <= s.length()) {
                String tmp = s.substring(r, r + one_word);
                r += one_word;
                if (map.containsKey(tmp)) {
                    tmp_map.put(tmp, tmp_map.getOrDefault(tmp, 0) + 1);
                    count++;
                    // sliding window
                    while (tmp_map.get(tmp) > map.get(tmp)) {
                        String t_w = s.substring(l, l + one_word);
                        tmp_map.put(t_w, tmp_map.get(t_w) - 1);
                        l += one_word;
                        count--;
                    }
                    if (count == word_num) res.add(l);
                } else {
                    count = 0;
                    l = r;
                    tmp_map.clear();
                }
            }
        }
        return res;
    }
}
