package methodThinking.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3.无重复字符的最长子串
 */
public class LengthOfLongestSubstring {
    /**
     * my solution
     */
    private int lengthOfLongestSubstring(String s) {
        int result = 1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.clear();
            for (int j = i; j < s.length(); j++) {
                set.add(s.charAt(j));
                if (set.size() != j - i + 1) break;
            }
            result = set.size() > result ? set.size() : result;
        }
        return s.length() > 0 ? result : 0;
    }

    /**
     * sliding window
     */
    private int slidingWindow(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, ans = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(j - i, ans);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * sliding window optimized
     */
    private int slidingWindowOptimized(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length(), ans = 0;
        for (int i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) i = Math.max(map.get(s.charAt(j)), i);
            ans = Math.max(j - i + 1, ans);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
